package io.yoda.bookstore.users.write.domain.vo;

import lombok.Getter;

@Getter
public class UserId {
    private final long id;

    public UserId(final long id) {
        validate(id);
        this.id = id;
    }

    public static UserId of(final long id) {
        return new UserId(id);
    }

    private void validate(final long id) {
        if (id < 1) {
            throw new IllegalArgumentException(String.format("user id %d is not valid.", id));
        }
    }
}
