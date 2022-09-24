package io.yoda.bookstore.users.write.domain.vo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UserIdTest {

    @Test
    void whenUserIdIsLessThan1_ShouldConstructorThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new UserId(0));
    }

    @Test
    void whenUserIdIsLessThan1_ShouldOfThrowException() {
        assertThrows(IllegalArgumentException.class, () -> UserId.of(0));
    }

    @Test
    void whenUserIdIsValid_ShouldConstructorReturnObject() {
        UserId id = new UserId(10);
        assertThat(id.getId(), is(10L));
    }

    @Test
    void whenUserIdIsValid_ShouldOfReturnObject() {
        UserId id = new UserId(5);
        assertNotNull(id);
        assertThat(id.getId(), is(5L));
    }
}