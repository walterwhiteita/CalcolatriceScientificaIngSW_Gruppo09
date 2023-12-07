package scientificcalculator.SCinterface;

import java.util.regex.Pattern;
import scientificcalculator.classes.Vars;
import scientificcalculator.exceptions.InvalidInputException;

public final class Checker {
    public static void checkInput(String input) throws InvalidInputException{
        if(checkOperation(input)==-1 && !isANumber(input))
            throw new InvalidInputException();
    }
    public static boolean isANumber(String input){
        Pattern pattern = Pattern.compile("[-+]?\\d*\\.?\\d+[-+]\\d*\\.?\\d+j");
        // Match regex against input
        if(pattern.matcher(input).matches()){
            System.out.println("Complesso");
            return true;
        }
        pattern = Pattern.compile("[-+]?\\d*\\.?\\d+");
        if(pattern.matcher(input).matches()){
            System.out.println("Reale");
            return true;
        }
        pattern = Pattern.compile("[-+]?\\d*\\.?\\d+j");
        if(pattern.matcher(input).matches()){
            System.out.println("Immaginario");
            return true;
        }
        System.out.println("No match");
        return false;
    }
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
    public static boolean isInitialized(Vars var,Character variable){
        return (var.getVariables().containsKey(variable)) && (var.getVariables().get(variable) != null);
    }
}
