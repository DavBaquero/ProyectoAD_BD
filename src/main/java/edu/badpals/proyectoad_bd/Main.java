package edu.badpals.proyectoad_bd;

import edu.badpals.proyectoad_bd.Model.ConnetBD;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/edu/badpals/proyectoad_bd/login.fxml"));
            primaryStage.setTitle("Login ValorantAPI");
            primaryStage.setScene(new Scene(root));
            primaryStage.setMinWidth(400);
            primaryStage.setMinHeight(300);
            primaryStage.show();
        } catch (IOException e) {
            System.err.println("Error loading the FXML file: " + e.getMessage());
        }
    }
}