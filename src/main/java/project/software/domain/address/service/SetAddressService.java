package project.software.domain.address.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.address.controller.dto.request.SetAddressRequest;
import project.software.domain.address.domain.Address;
import project.software.domain.address.domain.repository.AddressRepository;
import project.software.domain.address.exception.AddressNotFoundException;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.user.domain.User;
import project.software.domain.user.exception.UserNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional
public class SetAddressService {

    private final UserFacade userFacade;
    private final AddressRepository addressRepository;

    public void execute(SetAddressRequest request) {
        User user = userFacade.GetCurrentUser();

        Address address = addressRepository.findByUserId(user.getId())
            .orElseThrow(() -> AddressNotFoundException.EXCEPTION);

        address.updateAddress(request.getAddress());
    }
}
