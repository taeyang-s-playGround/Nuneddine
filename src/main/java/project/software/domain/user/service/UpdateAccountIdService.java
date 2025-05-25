package project.software.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.user.controller.dto.request.UpdateAccountIdRequest;
import project.software.domain.user.domain.User;
import project.software.domain.user.domain.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateAccountIdService {

    public final UserRepository userRepository;
    public final UserFacade userFacade;

    public void execute(UpdateAccountIdRequest request) {
        User user = userFacade.getCurrentUser();

        user.updateAccountId(request.getAccountId());
        userRepository.save(user);
    }
}
