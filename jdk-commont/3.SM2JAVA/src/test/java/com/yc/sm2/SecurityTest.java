package com.yc.sm2;

import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 17:31 2023/5/25
 */
@SpringBootTest
public class SecurityTest {


    //公钥
    final static String publicKey = "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEi5zodLc/ORwEeLxhAMut4z+Vy4AgFTgw/LSq5yLxHTjXU46no4musAg+FuWpcStGI32INJskp1vQZenCvi+JMQ==";
    //私钥
    final static String privateKey = "MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQg+DPZ1KFl8rTSHTpRtIIK8nDLYFOal4WzIe9bRmyMvx2gCgYIKoEcz1UBgi2hRANCAASLnOh0tz85HAR4vGEAy63jP5XLgCAVODD8tKrnIvEdONdTjqejia6wCD4W5alxK0YjfYg0mySnW9Bl6cK+L4kx";


    /**
     * 生成SM2 keypair  公私钥
     *
     * @throws InvalidAlgorithmParameterException
     * @throws NoSuchAlgorithmException
     */
    @Test
    void SM2KeyGenerate() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException {
        KeyPairGenerator generator = SM2KeyGenerateFactory.generator();

        // 获取密钥对
        KeyPair keyPair = generator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // ------------------------ SM2未压缩公钥 ----------------------------
        // 椭圆曲线公钥的点坐标
        ECPoint pubKeyPointQ = ((BCECPublicKey) publicKey).getQ();
        System.out.println("X: \n" + pubKeyPointQ.getXCoord());
        System.out.println("Y: \n" + pubKeyPointQ.getYCoord());
        // 将其表示为SM2未压缩的公钥为
        System.out.println("SM2 public key: \n"
                + "04"
                + pubKeyPointQ.getXCoord().toString()
                + pubKeyPointQ.getYCoord().toString()
        );

        // ------------------------ SM2未压缩公钥 -------------------------------

        // 转 16 进制
        System.out.println("Public key: \n" + Hex.toHexString(publicKey.getEncoded()));
        System.out.println("Private key: \n" + Hex.toHexString(privateKey.getEncoded()));

        // 转 BASE64  使用base64较多(推荐)
        System.out.println(">> 公钥BASE64: " + Base64.toBase64String(publicKey.getEncoded()));
        System.out.println(">> 私钥BASE64: " + Base64.toBase64String(privateKey.getEncoded()));

    }



    /**
     *   私钥签名 公钥 验签
     *       <p>
     *           一般来说私钥是调用方使用，调用方使用私钥加密
     *         被调用方验签
     *         因为SM2 为非对称加密 所以传输的数据加密可配合SM4 使用  SM4 为对称加密
     *       </p>
     *
     */
    @Test
    void PublicKeyCheck() throws Exception {
        // 签名原文
        byte[] plainText = "你好".getBytes(StandardCharsets.UTF_8);

        // 签名值
        byte[] bytes = SM2Signature.signByPrivateKey(plainText,SM2Signature.createPrivateKey(privateKey));


        // 转base64
        String s = Base64.toBase64String(bytes);
        System.out.println(Base64.toBase64String(bytes));
        // 验签
        System.out.println(SM2Signature.verifyByPublicKey(plainText, SM2Signature.createPublicKey(publicKey), bytes));
    }



    /**
     *   公钥签名 私钥解密
     *      <p> 当前场景为 被调用方向调用方返回数据
     *         需要用公钥加密
     *          调用方拿到数据后需要做解密
     *      </p>
     *
     */
    @Test
    void PrivateKeyCheck() throws Exception {
        //   公钥签名
        // 签名原文
        byte[] plainText = "你好".getBytes(StandardCharsets.UTF_8);
        // 序列化公钥
        PublicKey publicKey = SM2Signature.createPublicKey(SecurityTest.publicKey);
        // 公钥加密
        byte[] encrypt = SM2EncryptionAndDecryption.encrypt(plainText, publicKey);
        // 转Base64   秘文
        String s = Base64.toBase64String(encrypt);
        // 转会字节数组
        byte[] decode = Base64.decode(s);
        System.out.println(Arrays.equals(encrypt, decode));
        //私钥 解密
        byte[] decrypt = SM2EncryptionAndDecryption.decrypt(encrypt, SM2Signature.createPrivateKey(privateKey));

        // 转字符串
        System.out.println(new String(decrypt, "utf-8"));

    }

}
