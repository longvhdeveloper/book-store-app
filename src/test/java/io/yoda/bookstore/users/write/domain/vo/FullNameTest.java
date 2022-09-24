package io.yoda.bookstore.users.write.domain.vo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FullNameTest {

    @Test
    void whenFirstNameIsNull_ShouldConstructorThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new FullName(null, "Allen"));
    }

    @Test
    void whenFirstNameIsEmpty_ShouldConstructorThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new FullName("", "Allen"));
    }

    @Test
    void whenFirstNameIsNull_ShouldOfThrowException() {
        assertThrows(IllegalArgumentException.class, () -> FullName.of(null, "Allen"));
    }

    @Test
    void whenFirstNameIsEmpty_ShouldOfThrowException() {
        assertThrows(IllegalArgumentException.class, () -> FullName.of("", "Allen"));
    }


    @Test
    void whenLastNameIsNull_ShouldConstructorThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new FullName("Tim", null));
    }

    @Test
    void whenLastNameIsEmpty_ShouldConstructorThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new FullName("Tim", ""));
    }

    @Test
    void whenLastNameIsNull_ShouldOfThrowException() {
        assertThrows(IllegalArgumentException.class, () -> FullName.of("Tim", null));
    }

    @Test
    void whenLastNameIsEmpty_ShouldOfThrowException() {
        assertThrows(IllegalArgumentException.class, () -> FullName.of("Tim", ""));
    }

    @Test
    void whenValueIsValid_ShouldConstructorReturn() {
        FullName fullName = new FullName("Jack", "Health");
        assertNotNull(fullName);
        assertThat(fullName.getFirstName(), is("Jack"));
        assertThat(fullName.getLastName(), is("Health"));
        assertThat(fullName.getFullName(), is("Jack Health"));
    }

    @Test
    void whenValueIsValid_ShouldOfReturn() {
        FullName fullName = FullName.of("Jack", "Health");
        assertNotNull(fullName);
        assertThat(fullName.getFirstName(), is("Jack"));
        assertThat(fullName.getLastName(), is("Health"));
        assertThat(fullName.getFullName(), is("Jack Health"));
    }
}