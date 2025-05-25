package project.software.domain.cart.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ChangeOptionRequest {

    private Float lensPower;

    private Long count;

}
