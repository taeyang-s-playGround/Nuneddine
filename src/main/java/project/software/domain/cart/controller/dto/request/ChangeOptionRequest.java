package project.software.domain.cart.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
public class ChangeOptionRequest {

    @NotBlank
    private Float lensPower;

    @NotBlank
    private Long count;

}
