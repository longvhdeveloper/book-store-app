package io.yoda.bookstore.users.write.domain.vo;

import lombok.Getter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Random;

@Getter
public class Password {
    private static final String HASH_ALGORITHM = "SHA-256";

    private final String value;
    private final String salt;

    public Password(final String value, final String salt) {
        validate(value, salt);
        this.value = value;
        this.salt = salt;
    }

    public static Password of(final String value, final String salt) {
        return new Password(value, salt);
    }

    public static Password of(final String value) {
        if (Objects.isNull(value) || value.isEmpty()) {
            throw new IllegalArgumentException("password value is not valid");
        }
        String salt = getRandomString();
        return generatePassword(value, salt);
    }

    private void validate(final String value, final String salt) {
        if (Objects.isNull(value) || value.isEmpty()) {
            throw new IllegalArgumentException("password value is not valid");
        }

        if (Objects.isNull(salt) || salt.isEmpty()) {
            throw new IllegalArgumentException("password salt is not valid");
        }
    }

    private static Password generatePassword(final String value, final String salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            byte[] bytes = digest.digest(String.format("%s.%s", value, salt).getBytes(StandardCharsets.UTF_8));
            return new Password(bytesToHex(bytes), salt);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(final byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte aByte : bytes) {
            String hex = Integer.toHexString(0xff & aByte);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private static String getRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
