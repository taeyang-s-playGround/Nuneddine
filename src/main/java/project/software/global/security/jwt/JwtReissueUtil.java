package project.software.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.global.exception.ExpiredTokenException;
import project.software.global.exception.InvalidTokenException;
import project.software.global.security.TokenResponse;
import project.software.global.security.auth.AuthDetailsService;

@Service
@RequiredArgsConstructor
@Transactional
public class JwtReissueUtil {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    public TokenResponse reissue(String refreshToken) {

        if (!isRefreshToken(refreshToken)) {
            throw InvalidTokenException.EXCEPTION;
        }

        String accountId = getId(refreshToken);

        return TokenResponse.builder()
            .accessToken(jwtTokenProvider.createAccessToken(accountId))
            //.refreshToken(refreshToken)
            .build();
    }

    private String getId(String token) {
        return getClaims(token).getSubject();
    }

    private Claims getClaims(String token) {
        try {
            return Jwts
                .parser()
                .setSigningKey(jwtProperties.getSecretKey())
                .parseClaimsJws(token)
                .getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    private boolean isRefreshToken(String token) {
        return getClaims(token).get("type").equals("refresh");
    }

    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);
        UserDetails userDetails = authDetailsService.loadUserByUsername(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
}
