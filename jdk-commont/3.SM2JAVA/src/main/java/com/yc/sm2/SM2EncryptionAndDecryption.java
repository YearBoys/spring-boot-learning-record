package com.yc.sm2;

import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.SM2Engine;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.bouncycastle.jce.spec.ECParameterSpec;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

/**
 *
 *  公钥加密 私钥解密
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 09:57 2023/5/26
 */
public class SM2EncryptionAndDecryption {



    /**
     * 根据publicKey对原始数据data，使用SM2加密
     *
     * @param data
     * @param publicKey
     * @return
     */
    public static byte[] encrypt(byte[] data, PublicKey publicKey) {
        ECPublicKeyParameters localECPublicKeyParameters = null;

        if (publicKey instanceof BCECPublicKey) {
            BCECPublicKey localECPublicKey = (BCECPublicKey) publicKey;
            ECParameterSpec localECParameterSpec = localECPublicKey.getParameters();
            ECDomainParameters localECDomainParameters = new ECDomainParameters(localECParameterSpec.getCurve(),
                    localECParameterSpec.getG(), localECParameterSpec.getN());
            localECPublicKeyParameters = new ECPublicKeyParameters(localECPublicKey.getQ(), localECDomainParameters);
        }
        SM2Engine localSM2Engine = new SM2Engine();
        localSM2Engine.init(true, new ParametersWithRandom(localECPublicKeyParameters, new SecureRandom()));
        byte[] arrayOfByte2;
        try {
            arrayOfByte2 = localSM2Engine.processBlock(data, 0, data.length);
            return arrayOfByte2;
        } catch (InvalidCipherTextException e) {

            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据privateKey对加密数据encodedata，使用SM2解密
     *
     * @param encodedata
     * @param privateKey
     * @return
     */
    public static byte[] decrypt(byte[] encodedata, PrivateKey privateKey) {
        SM2Engine localSM2Engine = new SM2Engine();
        BCECPrivateKey sm2PriK = (BCECPrivateKey) privateKey;
        ECParameterSpec localECParameterSpec = sm2PriK.getParameters();
        ECDomainParameters localECDomainParameters = new ECDomainParameters(localECParameterSpec.getCurve(),
                localECParameterSpec.getG(), localECParameterSpec.getN());
        ECPrivateKeyParameters localECPrivateKeyParameters = new ECPrivateKeyParameters(sm2PriK.getD(),
                localECDomainParameters);
        localSM2Engine.init(false, localECPrivateKeyParameters);
        try {
            byte[] arrayOfByte3 = localSM2Engine.processBlock(encodedata, 0, encodedata.length);
            return arrayOfByte3;
        } catch (InvalidCipherTextException e) {
            e.printStackTrace();
            return null;
        }
    }


}
