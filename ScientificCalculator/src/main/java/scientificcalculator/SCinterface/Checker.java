/*
    GRUPPO 09
    GIANMARCO GUERRIERO
    ANGELO DI MIERI
    BIAGIO DE MARTINO
    ANTONIO CARBONE
*/

package scientificcalculator.SCinterface;

import java.util.regex.Pattern;
import scientificcalculator.classes.Vars;
import scientificcalculator.exceptions.InvalidInputException;

public final class Checker {
    /* Con questo metodo si verifica l'input controllando che esso sia
    o un numero oppure un'operazione.Nel caso di input errato viene sollevata un'eccezione*/
    public static void checkInput(String input) throws InvalidInputException{
        if(checkOperation(input)==-1 && !isANumber(input))
            throw new InvalidInputException("Input errato!");
    }
    //Questo metodo verifica se l'input è un numero.
    public static boolean isANumber(String input){
        /* Creiamo un pattern per controllare se il numero inserito è un
        numero nella forma ±Re±Imj. Re e Im possono essere anche dei numeri decimali.
        Un numero viene considerato decimale tramite il carattere '.'.Nella parte Re
        può essere omesso il segno, cosa che non può accadere per la parte Im.
        In questo caso l'input deve terminare con la lettera 'j'.*/
        Pattern pattern = Pattern.compile("[+-]?\\d*\\.?\\d+[-+]\\d*\\.?\\d+j");
        // Se l'input corrisponde con il pattern, viene restituito true.
        if(pattern.matcher(input).matches()){
            return true;
        }
        
        /* Creiamo un pattern per controllare se il numero inserito è un
        numero nella forma ±Re, e può essere decimale. Per numeri positivi
        il segno può essere omesso.*/
        pattern = Pattern.compile("[+-]?\\d*\\.?\\d+");
        // Se l'input corrisponde con il pattern, viene restituito true.
        if(pattern.matcher(input).matches()){
            return true;
        }
        
        /* Creiamo un pattern per controllare se il numero inserito è un
        numero nella forma ±Imj, e può essere decimale. Per numeri positivi
        il segno può essere omesso.In questo caso l'input deve terminare 
        con la lettera 'j'.*/
        pattern = Pattern.compile("[+-]?\\d*\\.?\\d+j");
        // Se l'input corrisponde con il pattern, viene restituito true.
        if(pattern.matcher(input).matches()){
            return true;
        }
        // Se non è un numero restituisce false
        return false;
    }
    /*Questo metodo verifica se l'input è un'operazione.Ad ogni operazione viene
    associato un valore int. Nel caso non si un'operazione viene ritornato -1*/
    public static int checkOperation(String input){
        switch(input){
            case "+":
                return 1;
            case "-":
                return 2;    
            case "×":
                return 3;
            case "÷":
                return 4;
            case "±":
                return 5;
            case "√":
                return 6;    
            case "CLR":
                return 11;
            case "DRP":
                return 12;
            case "SWP":
                return 13;
            case "DUP":
                return 14;    
            case "OVR":
                return 15;
            default:
                return -1;
        }
    }
    /*Questo metodo verifica se la variabile è inizializzata. Prima controllando
    se è contenuta all'interno della classe var. Poi verificando che il suo valore
    sia diverso da null*/
    public static boolean isInitialized(Vars var,Character variable){
        return (var.getVariables().containsKey(variable)) && (var.getVariables().get(variable) != null);
    }
}
