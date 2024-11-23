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
    String archivo = "src/main/resources/BD/users.txt";
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
            System.out.println("Autenticación fallida. Usuario o contraseña incorrecta.");
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

    public void insertarUsuario(User usuario) {
        String sql = "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, ADMINISTRADOR) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = con.connetUsuario().prepareStatement(sql);

            pstmt.setString(1, usuario.getNombreUsuario());
            pstmt.setString(2, usuario.getContraseña());
            pstmt.setBoolean(3, usuario.isAdministrador());

            pstmt.executeUpdate();
            System.out.println("Usuario insertado: " + usuario.getNombreUsuario());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void asignarAdministrador(String nombre_usuario) {
        String sqlSelect = "SELECT ADMINISTRADOR FROM USUARIO WHERE NOMBRE = ?";
        String sqlUpdate = "UPDATE USUARIO SET ADMINISTRADOR = TRUE WHERE NOMBRE = ?";

        try (
             PreparedStatement pstmtSelect = con.connetUsuario().prepareStatement(sqlSelect);
             PreparedStatement pstmtUpdate = con.connetUsuario().prepareStatement(sqlUpdate)) {

            // Verificar si el usuario es administrador
            pstmtSelect.setString(1, nombre_usuario);
            ResultSet resultSet = pstmtSelect.executeQuery();

            if (resultSet.next()) {
                boolean esAdministrador = resultSet.getBoolean("ADMINISTRADOR");
                if (esAdministrador) {
                    System.out.println("El usuario ya es administrador.");
                } else {
                    // Asignar como administrador
                    pstmtUpdate.setString(1, nombre_usuario);
                    pstmtUpdate.executeUpdate();
                    System.out.println("El usuario " + nombre_usuario + " ha sido asignado como administrador.");
                }
            } else {
                System.out.println("El usuario no existe en la base de datos.");
            }

        } catch (SQLException e) {
            System.err.println("Error durante la asignación del administrador: " + e.getMessage());
        }
    }
    public void borrarUsuario(String nombre_usuario) {
        String sqlDelete = "DELETE FROM USUARIO WHERE NOMBRE = ?";

        // Crear una instancia de ConnetBD
        ConnetBD con = new ConnetBD();

        try (
             PreparedStatement pstmt =  con.connetUsuario().prepareStatement(sqlDelete)) {

            pstmt.setString(1, nombre_usuario);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuario " + nombre_usuario + " ha sido borrado exitosamente.");
            } else {
                System.out.println("No se encontró el usuario " + nombre_usuario + " en la base de datos.");
            }

        } catch (SQLException e) {
            System.err.println("Error al borrar el usuario: " + e.getMessage());
        }
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
