package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class BestellViewController {

    @FXML
    private GridPane viewBestellung;

    @FXML
    private ComboBox<?> SchluesselSelectorDropdown;

    @FXML
    private Button AbsendenButton;

    @FXML
    private DatePicker DatumSelector;

    @FXML
    private TextField GuestVortag;

    @FXML
    private TextField GuestInHouse;

    @FXML
    private TextField FruestuecksGaeste;

}
