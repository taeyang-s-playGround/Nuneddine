package project.software.domain.address.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.address.controller.dto.response.AllAddressResponse;
import project.software.domain.address.domain.Address;
import project.software.domain.address.domain.repository.AddressRepository;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.user.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GetAddressService {

    private final UserFacade userFacade;
    private final AddressRepository addressRepository;

    public AllAddressResponse execute() {
        User user = userFacade.getCurrentUser();

        List<Address> addressList = addressRepository.findAllByUserId(user.getId());
        return AllAddressResponse.from(addressList);
    }
}
