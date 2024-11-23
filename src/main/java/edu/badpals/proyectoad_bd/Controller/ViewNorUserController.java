package edu.badpals.proyectoad_bd.Controller;

import edu.badpals.proyectoad_bd.Model.AgenteDTO;
import edu.badpals.proyectoad_bd.Model.ConnetBD;
import edu.badpals.proyectoad_bd.Model.HabilidadDTO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
    Label lblNomAg;

    @FXML
    Label lblRolAg;

    @FXML
    Label lblHabC;

    @FXML
    Label lblHabQ;

    @FXML
    Label lblHabE;

    @FXML
    Label lblHabX;

    @FXML
    Label lblDescAg;


    @FXML
    public void initialize() {
        ColID_AG.setCellValueFactory(new PropertyValueFactory<>("idAg"));
        ColNom_AG.setCellValueFactory(new PropertyValueFactory<>("nombreAg"));
        ColRol_AG.setCellValueFactory(new PropertyValueFactory<>("nombreRol"));
        ColHabC_AG.setCellValueFactory(new PropertyValueFactory<>("habilidadC"));
        ColHabQ_AG.setCellValueFactory(new PropertyValueFactory<>("habilidadQ"));
        ColHabE_AG.setCellValueFactory(new PropertyValueFactory<>("habilidadE"));
        ColHabX_AG.setCellValueFactory(new PropertyValueFactory<>("habilidadX"));

        Col_Id_Ag_Per.setCellValueFactory(new PropertyValueFactory<>("idAg"));
        Col_Nom_HAG.setCellValueFactory(new PropertyValueFactory<>("nombreag"));
        Col_Hab_AG.setCellValueFactory(new PropertyValueFactory<>("nombreHab"));

        // Cargar datos en el TableView
        TableAg.setItems(getAgentesData());
        TableHab.setItems(getHabData());

        TableAg.setOnMouseClicked(event -> handleRowClickAg(event));
        TableHab.setOnMouseClicked(event -> handleRowClickHab(event));
    }

    private ObservableList<AgenteDTO> getAgentesData() {
        ConnetBD.connect();
        return ConnetBD.getAgentesTab();
    }

    private void handleRowClickAg(MouseEvent event) {
        AgenteDTO selectedAgente = TableAg.getSelectionModel().getSelectedItem();
        if (selectedAgente != null) {
            // Imprimir en consola para depuración
            System.out.println("Agente seleccionado: " + selectedAgente.getNombreAg());

            // Actualizar las etiquetas con la información del agente
            lblNomAg.setText("Nombre: "+ selectedAgente.getNombreAg());
            lblDescAg.setText("Descripción: "+selectedAgente.getDescripcion());
            lblRolAg.setText("Rol: "+ selectedAgente.getNombreRol());
            lblHabC.setText("Hab C: "+selectedAgente.getHabilidadC());
            lblHabQ.setText("Hab Q: "+selectedAgente.getHabilidadQ());
            lblHabE.setText("Hab E: "+selectedAgente.getHabilidadE());
            lblHabX.setText("Hab X: "+selectedAgente.getHabilidadX());
        }
    }

    @FXML
    Label lblModNomHAG;

    @FXML
    Label lblModNomHab;

    @FXML
    Label lblDescripHab;

    @FXML
    TableView<HabilidadDTO> TableHab;

    @FXML
    TableColumn<HabilidadDTO, String> Col_Id_Ag_Per;

    @FXML
    TableColumn<HabilidadDTO, String> Col_Nom_HAG;

    @FXML
    TableColumn<HabilidadDTO, String> Col_Hab_AG;

    private ObservableList<HabilidadDTO> getHabData() {
        ConnetBD.connect();
        return ConnetBD.getHabTab();
    }

    private void handleRowClickHab(MouseEvent event) {
        HabilidadDTO selectedHab = TableHab.getSelectionModel().getSelectedItem();
        if (selectedHab != null) {
            // Imprimir en consola para depuración
            System.out.println("Agente seleccionado: " + selectedHab.getNombreHab());

            // Actualizar las etiquetas con la información de la habilidad
            lblModNomHAG.setText(selectedHab.getNombreag());
            lblModNomHab.setText(selectedHab.getNombreHab());
            lblDescripHab.setText(selectedHab.getDescripcion());
        }
    }
}

