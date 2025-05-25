package project.software.domain.cart.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class DeleteCartsRequest {

    private List<Long> cartIds;

}
