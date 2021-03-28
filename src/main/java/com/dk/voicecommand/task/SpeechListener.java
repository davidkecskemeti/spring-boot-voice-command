package com.dk.voicecommand.task;

import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class SpeechListener {

    @Autowired
    private LiveSpeechRecognizer liveSpeechRecognizer;

    @Scheduled(fixedRate = 1000L)
    public void scheduleFixedRateTaskAsync() throws InterruptedException, IOException {
       log.info("Fixed rate task async - " + System.currentTimeMillis() / 1000);

       if(liveSpeechRecognizer!=null){
           SpeechResult speechResult =  liveSpeechRecognizer.getResult();
           if(speechResult!=null){
               String voiceCommand = speechResult.getHypothesis();
               System.out.println("Voice Command is " + voiceCommand);
               if (voiceCommand.equalsIgnoreCase("Open Chrome")) {
                   Runtime.getRuntime().exec("cmd.exe /c start chrome www.google.com");
               } else if (voiceCommand.equalsIgnoreCase("Close Chrome")) {
                   Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
               }
           }
       }
    }
}
