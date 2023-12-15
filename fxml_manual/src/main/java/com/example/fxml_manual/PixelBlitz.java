package com.example.fxml_manual;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Objects;

public class PixelBlitz extends Application {
    //titleScreen_ControllerClass title_obj = new titleScreen_ControllerClass();
    Welcome wel_obj = new Welcome();
    private final loading_animation load_obj = new loading_animation();
    private final soundApi obj_sound = new soundApi();
    @Override
    public void start(Stage stage) throws IOException, LineUnavailableException {
        /* */
        /* */
        //

        //
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
        titleScreen_ControllerClass controller_one = fxmlLoader.getController();

        // Pass the stage reference to the controller
        controller_one.setStage(stage);
        //play sound function
        obj_sound.play_sound();

        stage.setTitle("Pixel Blitz!");
        stage.setFullScreen(false);
        stage.setResizable(false);
        /*Audio  API*/



        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();



    }
}

class loading_animation {
    private final ProgressBar progressBar = new ProgressBar(0);

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

