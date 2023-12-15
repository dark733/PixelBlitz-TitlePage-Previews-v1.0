package com.example.fxml_manual;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
//working
class soundApi {

    public void play_sound() {
        String filePath = "ALßœ.wav";
        File file = new File(filePath);

        try {
            if (!file.exists() || !file.isFile()) {
                System.out.println("Invalid audio file path: " + filePath);
                return;
            } else {
                System.out.println("Audio File Found");
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace(); // Handle the exceptions accordingly
        }
    }
}
