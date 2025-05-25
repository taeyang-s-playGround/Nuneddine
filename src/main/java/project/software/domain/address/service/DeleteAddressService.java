

package project.software.domain.address.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.address.domain.Address;
import project.software.domain.address.domain.repository.AddressRepository;
import project.software.domain.address.exception.AddressNotFoundException;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.user.domain.User;
import project.software.domain.user.exception.UserMisMatchException;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteAddressService {

    private final UserFacade userFacade;
    private final AddressRepository addressRepository;

    public void execute(Long addressId) {
        User user = userFacade.getCurrentUser();

        Address address = addressRepository.findById(addressId)
            .orElseThrow(() -> AddressNotFoundException.EXCEPTION);

        if(!address.getUser().equals(user)) {
            throw UserMisMatchException.EXCEPTION;
        }

        addressRepository.deleteById(address.getId());
    }
}
