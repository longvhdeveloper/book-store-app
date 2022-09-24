package io.yoda.bookstore.shared.utils;

import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class AESUtilTest {
    @Test
    void givenString_whenEncrypt_thenSuccess()
            throws NoSuchAlgorithmException, IllegalBlockSizeException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException {

        String input = "hello";
        SecretKey key = AESUtil.generateKey(128);
        IvParameterSpec ivParameterSpec = AESUtil.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";
        String cipherText = AESUtil.encrypt(algorithm, input, key, ivParameterSpec);
        String plainText = AESUtil.decrypt(algorithm, cipherText, key, ivParameterSpec);
        assertThat(input, is(plainText));
    }
}