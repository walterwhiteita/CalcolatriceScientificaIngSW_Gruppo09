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
        //Viene caricato come nodo radice il file FXML
        Parent root = FXMLLoader.load(getClass().
                getResource("ScientificCalculatorView.fxml"));
        //Viene creata una scena in cui il nodo radice è quello ottenuto prima
        Scene scene = new Scene(root);
        //Viene impostata un'icona personalizzata
        stage.getIcons().add(new Image(getClass().
                getResource("Logo.png").toString()));
        stage.setResizable(false);
        //Viene impostata la scena allo stage
        stage.setScene(scene);
        stage.setTitle("Calcolatrice scientifica");
        //Viene mostrato lo stage
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
