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
import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.util.List;

@SpringBootApplication
public class TimeshareApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(TimeshareApplication.class, args);
    }
}
