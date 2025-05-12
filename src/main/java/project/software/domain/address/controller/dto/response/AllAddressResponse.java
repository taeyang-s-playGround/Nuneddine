package project.software.domain.address.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.software.domain.address.domain.Address;

import java.util.List;

@AllArgsConstructor
@Getter
public class AllAddressResponse {

    private final List<AddressResponse> addresses;

    public static AllAddressResponse from(List<Address> addresses) {
        return new AllAddressResponse(
            addresses.stream()
                .map(address -> AddressResponse.builder()
                    .id(address.getId())
                    .address(address.getAddress())
                    .detailAddress(address.getDetailAddress())
                    .postCode(address.getPostCode())
                    .receiver(address.getReceiver())
                    .phoneNumber(address.getPhoneNumber())
                    .build()
                )
                .toList()
        );
    }

    @Getter
    @Builder
    public static class AddressResponse {
        private final Long id;
        private final String address;
        private final String detailAddress;
        private final String postCode;
        private final String receiver;
        private final String phoneNumber;
    }
}
