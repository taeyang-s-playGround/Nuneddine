

package project.software.domain.address.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.address.controller.dto.request.UpdateAddressRequest;
import project.software.domain.address.domain.Address;
import project.software.domain.address.domain.repository.AddressRepository;
import project.software.domain.address.exception.AddressNotFoundException;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.user.domain.User;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteAddressService {

    private final UserFacade userFacade;
    private final AddressRepository addressRepository;

    public void execute(Long addressId) {
        User user = userFacade.GetCurrentUser();

        Address address = addressRepository.findById(addressId)
            .orElseThrow(() -> AddressNotFoundException.EXCEPTION);

        addressRepository.deleteById(address.getId());
    }
}
