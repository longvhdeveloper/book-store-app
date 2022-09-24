package io.yoda.bookstore.users.write.domain.vo;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordTest {

    @Test
    void whenValueIsNull_ShouldConstructorThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Password(null, "salt"));
    }

    @Test
    void whenValueIsEmpty_ShouldConstructorThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Password("", "salt"));
    }

    @Test
    void whenSaltIsNull_ShouldConstructorThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Password("123456", null));
    }

    @Test
    void whenSaltIsEmpty_ShouldConstructorThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Password("123456", ""));
    }

    @Test
    void whenValueIsNull_ShouldOfThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Password.of(null, "salt"));
    }

    @Test
    void whenValueIsEmpty_ShouldOfThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Password.of("", "salt"));
    }

    @Test
    void whenSaltIsNull_ShouldOfThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Password.of("12345", null));
    }

    @Test
    void whenSaltIsEmpty_ShouldOfThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Password.of("12345", ""));
    }

    @Test
    void whenValueIsNull_ShouldOfWithOutSaltThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Password.of(null));
    }

    @Test
    void whenValueIsEmpty_ShouldOfWithOutSaltThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Password.of(""));
    }

    @Test
    void whenValueAnSaltIsValid_ShouldConstructorReturnObject() {
        Password password = new Password("123456", "1q2w3e4r");
        assertNotNull(password);
        assertThat(password.getValue(), is("123456"));
        assertThat(password.getSalt(), is("1q2w3e4r"));
    }

    @Test
    void whenValueAnSaltIsValid_ShouldOfReturnObject() {
        Password password = Password.of("123456", "1q2w3e4r");
        assertNotNull(password);
        assertThat(password.getValue(), is("123456"));
        assertThat(password.getSalt(), is("1q2w3e4r"));
    }

    @Test
    void whenValueIsValid_ShouldOfReturnObjectWithSaltGenerated() {
        Password password = Password.of("123456");
        assertNotNull(password);
        assertThat(password.getValue(), not("123456"));
        assertNotNull(password.getSalt());
    }
}