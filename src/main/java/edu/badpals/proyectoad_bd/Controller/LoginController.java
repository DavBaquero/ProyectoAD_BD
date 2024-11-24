package edu.badpals.proyectoad_bd.Controller;

import edu.badpals.proyectoad_bd.Model.ConnetBD;
import edu.badpals.proyectoad_bd.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

    @FXML
    private void leer(){
        con.selectUsuario();
        for (User user : con.getUsuarios()) {
            userCredentials.put(user.getNombreUsuario(), user.getContraseña());
        }
    }


    public void handleBtnEnter(ActionEvent event){
        String user = txtLogin.getText();
        String password = txtPassword.getText();
        leer();//Mapa Usuarios-Contraseña
        llenarAdministradores ();//Administradores
        if (autentificacionUser(user, password)) {
            System.out.println("Usuario encontrado");
            if (distinguirAdministrador(user)) {
                System.out.println("Administrador");
                changeView(event);
            } else {
                System.out.println("No hay administradores.");
                changeView(event);
            }
        } else {
            lblErrorAut.setText("* Usuario o contraseña incorrectos.");
            lblErrorAut.setStyle("-fx-text-fill: red;");
            lblErrorAut.setStyle("-fx-font-style: italic;");
        }
    }

    private void changeView(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/badpals/proyectoad_bd/viewBD.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean autentificacionUser(String user, String password){

        if (userCredentials.containsKey(user)) {
            return userCredentials.get(user).equals(password);
        }
        return false;
    }

    private void llenarAdministradores () {
        con.selectUsuario();
        for (User user : con.getUsuarios()) {
            if (user.isAdministrador()) {
                administradores.add(user);
            }
        }
    }

    private boolean distinguirAdministrador(String nombre_usuario) {
        for (User user : administradores) {
            if (user.getNombreUsuario().equals(nombre_usuario)) {
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
