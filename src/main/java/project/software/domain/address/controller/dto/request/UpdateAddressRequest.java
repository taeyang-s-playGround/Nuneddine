package project.software.domain.address.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class UpdateAddressRequest {

    @NotNull
    private String address;

    @NotNull
    private String deliveryAddressName;

    @NotNull
    private String detailAddress;

    @NotNull
    private String postCode;

    @NotNull
    private String receiver;

    @NotNull
    private String phoneNumber;
}
