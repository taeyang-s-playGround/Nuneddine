package project.software.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.software.global.security.security.jwt.JwtTokenProvider;

@Service
@RequiredArgsConstructor
public class ReissueService {

    private final JwtTokenProvider jwtProvider;
/*
    @Transactional
    public TokenResponse execute(HttpServletRequest request) {
        return jwtReissueUtil.reissue(jwtProvider.resolveToken(request));
    }

 */
}
