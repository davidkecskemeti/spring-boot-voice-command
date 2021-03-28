package com.dk.voicecommand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class VoiceCommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoiceCommandApplication.class, args);
    }

}
