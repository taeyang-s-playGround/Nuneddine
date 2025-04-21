package project.software.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.user.controller.dto.request.UpdateAddressRequest;
import project.software.domain.user.domain.User;
import project.software.domain.user.domain.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateMyAddressService {

    public final UserRepository userRepository;
    public UserFacade userFacade;

    public void execute(UpdateAddressRequest request) {
    User user = userFacade.GetCurrentUser();

        user.updateAddress(request.getAddress());
        userRepository.save(user);
    }
}
