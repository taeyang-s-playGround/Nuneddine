package project.software.global.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@ConfigurationProperties("jwt")
public class JwtProperties {
    private final Long accessExp;
    private final Long refreshExp;
    private final String prefix;
    private final String header;
    private final String secretKey;

    public JwtProperties(Long accessExp, Long refreshExp, String prefix, String header, String secretKey) {
        this.accessExp = accessExp;
        this.refreshExp = refreshExp;
        this.prefix = prefix;
        this.header = header;
        this.secretKey = secretKey;
    }
}
