package project.software.domain.address.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.software.domain.address.controller.dto.request.UpdateAddressRequest;
import project.software.domain.address.controller.dto.response.AllAddressResponse;
import project.software.domain.address.service.DeleteAddressService;
import project.software.domain.address.service.GetAddressService;
import project.software.domain.address.service.SetAddressService;
import project.software.domain.address.service.UpdateAddressService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final SetAddressService setAddressService;
    private final UpdateAddressService updateAddressService;
    private final DeleteAddressService deleteAddressService;
    private final GetAddressService getAddressService;

    @PostMapping
    public void SetAddress(@RequestBody @Valid UpdateAddressRequest request) {
        setAddressService.execute(request);
    }

    @PatchMapping("/{address-id}")
    public void updateAddress(@PathVariable("address-id") Long addressId, @RequestBody UpdateAddressRequest request) {
        updateAddressService.execute(addressId, request);
    }

    @DeleteMapping("/{address-id}")
    public void deleteAddress(@PathVariable("address-id") Long addressId) {
        deleteAddressService.execute(addressId);
    }

    @GetMapping
    public AllAddressResponse getAddressList() {
        return getAddressService.execute();
    }
}
