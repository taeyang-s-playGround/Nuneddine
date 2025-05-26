package project.software.domain.cart.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class ChangeOptionRequest {

    @NotNull
    private Float lensPower;

    @NotNull
    private Long count;

}
