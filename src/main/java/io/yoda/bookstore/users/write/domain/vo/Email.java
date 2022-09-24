package io.yoda.bookstore.users.write.domain.vo;

import lombok.Getter;

import java.util.Objects;
import java.util.regex.Pattern;

@Getter
public class Email {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\." +
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";

    private final String value;

    public Email(final String value) {
        validate(value);
        this.value = value;
    }

    public static Email of(final String value) {
        return new Email(value);
    }

    private void validate(final String value) {
        if (Objects.isNull(value) || value.isEmpty()) {
            throw new IllegalArgumentException("email is not valid.");
        }

        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        if (!pattern.matcher(value).matches()) {
            throw new IllegalArgumentException(String.format("email %s is not valid.", value));
        }
    }
}
