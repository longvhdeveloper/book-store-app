package io.yoda.bookstore.users.write.domain.entity;

import io.yoda.bookstore.users.write.domain.vo.*;
import lombok.Getter;

@Getter
public class User {
    private UserId userId;
    private final FullName fullName;
    private final Email email;
    private final CellPhone cellPhone;
    private final Password password;
    private final UserStatus status;

    public User(UserId userId, FullName fullName, Email email, CellPhone cellPhone, Password password, UserStatus status) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.cellPhone = cellPhone;
        this.password = password;
        this.status = status;
    }

    public User(FullName fullName, Email email, CellPhone cellPhone, Password password, UserStatus status) {
        this.fullName = fullName;
        this.email = email;
        this.cellPhone = cellPhone;
        this.password = password;
        this.status = status;
    }
}
