package com.gom.timeshare.fcmpush.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.Lists;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Component
public class FCMInitializer {

    Logger logger = LoggerFactory.getLogger(FCMInitializer.class);

    @PostConstruct
    public void firebaseInit() throws IOException {
        List<FirebaseApp> firebaseApps = FirebaseApp.getApps();

        if(firebaseApps.stream().noneMatch((e)-> e.getName().equals("push-app"))){
            GoogleCredentials credentials =
                    GoogleCredentials.fromStream
                            (new ClassPathResource("timetable-adminsdk.json").getInputStream())
                            .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(credentials).build();

            FirebaseApp.initializeApp(options,"push-app");
            logger.info("FCM 초기화 완료");
        }
    }
}
