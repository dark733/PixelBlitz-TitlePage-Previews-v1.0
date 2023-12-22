package com.example.fxml_manual;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
//working
class soundApi {


    public void play_sound() {
        String filePath = "Startup.wav";
        File file = new File(filePath);

        try {
            if (!file.exists() || !file.isFile()) {
                System.out.println("Invalid audio file path: " + filePath);
                return;
            } else {
                System.out.println("Audio File Found");
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip currentClip = AudioSystem.getClip();
            currentClip.open(audioStream);
            currentClip.start();
            //stop_sound(currentClip);

        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
             // Handle the exceptions accordingly
        }
    }
    public void stop_sound(Clip currentClip) {
        if (currentClip != null && currentClip.isOpen() && currentClip.isRunning()) {
            currentClip.stop();
            currentClip.close();
        }
        else{
            System.out.println("Can't close");
        }
    }
    public void play_game_selection_screen_sound(){
        String filePath = "button_sound.wav";
        File file_two = new File(filePath);

        try {
            if (!file_two.exists() || !file_two.isFile()) {
                System.out.println("Invalid audio file path: " + filePath);
                return;
            } else {
                System.out.println("Audio File Found");
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file_two);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
             // Handle the exceptions accordingly
        }

    }
    public void credit_screen_sound(){
        String filePath = "Credit.wav";
        File file_two = new File(filePath);

        try {
            if (!file_two.exists() || !file_two.isFile()) {
                System.out.println("Invalid audio file path: " + filePath);
                return;
            } else {
                System.out.println("Audio File Found");
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file_two);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            // Handle the exceptions accordingly
        }

    }

    public void references_screen_sound(){
        String filePath = "Forgotten.wav";
        File file_two = new File(filePath);

        try {
            if (!file_two.exists() || !file_two.isFile()) {
                System.out.println("Invalid audio file path: " + filePath);
                return;
            } else {
                System.out.println("Audio File Found");
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file_two);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            // Handle the exceptions accordingly
        }

    }
}
