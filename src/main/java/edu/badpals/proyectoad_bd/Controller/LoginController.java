package edu.badpals.proyectoad_bd.Controller;

import edu.badpals.proyectoad_bd.Model.ConnetBD;
import edu.badpals.proyectoad_bd.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoginController {
    ConnetBD con = new ConnetBD();

    @FXML
    public TextField txtLogin;

    @FXML
    public Label lblLogin;

    @FXML
    public PasswordField txtPassword;

    @FXML
    public Label lblPassword;

    @FXML
    public Button btnEnviar;

    @FXML
    Label lblErrorAut;

    private HashMap<String, String> userCredentials = new HashMap<>();
    private ArrayList<User> administradores = new ArrayList<>();
    private String nombreUsuario;

    @FXML
    private void leer(){
        for (User user :  con.selectUsuario()) {
            userCredentials.put(user.getNombreUsuario(), user.getContraseña());
        }
    }

    // Método de login que valida las credenciales
    public void login(ActionEvent event) {
        leer();
        llenarAdministradores();
        // Realizar validación de login (pseudocódigo)
        boolean isValid = autentificacionUser(txtLogin.getText(),txtPassword.getText());  // Suponiendo que tienes este método
        if (isValid) {
            nombreUsuario = txtLogin.getText();
            // Si el login es válido, abrir la siguiente ventana
            try {
                // Cambiar de escena a ViewNorUser
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/badpals/proyectoad_bd/viewBD.fxml"));
                Parent root = loader.load();
                ViewNorUserController view = loader.getController();

                // Establecer el LoginController para que ViewNorUserController tenga acceso
                view.setLoginController(this);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("User Dashboard");
                view.credencialAdmin();
                stage.show();



            } catch (IOException e) {
                System.err.println("Error loading the next scene: " + e.getMessage());
            }
        } else {
            // Si el login falla, mostrar un mensaje de error o algo similar
            System.out.println("Login failed");
        }
    }

    public String getNombreUsuario(){
        return nombreUsuario;
    }
    private boolean autentificacionUser(String user, String password){

        if (userCredentials.containsKey(user)) {
            return userCredentials.get(user).equals(password);
        }
        return false;
    }

    private void llenarAdministradores() {
        for (User user : con.selectUsuario()) {
            if (user.isAdministrador()) {
                administradores.add(user);
            }
        }
    }

    public boolean distinguirAdministrador(String nombre) {
        for (User user : administradores) {
            if (user.getNombreUsuario().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public void handleBtnCreateUser(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/badpals/proyectoad_bd/createUser.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
