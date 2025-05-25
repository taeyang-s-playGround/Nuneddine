package project.software.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.user.controller.dto.request.UpdateLensPowerRequest;
import project.software.domain.user.domain.User;
import project.software.domain.user.domain.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateMyLensPowerService {

    public final UserRepository userRepository;
    public final UserFacade userFacade;

    public void execute(UpdateLensPowerRequest request) {
    User user = userFacade.getCurrentUser();

        user.updateLensPower(request.getLeftLensPower(), request.getRightLensPower());
        userRepository.save(user);
    }
}
