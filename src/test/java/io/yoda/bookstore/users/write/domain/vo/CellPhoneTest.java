package io.yoda.bookstore.users.write.domain.vo;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CellPhoneTest {

    @Test
    void whenValueIsNull_ShouldConstructorThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new CellPhone(null));
    }

    @Test
    void whenValueIsEmpty_ShouldConstructorThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new CellPhone(null));
    }

    @Test
    void whenValueIsNull_ShouldOfThrowException() {
        assertThrows(IllegalArgumentException.class, () -> CellPhone.of(null));
    }

    @Test
    void whenValueIsEmpty_ShouldOfThrowException() {
        assertThrows(IllegalArgumentException.class, () -> CellPhone.of(null));
    }

    @Test
    void whenValueIsValid_ShouldConstructorReturnObject() {
        final String value = "0123456789";
        CellPhone cellPhone = new CellPhone(value);
        assertNotNull(cellPhone);
        assertThat(cellPhone.getValue(), is(value));
    }

    @Test
    void whenValueIsValid_ShouldOfReturnObject() {
        final String value = "0123456789";
        CellPhone cellPhone = CellPhone.of(value);
        assertNotNull(cellPhone);
        assertThat(cellPhone.getValue(), is(value));
    }
}