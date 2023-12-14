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
    private Character variable;
    private Character operation;
    
    /*Metodo che gestisce la pressione del tasto INVIO presente sull'interfaccia,
    effettuando controlli sull'input e gestendo le varie eccezioni che posso essere sollevate*/ 
    @FXML
    private void handleInvio(ActionEvent event) {
        //Ottengo il testo presente nel TextField
        String input = text.getText();
        try{
            //Controllo l'input
            checkInput(input);
            //Se è un numero viene chiamato il metodo appropriato
            if(isANumber(input))
                calculator.insertComplexNumber(input);
            //Se è un'operazione viene chiamato il metodo di esecuzione dell'operazione
            else
                calculator.execute(checkOperation(input));
            //Ripulisco il TextField
            text.clear();
            //Aggiorno la visualizzazione dello stack e poi delle variabili inizializzate
            vBoxStackUpdate();
            vBoxVariableUpdate();
        }catch(InvalidInputException ex){
            /*Nel caso in cui venga sollevata quest'eccezione dalla checkInput la gestisco
            mostrando un pop-up in cui si fa notare all'utente che l'input è errato*/
            
            a.setAlertType(AlertType.ERROR);
            a.setTitle(ex.getMessage());
            a.setContentText("L'input "+input+" è errato!\nInserisci correttamente un numero un'operazione\nAd esempio : 3+3j o CLR");
            a.setResizable(true);
            //Aspetto che l'utente chiudi il pop-up
            a.showAndWait();
        }catch(InvalidOperandsException ex){
            /*Nel caso in cui venga sollevata quest'eccezione dai metodi chiamati dalla execute
            la gestisco mostrando un pop-up in cui si fa notare all'utente che l'operazione 
            non è possibile per numero insufficiente di operandi*/
            
            a.setAlertType(AlertType.WARNING);
            a.setTitle(ex.getMessage());
            a.setContentText("L'operazione selezionata non è possibile\nper numero insufficiente di operandi");
            a.setResizable(true);
            //Aspetto che l'utente chiudi il pop-up
            a.showAndWait();
        }catch(ArithmeticException ex){
            /*Nel caso in cui venga sollevata quest'eccezione dalla execute la gestisco
            mostrando un pop-up in cui si fa notare all'utente che l'operazione di divisione
            per zero non è possibile*/
            a.setAlertType(AlertType.WARNING);
            a.setTitle(ex.getMessage());
            a.setContentText("Impossibile eseguire la divisione per zero!\n");
            a.setResizable(true);
            //Aspetto che l'utente chiudi il pop-up
            a.showAndWait();
        }
        finally{
            /*Per evitare incongruenze tra le strutture dati e l'interfaccia grafica,
            vengono comunque chiamati i metodi per aggiornare le loro visualizzazioni*/
            
            vBoxStackUpdate();
            vBoxVariableUpdate();
        }
    }
    
    /*Metodo che aggiorna la TextField aggiungendo al testo precedente,
    il testo del bottone premuto*/
    @FXML
    private void inputFromUI(ActionEvent event) {
        Button b=(Button)event.getSource();
        text.setText(text.getText()+ b.getText());
    }
    
    /*Metodo che aggiorna la TextField con il testo del bottone premuto. Prima di
    effettuare l'aggiornamento ripulisce il campo del TextField. Questa operazione
    è legata a valori di input che necessitano di una corretta formattazione, 
    come le operazioni sullo stack*/
    @FXML
    private void inputFromUIwithClear(ActionEvent event) {
        Button b=(Button)event.getSource();
        text.clear();
        text.setText(b.getText());
    }
    
    //Metodo che pulisce il campo del TextField, collegato al bottone DELETE dell'interfaccia
    @FXML
    private void delete(ActionEvent event) {
        text.clear();
    }
    
    /*Metodo che gestisce la pressione del tasto ENTER sulla tastiera richiamando handleInvio.
    In questo modo la pressione del tasto ENTER è trasparente al programma*/
    @FXML
    private void handleKeyPressed(KeyEvent ke){
        if(ke.getCode().toString().equals("ENTER")){
            handleInvio(null);   
        }
    }
    
    //Metodo che nasconde la visualizzazione del tastierino numerico e dei tasti operazione
    @FXML
    private void handleVariable() {
       insertNumberAnchor.setVisible(false);
    }
    
    //Metodo che fa comparire il tastierino numerico e i tasti operazione
    @FXML
    private void backFromVariable() {
       insertNumberAnchor.setVisible(true);
    }
    
    //Viene salvata in memoria la variabile selezionata nella ComboBox
    @FXML
    private void selectVariable(ActionEvent event) {
        ComboBox var = (ComboBox)event.getSource();
        variable=var.getValue().toString().charAt(1);  
    }
    
    //Viene salvata in memoria l'operazione selezionata nella ComboBox
    @FXML
    private void selectOperation(ActionEvent event) {
        ComboBox op = (ComboBox)event.getSource();
        operation=op.getValue().toString().charAt(1);    
    }
    
    //Metodo che gestisce le operazioni sulle variabili chiamando i metodi appropriati
    @FXML
    private void executeOperationOnVariable(ActionEvent event){
        //Inizializzo la variabile conferma a OK
        String conferma = "OK";
        if(isInitialized(calculator.getVars(),variable) && operation.equals('>')){
            /*Nel caso in cui si vuole eseguire un'operazione di inizializzazione 
            di una variabile e la variabile selezionata è gia inizializzata, viene
            mostrato schermo un pop-up per confermare l'operazione.*/
            
            a.setAlertType(AlertType.CONFIRMATION);
            a.setTitle("Variabile inizializzata!");
            a.setContentText("Attenzione!La variabile è già inizializzata!\n"
                            + "Si desidera procedere con la sovrascrittura?");
            a.setResizable(true);
            a.showAndWait();
            conferma = a.getResult().getText();
        }
        /*Nel caso in cui l'utente ha confermato l'operazione o la variabile non
        è inizializzata procedo ad eseguire l'operazione*/
       
        if (conferma.equals("OK")){
            try{
                //Viene chiamato il metodo della ScientifcCalculator per eseguire l'operazione
                calculator.executeOnVariable(variable, operation);
                //Aggiorno la visualizzazione dello stack e poi delle variabili inizializzate
                vBoxVariableUpdate();
                vBoxStackUpdate();
            }catch(InvalidOperandsException ex){
                /*Nel caso in cui venga sollevata quest'eccezione dai metodi chiamati
                da executeOnVariable la gestisco mostrando un pop-up in cui si fa notare
                all'utente che l'operazione non è possibile per numero insufficiente di operandi*/
                
                a.setAlertType(AlertType.WARNING);
                a.setTitle(ex.getMessage());
                a.setContentText("L'operazione selezionata non è possibile\n"
                                + "per numero insufficiente di operandi");
                a.setResizable(true);
                //Aspetto che l'utente chiudi il pop-up
                a.showAndWait();
            }catch(UninitializedVariableException ex){
                /*Nel caso in cui venga sollevata quest'eccezione dai metodi chiamati
                da executeOnVariable la gestisco mostrando un pop-up in cui si fa notare
                all'utente che l'operazione non è possibile poichè la variabile non è inizializzata*/
                
                a.setAlertType(AlertType.WARNING);
                a.setTitle(ex.getMessage());
                a.setContentText("L'operazione selezionata non è possibile\n"
                                + "poichè la variabile selezionata non ha nessun valore");
                a.setResizable(true);
                //Aspetto che l'utente chiudi il pop-up
                a.showAndWait();
            }
            finally{
                /*Per evitare incongruenze tra le strutture dati e l'interfaccia grafica,
                vengono comunque chiamati i metodi per aggiornare le loro visualizzazioni*/
                
                vBoxStackUpdate();
                vBoxVariableUpdate();
            }
        }
        
    }
    
    //Metodo che aggiorna la visualizzazione dello stack
    private void vBoxVariableUpdate(){
        //Vengono rimosse tutte le label presenti
        vBoxVariable.getChildren().clear();
        //Vengono aggiunte man mano le varie Label all'interno della VBox delle variabili
        for(String n : calculator.getVars().toStringArrayList()){
            vBoxVariable.getChildren().add(generateLabel(n));
        }
    }
    
    //Metodo che aggiorna la visualizzazione della Map delle variabili
    private void vBoxStackUpdate(){
        vBoxStack.getChildren().clear();
        //Vengono aggiunte man mano le varie Label all'interno della VBox dello stack
        for(ComplexNumber n : calculator.getStack().getStack()){
            vBoxStack.getChildren().add(generateLabel(n.toString()));
        }
        
    }
    
    //Metodo che genera le label da inserire all'interno dei VBox
    private Label generateLabel(String stringa){
        Label label = new Label(stringa);
        label.setMinWidth(260.00);
        label.setMinHeight(45);
        label.setPadding(new Insets(5));
        return label;
    }
    
    //Metodo che viene chiamato per primo dall'applicazione quando viene avviata
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Viene popolata la ComboBox delle variabili
        for(int i=0;i<26;i++){
            comboBoxVariable.getItems().add(" "+(char)(i+65)+" ");
        }
        //Viene popolata la ComboBox delle operazioni
        comboBoxOperation.getItems().
                addAll(" > x "," < x "," + x "," - x ");
        /*Aggiungo una proprietà di binding al bottone INVIO, in modo che esso
        venga disabilitato nel caso in cui la TextField dell'interfaccia grafica è vuota*/
        
        buttonInvio.disableProperty().bind(Bindings.
                equal("",text.textProperty()));
        
        /*Aggiungo una proprietà di binding al bottone CONFERMA, in modo che esso
        venga disabilitato nel caso in cui l'utente non abbia selezionato
        almeno una variabile e almeno un'operazione nelle rispettive ComboBox*/
        
        buttonConferma.disableProperty().bind(comboBoxVariable.valueProperty().
                isNull().or(comboBoxOperation.valueProperty().isNull()));
    }
    
}
