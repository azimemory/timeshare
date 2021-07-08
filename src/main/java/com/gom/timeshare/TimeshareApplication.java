package com.gom.timeshare;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.common.collect.Lists;
import java.io.FileInputStream;
import java.util.List;


@SpringBootApplication
public class TimeshareApplication {
    public static void main(String[] args) throws IOException {
        FirebaseApp firebaseApp = null;
        List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
        if(firebaseApps.stream().noneMatch((e)-> e.getName().equals("push-app"))){
            GoogleCredentials credentials =
                    GoogleCredentials.fromStream(new FileInputStream("C:\\CODE\\key\\timetable-for-hyeon-firebase-adminsdk-ptefr-dd4e123ae0.json"))
                            .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(credentials)
                    .build();
            FirebaseApp.initializeApp(options,"push-app");
        }

        SpringApplication.run(TimeshareApplication.class, args);
    }
}
