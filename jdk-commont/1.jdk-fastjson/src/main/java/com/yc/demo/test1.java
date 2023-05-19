package com.yc.demo;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 15:19 2023/5/11
 */
public class test1 {

    public static void main(String[] args) throws Exception {
        test1 test1=new test1();
        test1.
        generateSm2Key();
    }

    KeyPair  generateSm2Key() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException {
        // 获取SM2椭圆曲线的参数
        final ECGenParameterSpec sm2Spec = new ECGenParameterSpec("sm2p256v1");
        // 获取一个椭圆曲线类型的密钥对生成器
        final KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC", new BouncyCastleProvider());
// 使用SM2参数初始化生成器
        kpg.initialize(sm2Spec);

// 使用SM2的算法区域初始化密钥生成器
        kpg.initialize(sm2Spec, new SecureRandom());
        // 获取密钥对
        KeyPair keyPair = kpg.generateKeyPair();
        return keyPair;
    }


}
