package edu.badpals.proyectoad_bd.Controller;

import edu.badpals.proyectoad_bd.Model.ConnetBD;
import edu.badpals.proyectoad_bd.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateUserController {
    @FXML
    public TextField createUserNombre;

    @FXML
    public TextField createUserContraseña1;

    @FXML
    public TextField createUserContraseña2;

    @FXML
    public Button btnCreateUser;

    @FXML
    public Button btnVolver;

    ConnetBD con = new ConnetBD();

    public void handleBtnCreateUser(ActionEvent event) {
        String nombre = createUserNombre.getText();
        String contraseña1 = createUserContraseña1.getText();
        String contraseña2 = createUserContraseña2.getText();
        User user = new User(nombre, contraseña1, false);

        if (checkPassword(contraseña1, contraseña2)) {
            if (checkUserName(nombre)) {
                insertUser(user);
                returnLogin(event);
                System.out.println("Usuario creado");
            } else {
                System.out.println("Nombre Repetido");
            }
        } else {
            System.out.println("Las contraseñas no coinciden");
        }
    }


    private void insertUser(User usuario) {
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

    private boolean checkPassword(String password1, String password2) {
        if (password1.equals(password2)) {
            return true;
        }
        return false;
    }

    private boolean checkUserName(String nombre) {
        for (User user: con.selectUsuario()) {
            if (user.getNombreUsuario().equals(nombre)) {
                return false;
            }
        }
        return true;
    }

    private void returnLogin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/badpals/proyectoad_bd/login.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void handleBtnVolver(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/badpals/proyectoad_bd/login.fxml"));
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
