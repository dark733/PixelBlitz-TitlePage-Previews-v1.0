package com.example.fxml_manual;

import javafx.animation.Interpolator;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.sound.sampled.*;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.scene.layout.StackPane;


import java.io.File;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Objects;

public class PixelBlitz extends Application {
    private final loading_animation load_obj = new loading_animation();
    private final sound_api obj_sound = new sound_api();
    @Override
    public void start(Stage stage) throws IOException, LineUnavailableException {
        /* */
        //load_obj.showLoadingScreen(stage); //loading screen dosent work
        //load_obj.simulateLoading(stage);
        /* */
        load_obj.loading_fxml_file(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(PixelBlitz.class.getResource("title_screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 1000, Color.GRAY);
        //link css
        try{
            //scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styler.css")).toExternalForm());
            String css;
            css = Objects.requireNonNull(this.getClass().getResource("styler.css")).toExternalForm();
            scene.getStylesheets().add(css);
            System.out.println("Css file found!");

        }
        catch(NullPointerException e){
            System.out.println(" Null pointer Exception Caught" + e);
        }
        catch (Exception e){
            System.out.println("Exception Caught" + e);
        }
        //sound api


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
        }
        catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        }
    }

}
class loading_animation {
    private final ProgressBar progressBar = new ProgressBar(0);

    public void showLoadingScreen(Stage stage) {
        progressBar.setPrefWidth(500);
        progressBar.setPrefHeight(100);

        StackPane root = new StackPane(progressBar);
        Scene loadingScene = new Scene(root, 400, 300);

        stage.setScene(loadingScene);
        stage.setTitle("Loading Animation Example");
        stage.show();
    }

    public void simulateLoading(Stage stage) {
        // Simulate loading progress with animation
        Timeline timeline = new Timeline();
        timeline.setCycleCount(1);
        timeline.setAutoReverse(false);

        // Animate progress bar value
        KeyValue keyValue = new KeyValue(progressBar.progressProperty(), 1.0, Interpolator.LINEAR);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), keyValue);
        timeline.getKeyFrames().add(keyFrame);

        // Show loading screen for 2 seconds and then switch to main scene
        timeline.setOnFinished(event -> {
            stage.setScene(null);
            stage.hide();
        });
        timeline.play();
    }
    public void loading_fxml_file(Stage stage) throws IOException {
        try{
            System.out.println("Loading fxml file preview");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("loadingScreen.fxml"));
            Scene loadingScene = loader.load();
            LoadingScreenController controller = loader.getController();


            // Show loading screen
            stage.setScene(loadingScene);
            stage.setTitle("Loading...");
            stage.show();
            new Thread(() -> {
                try {
                    // Simulate loading
                    Thread.sleep(2000);

                    // Update progress bar on UI thread
                    Platform.runLater(() -> controller.setProgress(1.0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                catch (Exception e){
                    System.out.println("Exception Caught" + e);
                }
            }).start();

        }
        catch(EmptyStackException e){
            System.out.println("Stack is Empty Exception" + e);
        }
        catch(NullPointerException e){
            System.out.println("NullPointerExceptionCaught " + e);
        }
        catch(Exception e){
            System.out.println("Exception caught" + e);
        }






    }
}
