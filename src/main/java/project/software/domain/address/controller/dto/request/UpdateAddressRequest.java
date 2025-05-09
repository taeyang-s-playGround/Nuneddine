package project.software.domain.address.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
public class UpdateAddressRequest {

    @NotBlank
    private String address;
}
