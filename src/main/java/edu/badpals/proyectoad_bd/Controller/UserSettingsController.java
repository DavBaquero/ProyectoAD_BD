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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserSettingsController {

    ConnetBD con = new ConnetBD();
    ArrayList<User> usuarios = con.selectUsuario();

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
    Label lblModUser;

    @FXML
    public void initialize() {
        llenarComboBox();
        crearListener();
    }

    private void llenarComboBox() {
        // Limpia los datos actuales del ComboBox para evitar duplicados
        cboUsuarios.getItems().clear();
        // Llena el ComboBox, verificando duplicados en la lista original
        for (User usuario : usuarios) {
            if (!cboUsuarios.getItems().contains(usuario.getNombreUsuario())) {
                cboUsuarios.getItems().add(usuario.getNombreUsuario());
            }
        }
    }

    private void crearListener() {
        // Configura el listener para manejar la selección del usuario
        // El listener solo debe configurarse una vez
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
            } else {
                // Limpiar los campos si no hay selección
                nombreUsuario.clear();
                contraseñaUsuario.clear();
            }
        });
    }


    public void handleBtnBorrar(ActionEvent event) {
        // Obtén el usuario seleccionado en el ComboBox
        String usuarioSeleccionado = cboUsuarios.getSelectionModel().getSelectedItem();

        if (usuarioSeleccionado != null) {
            // Borra el usuario de la base de datos
            borrarUsuario(usuarioSeleccionado);

            // Limpia los campos del formulario
            nombreUsuario.clear();
            contraseñaUsuario.clear();

            // Actualiza la lista de usuarios después de borrar
            usuarios.clear();
            usuarios = con.selectUsuario();
            System.out.println(usuarios);

            // Actualiza el ComboBox con la lista actualizada
            llenarComboBox();

            // Mensaje de confirmación
            lblModUser.setText("* Usuario " + usuarioSeleccionado + " borrado con éxito.");
            lblModUser.setStyle("-fx-font-style: italic;");
        } else {
            lblModUser.setText("* Por favor, selecciona un usuario para borrar.");
            lblModUser.setStyle("-fx-font-style: italic;");
        }
    }


    public void borrarUsuario(String nombre_usuario) {
        String sqlDelete = "DELETE FROM USUARIO WHERE NOMBRE = ?";
        try (
                PreparedStatement pstmt =  con.connetUsuario().prepareStatement(sqlDelete)) {

            pstmt.setString(1, nombre_usuario);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                lblModUser.setText("* Usuario " + nombre_usuario + " ha sido borrado exitosamente.");
                lblModUser.setStyle("-fx-font-style: italic;");
            } else {
                lblModUser.setText("* No se encontró el usuario " + nombre_usuario + " en la base de datos.");
                lblModUser.setStyle("-fx-font-style: italic;");
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
                    lblModUser.setText("* El usuario " + nombre_usuario + " ya es administrador.");
                    lblModUser.setStyle("-fx-font-style: italic;");
                } else {
                    // Asignar como administrador
                    pstmtUpdate.setString(1, nombre_usuario);
                    pstmtUpdate.executeUpdate();
                    lblModUser.setText("* El usuario " + nombre_usuario + " ha sido asignado como administrador.");
                    lblModUser.setStyle("-fx-font-style: italic;");
                }
            } else {
                System.out.println("El usuario no existe en la base de datos.");
            }

        } catch (SQLException e) {
            System.err.println("Error durante la asignación del administrador: " + e.getMessage());
        }
    }

    public void handleBtnModificar(ActionEvent event) {
        // Obtiene el nombre del usuario seleccionado
        String usuarioSeleccionado = cboUsuarios.getSelectionModel().getSelectedItem();

        // Actualiza los datos en la base de datos
        actualizarUsuario(usuarioSeleccionado, nombreUsuario.getText(), contraseñaUsuario.getText());

        //Actualizar lista
        usuarios = con.selectUsuario();


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
                lblModUser.setText("* Usuario actualizado con éxito.");
                lblModUser.setStyle("-fx-font-style: italic;");
            } else {
                lblModUser.setText("* No se encontró el usuario en la base de datos.");
                lblModUser.setStyle("-fx-font-style: italic;");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el usuario: " + e.getMessage());
        }
    }

    public void handleBtnVolver(ActionEvent event) {
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
}
