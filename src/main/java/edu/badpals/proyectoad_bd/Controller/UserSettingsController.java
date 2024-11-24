package edu.badpals.proyectoad_bd.Controller;

import edu.badpals.proyectoad_bd.Model.ConnetBD;
import edu.badpals.proyectoad_bd.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UserSettingsController {

    ConnetBD con = new ConnetBD();

    @FXML
    public TextField contraseñaUsuario;

    @FXML
    public TextField nombreUsuario;

    @FXML
    public ComboBox<String> cboUsuarios;

    @FXML
    public Button btnBorrar;

    @FXML
    public Button btnAdministrador;

    @FXML
    public Button btnModificar;

    @FXML
    public Button btnVolver;

    @FXML
    public void initialize() {
        // Llena el ComboBox
        for (User usuario : con.selectUsuario()) {
            cboUsuarios.getItems().add(usuario.getNombreUsuario());
            // Agregar listener al ComboBox
            cboUsuarios.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                // Llenar los TextField con datos del usuario seleccionado
                if (newValue != null) {
                    for (User user : con.selectUsuario()) {
                        if (user.getNombreUsuario().equals(newValue)) {
                            nombreUsuario.setText(user.getNombreUsuario());
                            contraseñaUsuario.setText(user.getContraseña());
                            break;
                        }
                    }
                }
            });
        }
    }


    public void handleBtnBorrar(ActionEvent event) {
        borrarUsuario(cboUsuarios.getSelectionModel().getSelectedItem());
    }

    public void borrarUsuario(String nombre_usuario) {
        String sqlDelete = "DELETE FROM USUARIO WHERE NOMBRE = ?";
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

    public void handleBtnAdministrador(ActionEvent event) {
        asignarAdministrador(cboUsuarios.getSelectionModel().getSelectedItem());
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

    public void handleBtnModificar(ActionEvent event) {
            actualizarUsuario(cboUsuarios.getSelectionModel().getSelectedItem(), nombreUsuario.getText(), contraseñaUsuario.getText());
    }

    public void actualizarUsuario(String nombreUsuario, String nuevoNombre, String nuevaContraseña) {
        String sqlUpdate = "UPDATE USUARIO SET NOMBRE = ?, CONTRASEÑA = ? WHERE NOMBRE = ?";

        try (PreparedStatement pstmt = con.connetUsuario().prepareStatement(sqlUpdate)) {
            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevaContraseña);
            pstmt.setString(3, nombreUsuario);

            // Ejecutar la actualización
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuario actualizado con éxito.");
            } else {
                System.out.println("No se encontró el usuario para actualizar.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el usuario: " + e.getMessage());
        }
    }
}
