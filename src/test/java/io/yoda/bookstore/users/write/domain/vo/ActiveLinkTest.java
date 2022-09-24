package io.yoda.bookstore.users.write.domain.vo;

import io.yoda.bookstore.shared.utils.AESUtil;
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
import static org.junit.jupiter.api.Assertions.*;

class ActiveLinkTest {

    @Test
    void whenEmailIsNull_ShouldConstructorThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new ActiveLink(null));
    }

    @Test
    void whenEmailIsNull_ShouldOfThrowException() {
        assertThrows(IllegalArgumentException.class, () -> ActiveLink.of(null));
    }

    @Test
    void whenEmailIsValid_ShouldConstructorReturnObject() {
        Email email = new Email("user1@gmail.com");
        ActiveLink activeLink = new ActiveLink(email);
        assertNotNull(activeLink);
        assertThat(activeLink.getLink().startsWith("/users/active"), is(true));
        assertNotNull(activeLink.getCode());
    }
}