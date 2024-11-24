package edu.badpals.proyectoad_bd;

import edu.badpals.proyectoad_bd.Controller.LoginController;
import edu.badpals.proyectoad_bd.Controller.ViewNorUserController;
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
            // Cargar el archivo FXML de login
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/badpals/proyectoad_bd/login.fxml"));
            Parent root = loader.load();  // Cargamos la vista

            // Obtener el controlador del login
            LoginController loginController = loader.getController();

            // Aquí es donde puedes crear y pasar el controlador de login a otros controladores
            // Cargar la siguiente vista que necesita el controlador de login (por ejemplo, ViewNorUserController)
            FXMLLoader viewNorUserLoader = new FXMLLoader(getClass().getResource("/edu/badpals/proyectoad_bd/viewBD.fxml"));
            Parent viewNorUserRoot = viewNorUserLoader.load();

            // Obtener el controlador de la vista ViewNorUser
            ViewNorUserController viewNorUserController = viewNorUserLoader.getController();

            // Pasar el LoginController a ViewNorUserController
            viewNorUserController.setLoginController(loginController);  // Ahora ViewNorUser tiene acceso al LoginController

            // Crear la escena con la vista de login
            primaryStage.setTitle("Login ValorantAPI");
            primaryStage.setScene(new Scene(root));
            primaryStage.setMinWidth(400);
            primaryStage.setMinHeight(300);
            primaryStage.show();

            // Si quieres abrir la siguiente ventana (viewNorUser) después de que el login haya sido exitoso,
            // deberías hacerlo en el LoginController, por ejemplo, después de verificar las credenciales.

        } catch (IOException e) {
            System.err.println("Error loading the FXML file: " + e.getMessage());
        }
    }
}
