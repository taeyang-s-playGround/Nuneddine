package project.software.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.controller.dto.request.GuestSignUpRequest;
import project.software.domain.user.domain.User;
import project.software.domain.user.domain.repository.UserRepository;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Transactional
public class SignUpGuestService {

    private final UserRepository userRepository;

    public String execute(GuestSignUpRequest guestSignUpRequest) {

        String customGuestId = UUID.randomUUID().toString();

        User user = userRepository.save(
            User.builder()
                .guestId(customGuestId)
                .deviceToken(guestSignUpRequest.getDeviceToken())
                .build()
        );

        return customGuestId;
    }
}
