package controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class SchluesselViewController {

    @FXML
    private Scene SchluesselView;

    @FXML
    private GridPane SchluesselViewGrid;

    @FXML
    private TableView<?> SchluesselViewTable;

    @FXML
    private TableColumn<?, ?> SchluesselViewProduktColumn;

    @FXML
    private TableColumn<?, ?> SchluesselViewAktuellColumn;

    @FXML
    private TableColumn<?, ?> SchluesselViewNewColumn;

    @FXML
    private Button SchluesselViewSpeichern;

    @FXML
    private TextField SchluesselViewNewSchluesselName;

    @FXML
    private Button SchluesselViewNewSchluesselSpeichern;

    @FXML
    private ComboBox<?> SchluesselViewSchluesselWahl;



}
