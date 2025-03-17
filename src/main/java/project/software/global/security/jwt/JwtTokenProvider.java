package project.software.global.security.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import project.software.domain.auth.domain.RefreshToken;
import project.software.domain.auth.domain.repository.RefreshTokenRepository;
import project.software.global.exception.ExpiredTokenException;
import project.software.global.security.TokenResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;

    public TokenResponse createToken(String accountId) {
        return TokenResponse
            .builder()
            .accessToken(createAccessToken(accountId))
            //.refreshToken(createRefreshToken(accountId))
            .build();
    }

    // JWT 토큰 생성
    public String createAccessToken(String accountId) {

        Claims claims = Jwts.claims().setSubject(accountId);
        Date now = new Date();

        String accessToken = Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(new Date(now.getTime() + jwtProperties.getAccessExp() * 1000))
            .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
            .compact();
        return accessToken;
    }

    public String createRefreshToken(String accountId) {
        Date now = new Date();

        String refreshToken = Jwts.builder()
            .setSubject(accountId)
            .claim("type", "refresh")
            .setIssuedAt(now)
            .setExpiration(new Date(now.getTime() + jwtProperties.getRefreshExp() * 1000))
            .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecretKey())
            .compact();

        refreshTokenRepository.save(
            RefreshToken.builder()
                .accountId(accountId)
                .refreshToken(refreshToken)
                .expiration(jwtProperties.getRefreshExp())
                .build());

        return refreshToken;
    }

    public String resolveToken(HttpServletRequest request) {

        String bearerToken = request.getHeader(jwtProperties.getHeader());

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(jwtProperties.getPrefix())
            && bearerToken.length() > jwtProperties.getPrefix().length() + 1) {
            return bearerToken.substring(7);
        }
        return null;
    }

    //토큰에서 회원 정보 추출
    private Claims getBody(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtProperties.getSecretKey()).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;

        }
    }

    //만료일자 확인
    public void validateToken(String jwtToken) {
        Claims body = getBody(jwtToken);
        if (body.getExpiration().before(new Date())) {
            throw ExpiredTokenException.EXCEPTION;
        }
    }
}
