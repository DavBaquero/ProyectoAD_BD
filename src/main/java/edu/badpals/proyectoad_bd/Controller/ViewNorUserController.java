package edu.badpals.proyectoad_bd.Controller;

import edu.badpals.proyectoad_bd.Model.AgenteDTO;
import edu.badpals.proyectoad_bd.Model.Agentes;
import edu.badpals.proyectoad_bd.Model.ConnetBD;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewNorUserController {
    @FXML
    TableView<AgenteDTO> TableAg;

    @FXML
    TableColumn<AgenteDTO, Integer> ColID_AG;

    @FXML
    TableColumn<AgenteDTO, String> ColNom_AG;

    @FXML
    TableColumn<AgenteDTO, String> ColRol_AG;

    @FXML
    TableColumn<AgenteDTO, String> ColHabC_AG;

    @FXML
    TableColumn<AgenteDTO, String> ColHabQ_AG;

    @FXML
    TableColumn<AgenteDTO, String> ColHabE_AG;

    @FXML
    TableColumn<AgenteDTO, String> ColHabX_AG;

    @FXML
    public void initialize() {
        ColID_AG.setCellValueFactory(new PropertyValueFactory<>("idAg"));
        ColNom_AG.setCellValueFactory(new PropertyValueFactory<>("nombreAg"));
        ColRol_AG.setCellValueFactory(new PropertyValueFactory<>("nombreRol"));
        ColHabC_AG.setCellValueFactory(new PropertyValueFactory<>("habilidadC"));
        ColHabQ_AG.setCellValueFactory(new PropertyValueFactory<>("habilidadQ"));
        ColHabE_AG.setCellValueFactory(new PropertyValueFactory<>("habilidadE"));
        ColHabX_AG.setCellValueFactory(new PropertyValueFactory<>("habilidadX"));

        // Cargar datos en el TableView
        TableAg.setItems(getAgentesData());
    }

    private ObservableList<AgenteDTO> getAgentesData() {
        ConnetBD.connect();
        return ConnetBD.getAgentesTab();
    }

}

