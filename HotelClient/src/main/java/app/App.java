package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    public void start(Stage stage) throws Exception {

        final FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/MainView.fxml"));
        Scene scene = loader.load();
        stage.setScene(scene);
        stage.show();

        stage.setIconified(true);
        stage.getIcons().add(new Image("/images/Logoangepasst.png"));
        stage.setTitle("Simperl Brotbestellungen");




       //final Parent root = loader.load();
        //final Scene scene = new Scene(root, 800, 600);



    }
}
