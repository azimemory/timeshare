package com.gom.timeshare;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.Lists;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import java.io.FileInputStream;
import java.util.List;


@SpringBootApplication
public class TimeshareApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(TimeshareApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void firebaseInit() throws IOException {
        FirebaseApp firebaseApp = null;
        List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
        final String ADMIN_SDK_PATH = this.getClass().getResource("/").getPath().replaceFirst("/", "") + "timetable-adminsdk.json";
        if(firebaseApps.stream().noneMatch((e)-> e.getName().equals("push-app"))){
            GoogleCredentials credentials =
                    GoogleCredentials.fromStream
                            (new FileInputStream(ADMIN_SDK_PATH))
                            .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(credentials)
                    .build();
            FirebaseApp.initializeApp(options,"push-app");
            System.out.println("FirbaseApp 초기화 완료");
        }
    }
}
