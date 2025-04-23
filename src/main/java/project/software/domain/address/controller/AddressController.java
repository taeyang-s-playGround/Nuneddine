package project.software.domain.address.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    //private final SetAddressService setAddressService;
/*
    @PostMapping
    public void setAddress(@RequestBody SetAddressRequest request) {
        setAddressService.execute(request);
    }

 */
}
