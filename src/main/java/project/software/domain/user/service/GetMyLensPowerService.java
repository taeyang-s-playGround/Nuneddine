package project.software.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.user.controller.dto.response.GetMyLensPowerResponse;
import project.software.domain.user.domain.User;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetMyLensPowerService {

    private final UserFacade userFacade;

    public GetMyLensPowerResponse execute() {
        User user = userFacade.getCurrentUser();
        return new GetMyLensPowerResponse(user);
    }
}
