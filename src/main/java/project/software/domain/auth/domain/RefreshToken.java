package project.software.domain.auth.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@Builder
@RedisHash
public class RefreshToken{

    @Id
    private String accountId;

    private String refreshToken;

    private Long expiration;

    public RefreshToken updateExpiration(Long expiration) {
        this.expiration = expiration;
        return this;
    }
}