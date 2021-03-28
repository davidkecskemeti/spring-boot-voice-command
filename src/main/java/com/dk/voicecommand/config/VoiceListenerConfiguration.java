package com.dk.voicecommand.config;

import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Slf4j
@Configuration
public class VoiceListenerConfiguration {

    @Bean
    public LiveSpeechRecognizer liveSpeechRecognizer(){
        edu.cmu.sphinx.api.Configuration configuration = new edu.cmu.sphinx.api.Configuration();

        //this is provided by the library itself
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");

        //http://www.speech.cs.cmu.edu/tools/lmtool-new.html
        configuration.setDictionaryPath("3324.dic");
        configuration.setLanguageModelPath("3324.lm");

        LiveSpeechRecognizer speech = null;
        try {
            speech = new LiveSpeechRecognizer(configuration);
            speech.startRecognition(true);
            log.info("LiveSpeechListener setup succesfully!");
        } catch (IOException e) {
            log.error("Failed to setup LiveSpeechListener!",e);
        }

        return speech;
    }
}
