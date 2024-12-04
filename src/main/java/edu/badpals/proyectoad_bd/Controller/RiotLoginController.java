package edu.badpals.proyectoad_bd.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class RiotLoginController {

    @FXML
    private CheckBox chkMantenerSesionUsuario;

    @FXML
    private Button easterEggA;

    @FXML
    private Button easterEggF;

    @FXML
    private Button easterEggG;

    @FXML
    private Button easterEggP;

    @FXML
    private Button easterEggX;

    @FXML
    private Label lblDatosRiotPnl;

    @FXML
    private Label lblDatosRiotPnl1;

    @FXML
    private PasswordField txtContraUsuario;

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    void onBtnClicEasterEggF(ActionEvent event) {
        openMondongoLink();
    }

    @FXML
    void onBtnClicEasterEggG(ActionEvent event) {
        openChillLink();
    }

    @FXML
    void onBtnClicEasterEggA(ActionEvent event) {
        openPHubLink();
    }

    @FXML
    void onBtnClicEasterEggX(ActionEvent event) {
        openMemeGLink();
    }

    @FXML
    void onBtnClicEasterEggP(ActionEvent event) {
        openMemeViva();
    }

    //FUNCIONES DE LA CLASE
    private void openMondongoLink() {
        String url = "https://www.youtube.com/shorts/16uJ-jxcKHo";
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(new URI(url));
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al abrir el link" + e.getMessage());
        }
    }

    private void openChillLink() {
        String url = "https://www.youtube.com/shorts/PMZQsW_N2Lw/";
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(new URI(url));
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al abrir el link" + e.getMessage());
        }
    }

    private void openPHubLink() {
        String url = "https://www.youtube.com/watch?v=4K1mZtHRpQ8&ab_channel=universe";
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(new URI(url));
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al abrir el link" + e.getMessage());
        }
    }

    private void openMemeGLink(){
        String url = "https://www.youtube.com/watch?v=YnpxHsPB-EE&ab_channel=Serpientefuraz";
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(new URI(url));
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al abrir el link" + e.getMessage());
        }
    }

    private void openMemeViva(){
        String url = "https://www.youtube.com/watch?v=NrQXWNMKlUw&ab_channel=MartaClavero";
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(new URI(url));
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al abrir el link" + e.getMessage());
        }
    }
}
