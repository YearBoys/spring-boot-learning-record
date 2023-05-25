package com.yc.sm2;

import org.bouncycastle.asn1.gm.GMObjectIdentifiers;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 *
 *  公私钥签名
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 17:56 2023/5/25
 */
public class SM2Signature {


    /**
     * 反序列化私钥
     */
    public static PrivateKey createPrivateKey(String privateKey) {
        PrivateKey publickey = null;
        try {
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
            KeyFactory keyFactory = KeyFactory.getInstance("EC", new BouncyCastleProvider());
            publickey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publickey;
    }

        /**
         * 私钥签名
         *
         * @param data        待签名数据
         * @param privateKey   私钥
         * @return
         * @throws Exception
         */
    public static byte[] signByPrivateKey(byte[] data, PrivateKey privateKey) throws Exception {
        Signature sig = Signature.getInstance(GMObjectIdentifiers.sm2sign_with_sm3.toString(), new BouncyCastleProvider());
        // 签名需要使用私钥，使用私钥 初始化签名实例
        sig.initSign(privateKey);
        // 写入签名原文到算法中
        sig.update(data);
        // 计算签名值
        byte[] ret = sig.sign();
        return ret;
    }


    /**
     * 公钥验签
     *
     * @param data        原文
     * @param publicKey    公钥
     * @param signature     加密后字符串
     * @return
     * @throws Exception
     */
    public static boolean verifyByPublicKey(byte[] data, PublicKey publicKey, byte[] signature) throws Exception {
        Signature sig = Signature.getInstance(GMObjectIdentifiers.sm2sign_with_sm3.toString(), new BouncyCastleProvider());
        sig.initVerify(publicKey);
        sig.update(data);
        boolean ret = sig.verify(signature);
        return ret;
    }

    /**
     * 反序列化公钥
     *
     * @param publicKey
     * @return
     */
    public static PublicKey createPublicKey(String publicKey) {
        PublicKey publickey = null;
        try {
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey));
            KeyFactory keyFactory = KeyFactory.getInstance("EC", new BouncyCastleProvider());
            publickey = keyFactory.generatePublic(publicKeySpec);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publickey;
    }

}


