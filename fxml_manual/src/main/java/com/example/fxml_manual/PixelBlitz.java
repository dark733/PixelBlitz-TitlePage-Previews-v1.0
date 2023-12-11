package com.example.fxml_manual;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.sound.sampled.*;


import java.io.File;
import java.io.IOException;

public class PixelBlitz extends Application {
    @Override
    public void start(Stage stage) throws IOException, LineUnavailableException {
        FXMLLoader fxmlLoader = new FXMLLoader(PixelBlitz.class.getResource("title_screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 1000, Color.GRAY);
        //sound api
        sound_api obj_sound = new sound_api();

        // Get the controller instance
        titleScreen_ControllerClass controller = fxmlLoader.getController();

        // Pass the stage reference to the controller
        controller.setStage(stage);
        //play sound function
        obj_sound.play_sound();

        stage.setTitle("Pixel Blitz!");
        stage.setFullScreen(false);
        stage.setResizable(false);
        /*Audio  API*/
//        String audiofile = "Turkish Landscape.mp3";


        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
class sound_api{

    public void play_sound() throws IOException, LineUnavailableException {
        File file = new File("M3.wav");

        try {
            if (!file.exists() || !file.isFile()) {
                System.out.println("Invalid audio file path: ");
                return;
            }
            else{
                System.out.println("Audio File Found");
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        }
    }
}