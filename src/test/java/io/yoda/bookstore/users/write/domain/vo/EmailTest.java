package io.yoda.bookstore.users.write.domain.vo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmailTest {

    @Test
    void whenValueIsNull_ShouldConstructorThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
    }

    @Test
    void whenValueIsEmpty_ShouldConstructorThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
    }

    @Test
    void whenValueIsNotValid_ShouldConstructorThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Email("contribute@mybookstore..org"));
    }

    @Test
    void whenValueIsNull_ShouldOfThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Email.of(null));
    }

    @Test
    void whenValueIsEmpty_ShouldOfThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Email.of(""));
    }

    @Test
    void whenValueIsNotValid_ShouldOfThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Email.of("contribute@mybookstore..org"));
    }

    @Test
    void whenValueIsValid_ShouldConstructorReturnObject() {
        final String value = "contribute@mybookstore.com";
        Email email = new Email(value);
        assertNotNull(email);
        assertThat(email.getValue(), is(value));
    }

    @Test
    void whenValueIsValid_ShouldOfReturnObject() {
        final String value = "contribute@mybookstore.com";
        Email email = Email.of(value);
        assertNotNull(email);
        assertThat(email.getValue(), is(value));
    }
}