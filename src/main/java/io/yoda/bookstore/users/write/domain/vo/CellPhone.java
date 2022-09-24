package io.yoda.bookstore.users.write.domain.vo;

import lombok.Getter;

import java.util.Objects;

@Getter
public class CellPhone {
    private final String value;

    public CellPhone(final String value) {
        validate(value);
        this.value = value;
    }

    public static CellPhone of(final String value) {
        return new CellPhone(value);
    }

    private void validate(final String value) {
        if (Objects.isNull(value) || value.isEmpty()) {
            throw new IllegalArgumentException("cellphone is not valid.");
        }
    }
}
