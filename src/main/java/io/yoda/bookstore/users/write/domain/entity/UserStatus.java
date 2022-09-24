package io.yoda.bookstore.users.write.domain.entity;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public enum UserStatus {
    NEW(1),
    ACTIVATED(5),
    DEACTIVATED(10),
    BANNED(20);

    @Getter
    private final int value;

    private static final Map<Integer, UserStatus> map = new HashMap<>();

    static {
        for (UserStatus userStatus : values()) {
            map.put(userStatus.getValue(), userStatus);
        }
    }

    UserStatus(int value) {
        this.value = value;
    }

    public static UserStatus valueOf(int value) {
        return map.get(value);
    }
}
