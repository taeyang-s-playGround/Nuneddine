package project.software.domain.auth.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class SignInRequest {

    @NotNull
    private String accountId;

    @NotNull
    private String password;

    @NotNull
    private String deviceToken;

}
