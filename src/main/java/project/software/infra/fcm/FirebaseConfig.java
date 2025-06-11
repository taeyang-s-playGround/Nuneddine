package project.software.infra.fcm;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

@Slf4j
@Configuration
public class FirebaseConfig {

    @Value("${fcm.path}")
    private String path;

    @PostConstruct
    public void init() {
        try (InputStream inputStream = new URL(path).openStream()) {
            FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(inputStream))
                .build();

            FirebaseApp.initializeApp(options);
            log.info("FirebaseApp initialized successfully.");
        } catch (Exception e) {
            log.error("FirebaseApp initialization failed.", e);
        }
    }
}
