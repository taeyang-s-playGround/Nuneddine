package project.software.domain.auth.controller.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequest {

    @NotNull
    private String accountId;

    @NotNull
    private String name;

    @NotNull
    private String password;

    @NotNull
    private String deviceToken;
}
