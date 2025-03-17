package project.software.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.global.security.TokenResponse;
import project.software.global.security.jwt.JwtReissueUtil;
import project.software.global.security.jwt.JwtTokenProvider;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class ReissueService {

    private final JwtReissueUtil jwtReissueUtil;
    private final JwtTokenProvider jwtProvider;

    @Transactional
    public TokenResponse execute(HttpServletRequest request) {
        return jwtReissueUtil.reissue(jwtProvider.resolveToken(request));
    }
}
