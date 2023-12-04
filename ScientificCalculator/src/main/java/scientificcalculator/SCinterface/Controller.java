package scientificcalculator.SCinterface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import scientificcalculator.classes.ScientificCalculator;

public class Controller implements Initializable {
    private final Alert a = new Alert(AlertType.NONE);
    @FXML
    private TextField text;
    @FXML
    private Button buttonInvio;
    @FXML
    private Button buttonConferma;
    @FXML
    private ComboBox comboBoxVariable;
    @FXML
    private ComboBox comboBoxOperation;
    @FXML
    private VBox vBoxVariable;
    @FXML
    private VBox vBoxStack;
    @FXML
    private AnchorPane insertNumberAnchor;
    private final ScientificCalculator calculator = new ScientificCalculator();
    private Character variabile;
    private Character operazione;
    
    //metodi
    @FXML
    private void handleInvio(ActionEvent event) {
        text.clear();
        //this.checkInput(text.getText());
        vBoxStackUpdate();
        vBoxVariableUpdate();
    }
    @FXML
    private void inputFromUI(ActionEvent event) {
        Button b=(Button)event.getSource();
        text.setText(text.getText()+ b.getText());
    }
    @FXML
    private void inputFromUIwithClear(ActionEvent event) {
        Button b=(Button)event.getSource();
        text.clear();
        text.setText(b.getText());
    }
    @FXML
    private void delete(ActionEvent event) {
        text.clear();
    }
    
    @FXML
    private void handleKeyPressed(KeyEvent ke){
        if(ke.getCode().toString().equals("ENTER")){
            text.clear();   
        }
    }
    @FXML
    private void handleVariable() {
       insertNumberAnchor.setVisible(false);
    }
    @FXML
    private void backFromVariable() {
       insertNumberAnchor.setVisible(true);
    }
    @FXML
    private void selectVariable(ActionEvent event) {
        ComboBox var = (ComboBox)event.getSource();
        variabile=var.getValue().toString().charAt(1);
        System.out.println(variabile);        
    }
    @FXML
    private void selectOperation(ActionEvent event) {
        ComboBox op = (ComboBox)event.getSource();
        operazione=op.getValue().toString().charAt(1);
        System.out.println(operazione);        
    }
    @FXML
    private void executeOperation(ActionEvent event){
        a.setAlertType(AlertType.CONFIRMATION);
        a.showAndWait();
        System.out.println(a.getResult().getText());
        backFromVariable();
        System.out.println("Variabile: "+variabile+" Operazione: "+operazione);
        
    }
    private void vBoxVariableUpdate(){
        vBoxVariable.getChildren().clear();
    }
    private void vBoxStackUpdate(){
        vBoxStack.getChildren().clear();
        
    }
    private Label generateLabel(String stringa){
        Label label = new Label(stringa);
        label.setMinWidth(260.00);
        label.setMinHeight(45);
        label.setPadding(new Insets(5));
        return label;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        for(int i=0;i<26;i++){
            comboBoxVariable.getItems().add(" "+(char)(i+65)+" ");
        }
        
        comboBoxOperation.getItems().addAll(" > x "," < x "," + x "," - x ");        
        
        
    }
    
}
