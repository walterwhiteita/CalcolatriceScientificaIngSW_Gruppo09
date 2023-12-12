/*
    GRUPPO 09
    GIANMARCO GUERRIERO
    ANGELO DI MIERI
    BIAGIO DE MARTINO
    ANTONIO CARBONE
*/

package scientificcalculator.SCinterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainClass extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ScientificCalculatorView.fxml"));
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image(getClass().getResource("Logo.png").toString()));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Calcolatrice scientifica");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
