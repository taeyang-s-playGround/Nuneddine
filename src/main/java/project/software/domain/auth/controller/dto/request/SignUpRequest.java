package project.software.domain.auth.controller.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequest {

    @NotBlank
    private String accountId;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    private String deviceToken;
}
