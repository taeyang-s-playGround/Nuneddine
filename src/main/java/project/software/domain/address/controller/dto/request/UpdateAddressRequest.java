package project.software.domain.address.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
public class UpdateAddressRequest {

    @NotBlank
    private String address;

    @NotBlank
    private String detailAddress;

    @NotBlank
    private String postCode;

    @NotBlank
    private String receiver;

    @NotBlank
    private String phoneNumber;
}
