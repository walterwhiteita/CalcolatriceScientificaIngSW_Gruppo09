/*
    GRUPPO 09
    GIANMARCO GUERRIERO
    ANGELO DI MIERI
    BIAGIO DE MARTINO
    ANTONIO CARBONE
*/

package scientificcalculator.SCinterface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import static scientificcalculator.SCinterface.Checker.checkInput;
import static scientificcalculator.SCinterface.Checker.checkOperation;
import static scientificcalculator.SCinterface.Checker.isANumber;
import static scientificcalculator.SCinterface.Checker.isInitialized;
import scientificcalculator.classes.ComplexNumber;
import scientificcalculator.classes.ScientificCalculator;
import scientificcalculator.exceptions.InvalidInputException;
import scientificcalculator.exceptions.InvalidOperandsException;
import scientificcalculator.exceptions.UninitializedVariableException;

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
        String input = text.getText();
        try{
            checkInput(input);
            if(isANumber(input))
                calculator.insertComplexNumber(input);
            else
                calculator.execute(checkOperation(input));    
            text.clear();
            vBoxStackUpdate();
            vBoxVariableUpdate();
        }catch(InvalidInputException ex){
            a.setAlertType(AlertType.ERROR);
            a.setTitle(ex.getMessage());
            a.setContentText("L'input "+input+" è errato!\nInserisci correttamente un numero un'operazione\nAd esempio : 3+3j o CLR");
            a.setResizable(true);
            a.showAndWait();
        }catch(InvalidOperandsException ex){
            a.setAlertType(AlertType.WARNING);
            a.setTitle(ex.getMessage());
            a.setContentText("L'operazione selezionata non è possibile\nper numero insufficiente di operandi");
            a.setResizable(true);
            a.showAndWait();
        }catch(ArithmeticException ex){
            a.setAlertType(AlertType.WARNING);
            a.setTitle(ex.getMessage());
            a.setContentText("Impossibile eseguire la divisione per zero!\n");
            a.setResizable(true);
            a.showAndWait();
        }
        finally{
            vBoxStackUpdate();
            vBoxVariableUpdate();
        }
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
            handleInvio(null);   
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
    }
    @FXML
    private void selectOperation(ActionEvent event) {
        ComboBox op = (ComboBox)event.getSource();
        operazione=op.getValue().toString().charAt(1);    
    }
    @FXML
    private void executeOperation(ActionEvent event){
        String conferma = "OK";
        if(isInitialized(calculator.getVars(),variabile) && operazione.equals('>')){
            a.setAlertType(AlertType.CONFIRMATION);
            a.setTitle("Variabile inizializzata!");
            a.setContentText("Attenzione!La variabile è già inizializzata!\nSi desidera procedere con la sovrascrittura?");
            a.setResizable(true);
            a.showAndWait();
            conferma = a.getResult().getText();
        }        
        if (conferma.equals("OK")){
            try{
                calculator.executeOnVariable(variabile, operazione);
                vBoxVariableUpdate();
                vBoxStackUpdate();
            }catch(InvalidOperandsException ex){
                a.setAlertType(AlertType.WARNING);
                a.setTitle(ex.getMessage());
                a.setContentText("L'operazione selezionata non è possibile\nper numero insufficiente di operandi");
                a.setResizable(true);
                a.showAndWait();
            }catch(UninitializedVariableException ex){
                a.setAlertType(AlertType.WARNING);
                a.setTitle(ex.getMessage());
                a.setContentText("L'operazione selezionata non è possibile\npoichè la variabile selezionata non ha nessun valore");
                a.setResizable(true);
                a.showAndWait();
            }
            finally{
                vBoxStackUpdate();
                vBoxVariableUpdate();
            }
        }
        
    }
    private void vBoxVariableUpdate(){
        vBoxVariable.getChildren().clear();
        for(String n : calculator.getVars().toStringArrayList()){
            vBoxVariable.getChildren().add(generateLabel(n));
        }
    }
    private void vBoxStackUpdate(){
        vBoxStack.getChildren().clear();
        for(ComplexNumber n : calculator.getStack().getStack()){
            vBoxStack.getChildren().add(generateLabel(n.toString()));
        }
        
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
        for(int i=0;i<26;i++){
            comboBoxVariable.getItems().add(" "+(char)(i+65)+" ");
        }
        comboBoxOperation.getItems().addAll(" > x "," < x "," + x "," - x ");        
        buttonInvio.disableProperty().bind(Bindings.equal("",text.textProperty()));
        buttonConferma.disableProperty().bind(comboBoxVariable.valueProperty().isNull().or(comboBoxOperation.valueProperty().isNull()));
    }
    
}
