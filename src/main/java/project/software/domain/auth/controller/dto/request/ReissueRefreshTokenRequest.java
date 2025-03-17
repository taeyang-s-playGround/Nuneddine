package project.software.domain.auth.controller.dto.request;

import lombok.Getter;

@Getter
public class ReissueRefreshTokenRequest {
    private String token;
}
