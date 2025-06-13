package project.software.infra.fcm;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class FCMService {

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public void sendMessage(String token, String title, String body) throws FirebaseMessagingException {
        String message = FirebaseMessaging.getInstance().send(Message.builder()
            .setNotification(Notification.builder()
                .setTitle(title)
                .setBody(body)
                .build())
            .setToken(token)
            .build());

        System.out.println("Sent message: " + message);
    }

    public void sendMessageLater(String token, String title, String body, long delayInMinutes) {
        scheduler.schedule(() -> {
            try {
                sendMessage(token, title, body);
            } catch (FirebaseMessagingException e) {
                System.err.println("Failed to send message: " + e.getMessage());
                e.printStackTrace();
            }
        }, delayInMinutes, TimeUnit.MINUTES);
    }
}
