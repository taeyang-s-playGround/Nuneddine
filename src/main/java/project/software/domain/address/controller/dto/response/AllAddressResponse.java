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
    }
}
