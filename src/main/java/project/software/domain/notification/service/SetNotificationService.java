package project.software.domain.notification.service;

import com.google.firebase.messaging.FirebaseMessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.user.domain.User;
import project.software.infra.fcm.FCMService;

@RequiredArgsConstructor
@Service
@Transactional
public class SetNotificationService {

    private final UserFacade userFacade;
    private final FCMService fcmService;

    public void execute() throws FirebaseMessagingException {
        User user = userFacade.getCurrentUser();

        fcmService.sendMessage(user.getDeviceToken(), "test", "test");
    }
}
