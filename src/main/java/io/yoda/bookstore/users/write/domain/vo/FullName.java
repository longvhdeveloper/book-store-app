package io.yoda.bookstore.users.write.domain.vo;

import lombok.Getter;

import java.util.Objects;

@Getter
public class FullName {

    private final String firstName;
    private final String lastName;

    public FullName(final String firstName, final String lastName) {
        validate(firstName, lastName);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static FullName of(final String firstName, final String lastName) {
        return new FullName(firstName, lastName);
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    private void validate(final String firstName, final String lastName) {
        if (Objects.isNull(firstName) || firstName.isEmpty()) {
            throw new IllegalArgumentException("first name is not valid");
        }

        if (Objects.isNull(lastName) || lastName.isEmpty()) {
            throw new IllegalArgumentException("last name is not valid");
        }
    }
}
