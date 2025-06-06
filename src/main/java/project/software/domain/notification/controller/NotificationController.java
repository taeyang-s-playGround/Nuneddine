package project.software.domain.notification.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.software.domain.notification.service.SetNotificationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notifications")
public class NotificationController {

    private final SetNotificationService setNotificationService;

    @PostMapping
    private void setSetNotification() throws FirebaseMessagingException {
        setNotificationService.execute();
    }
}
