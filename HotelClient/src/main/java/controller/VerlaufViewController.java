package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class VerlaufViewController {

    @FXML
    private GridPane viewBestellung;

    @FXML
    private DatePicker VerlaufViewDatumVON;

    @FXML
    private DatePicker VerlaufViewDatumBIS;

    @FXML
    private Button verlaufAnzeigen;

    @FXML
    private TableView<?> VerlaufViewVerlauf;


}
