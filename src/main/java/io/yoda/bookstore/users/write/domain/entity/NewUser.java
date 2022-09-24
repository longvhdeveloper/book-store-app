package io.yoda.bookstore.users.write.domain.entity;

import io.yoda.bookstore.users.write.domain.vo.ActiveLink;
import lombok.Getter;

import java.util.Objects;

@Getter
public class NewUser implements UserState {
    private final User user;
    private final ActiveLink activeLink;

    public NewUser(User user, ActiveLink activeLink) {
        this.user = user;
        this.activeLink = activeLink;
    }

    @Override
    public void process() {
        // validate code is valid user

        // validate is still in expire date

        // set status is ACTIVATED
    }

    private void validate(final User user) {
        if (Objects.isNull(user)) {
            throw new IllegalArgumentException("user is not valid");
        }

        if (Objects.isNull(activeLink)) {
            throw new IllegalArgumentException("active link is not valid");
        }

        if (!UserStatus.NEW.equals(user.getStatus())) {
            throw new IllegalArgumentException(String.format("user with id: %d is not status new.",
                    user.getUserId().getId()));
        }
    }
}
