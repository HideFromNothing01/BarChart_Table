package com.example.javafxbarchart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
//import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file for the bar chart view
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("barchart-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Set icon for the stage
        stage.getIcons().add(new Image(getClass().getResourceAsStream("mini-figure.png")));
        // Set the title for the stage
        stage.setTitle("BarChart");
        // Set the scene to the stage and display it
        stage.setScene(scene);
        stage.show();
    }
}



