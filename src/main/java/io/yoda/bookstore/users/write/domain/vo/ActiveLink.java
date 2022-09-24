package io.yoda.bookstore.users.write.domain.vo;

import io.yoda.bookstore.shared.utils.AESUtil;
import lombok.Getter;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

@Getter
public class ActiveLink {
    private static final String PATH = "/users/active";
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    private final Email email;
    private final String link;
    private String code;
    private final Date expiredDate;

    public ActiveLink(final Email email) {
        validate(email);
        this.email = email;
        this.link = generateLink();
        this.expiredDate = createExpiredDate();
    }

    public static ActiveLink of(final Email email) {
        return new ActiveLink(email);
    }

    private void validate(final Email email) {
        if (Objects.isNull(email)) {
            throw new IllegalArgumentException("email for active link is not valid.");
        }
    }

    private String generateLink() {
        try {
            final SecretKey key = AESUtil.generateKey(128);
            final IvParameterSpec ivParameterSpec = AESUtil.generateIv();
            this.code = AESUtil.encrypt(ALGORITHM, email.getValue(), key,
                    ivParameterSpec);
            return String.format("%s?code=%s", PATH, code);
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException | NoSuchPaddingException |
                 IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    private Date createExpiredDate() {
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(7);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
