package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


import javafx.scene.image.ImageView;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private static final String BESTELL_VIEW = "/view/BestellView.fxml";
    private static final String SCHLUESSEL_VIEW = "/view/SchluesselView.fxml";
    private static final String VERLAUF_VIEW = "/view/VerlaufView.fxml";
    private static final String KONTAKT_VIEW = "/view/KontaktView.fxml";




//Navigations Leiste rechts um zwischen den Views zu Wechseln

    @FXML
    private ImageView Home;

    @FXML
    private Label MenueName;

    @FXML
    private Button bestellungButton;

    @FXML
    private Button verlaufButton;

    @FXML
    private Button schluesselButton;

    @FXML
    private Button kontaktButton;

    @FXML
    private ScrollPane scrollPaneContainerView;
    //Home Button Menu um auf Bestellung zurück zu kommen



    //Button onActionHeandler implementierung um Zwischen den Views zu wechseln
    private void initButtons(){
        final ButtonHeandler buttonHeandler = new ButtonHeandler();

        bestellungButton.setOnAction(buttonHeandler);
        kontaktButton.setOnAction(buttonHeandler);
        schluesselButton.setOnAction(buttonHeandler);
        verlaufButton.setOnAction(buttonHeandler);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        initButtons();}


    private class ButtonHeandler implements EventHandler<ActionEvent>{


        @SneakyThrows
        @Override
        public void handle(ActionEvent actionEvent) {

            final Parent parent;
            if (actionEvent.getSource() == bestellungButton){
                parent = loadeParent(BESTELL_VIEW);
                scrollPaneContainerView.setContent(parent);
                MenueName.setText("Bestellung");

            }else if (actionEvent.getSource() == kontaktButton){
                parent = loadeParent(KONTAKT_VIEW);
                scrollPaneContainerView.setContent(parent);
                MenueName.setText("Kontakt");

            }else if (actionEvent.getSource() == schluesselButton){
                parent = loadeParent(SCHLUESSEL_VIEW);
                scrollPaneContainerView.setContent(parent);
                MenueName.setText("Bestell Schlüssel");

            }else if (actionEvent.getSource() == verlaufButton){
                parent = loadeParent(VERLAUF_VIEW);
                scrollPaneContainerView.setContent(parent);
                MenueName.setText("Bestell Verlauf");

            }

        }
    }

    
    private static Parent loadeParent(String viewPath) throws IOException{
        final FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(MainController.class.getResource(viewPath));
        return fxmlLoader.load();
    }

}











