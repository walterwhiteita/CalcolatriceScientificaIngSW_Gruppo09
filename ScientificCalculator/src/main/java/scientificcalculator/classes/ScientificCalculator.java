/*
    GRUPPO 09
    GIANMARCO GUERRIERO
    ANGELO DI MIERI
    BIAGIO DE MARTINO
    ANTONIO CARBONE
*/

package scientificcalculator.classes;

import java.math.BigDecimal;
import java.util.regex.Pattern;
import scientificcalculator.exceptions.InvalidOperandsException;
import scientificcalculator.exceptions.UninitializedVariableException;

public class ScientificCalculator {
    private Stack stack;
    private Vars vars;
    
    //Costruttore della classe ScientificCalculator
    public ScientificCalculator() {
        this.stack=new Stack();
        this.vars=new Vars(this.stack);
    }
    
    //Viene chiamato il metodo corretto in corrispondenza dell'operazione selezionata
    public void execute(int input) throws InvalidOperandsException, ArithmeticException{
        switch(input){
            case 1:
                sum();
                break;
            case 2:
                sub();
                break;
            case 3:
                multiply();
                break;
            case 4:
                divide();
                break;
            case 5:
                changeSign();
                break;
            case 6:
                squareRoot();
                break;
            case 11:
                stack.clear();
                break;
            case 12:
                stack.drop();
                break;
            case 13:
                stack.swap();
                break;
            case 14:
                stack.duplicate();
                break;
            case 15:
                stack.over();
                break;
            default:
        }
    }
    
    //Viene chiamato il metodo corretto in corrispondenza dell'operazione sulla variabile selezionata
    public void executeOnVariable(Character variable, Character operation) throws InvalidOperandsException, UninitializedVariableException{
        switch(operation){
            case '>':{
                vars.popFromStack(variable);
                break;
            }
            case '<':{
                vars.pushInStack(variable);
                break;
            }
            case '+':{
                vars.sumFromStack(variable);
                break;
            }
            case '-':{
                vars.subFromStack(variable);
                break;
            }
        }
    }
    
    //Metodo che gestisce la somma
    public void sum() throws InvalidOperandsException{
        //Nel caso in cui non siano presenti almeno 2 elementi viene sollevata l'eccezione
        if(stack.getStack().size()<2){
            throw new InvalidOperandsException("Numeri di operandi per l'addizione!");
        }
        
        //Prelevo i 2 elementi dallo stack, sono sicuro che siano presenti
        ComplexNumber n2 = stack.pop();
        ComplexNumber n1 = stack.pop();
        
        //Inserisco in testa allo stack il risultato della somma
        stack.push(BinaryCanonicOperations.sum(n1,n2));
    }
    
    //Metodo che gestisce la sottrazione
    public void sub() throws InvalidOperandsException{
        //Nel caso in cui non siano presenti almeno 2 elementi viene sollevata l'eccezione
        if(stack.getStack().size()<2){
            throw new InvalidOperandsException("Numeri di operandi per la sottrazione!");
        }
        
        //Prelevo i 2 elementi dallo stack, sono sicuro che siano presenti
        ComplexNumber n2 = stack.pop();
        ComplexNumber n1 = stack.pop();
        
        //Inserisco in testa allo stack il risultato della sottrazione
        stack.push(BinaryCanonicOperations.sub(n1,n2));
    }
    
    //Metodo che gestisce la moltiplicazione
    public void multiply() throws InvalidOperandsException{
        //Nel caso in cui non siano presenti almeno 2 elementi viene sollevata l'eccezione
        if(stack.getStack().size()<2){
            throw new InvalidOperandsException("Numeri di operandi per la moltiplicazione!");
        }
        
        //Prelevo i 2 elementi dallo stack, sono sicuro che siano presenti
        ComplexNumber n2 = stack.pop();
        ComplexNumber n1 = stack.pop();
        
        //Inserisco in testa allo stack il risultato della moltiplicazione
        stack.push(BinaryCanonicOperations.multiply(n1,n2));
    }
    
    //Metodo che gestisce la divisione
    public void divide() throws InvalidOperandsException,ArithmeticException{
        /*Se il numero è pari a zero, viene sollevata un'ArithmeticException,
        per permettere all'interfaccia di notificare all'utente che la divisione
        per zero non è possibile*/
        if(stack.top().getRealPart().doubleValue()==0 
                && stack.top().getImaginaryPart().doubleValue()==0){
            throw new ArithmeticException("Divisione per zero");
        }
        
        //Nel caso in cui non siano presenti almeno 2 elementi viene sollevata l'eccezione
        if(stack.getStack().size()<2){
            throw new InvalidOperandsException("Numero di operandi insufficiente per la divisione!");
        }
        
        //Prelevo i 2 elementi dallo stack, sono sicuro che siano presenti
        ComplexNumber n2 = stack.pop();
        ComplexNumber n1 = stack.pop();
        
        //Inserisco in testa allo stack il risultato della divisione
        stack.push(BinaryCanonicOperations.divide(n1,n2));
    }
    
    //Metodo che gestisce la radice quadrata
    public void squareRoot() throws InvalidOperandsException{
        /* Se il numero inserito è pari a 0, non ne calcolo le radici poichè è 
        esso stesso la radice.*/
        if(stack.top().getModule().doubleValue()==0){
            stack.pop();
            stack.push(new ComplexNumber(BigDecimal.ZERO,BigDecimal.ZERO));
            return;
        }
        
        //Alloco il vettore per salvare i valori delle radici
        ComplexNumber radixs[];
        
        /*Calcolo le radici. Nel caso in cui non sia presente almeno un numero 
        all'interno dello stack, il metodo pop lancia un'eccezione che viene 
        rilanciata fino al controller che la gestisce.*/
        radixs = UnaryCanonicOperations.squareRoot(stack.pop());
        
        //Inserisco i risultati delle radici all'interno dello stack
        stack.push(radixs[0]);
        stack.push(radixs[1]);
    }
    
    //Metodo che gestisce l'operazione di cambio segno
    public void changeSign() throws InvalidOperandsException{
        /*Effettuo il cambio segno. Nel caso in cui non sia presente almeno un numero 
        all'interno dello stack, il metodo pop lancia un'eccezione che viene 
        rilanciata fino al controller che la gestisce.*/
        stack.push(UnaryCanonicOperations.changeSign(stack.pop()));
    }
    
    //Metodo che inserisce nello stack un ComplexNumber
    public void insertComplexNumber(String input){
        //Inserisco nello stack il ComplexNumber generato dalla formatComplexNumber
        stack.push(formatComplexNumber(input));
    }
    
    
    private ComplexNumber formatComplexNumber(String input){
        //Creo il pattern per i numeri nella forma ±Re±Imj.
        Pattern pattern = Pattern.compile("[-+]?\\d*\\.?\\d+[-+]\\d*\\.?\\d+j");
        
        //Se l'input corrisponde al pattern è un numero con parte reale e immaginaria
        if(pattern.matcher(input).matches()){
            //Rimuovo la lettra j dalla stringa, prima di lavorarla
            input = input.replace("j","");
            
            /*Ottengo un vettore di stringhe, dove in prima posizione vi può essere
            un numero senza segno, mentre nelle successive posizioni la presenza
            del segno è obbligatoria.*/
            String[] numbers = input.split("(?<=\\d)(?=[+-])");
            
            //Restituisco il numero complesso
            return new ComplexNumber(new BigDecimal(numbers[0]),new BigDecimal(numbers[1]));
        }
        //Creo il pattern per i numeri nella forma ±Re
        pattern = Pattern.compile("[-+]?\\d*\\.?\\d+");
        
        //Se l'input corrisponde al pattern è un numero a sola parte reale
        if(pattern.matcher(input).matches()){
            
            //Restituisco il numero complesso
            return new ComplexNumber(new BigDecimal(input),BigDecimal.ZERO);
        }
        
        /*Poichè l'input viene controllato dalla classe controller, e questo metodo
        viene chiamato solo se l'input è un numero, non essendo entrato in nessuno
        degli if sono sicuro che il numero abbia solo parte immaginaria.*/
        
        //Rimuovo la lettera j dalla stringa, prima di lavorla
        input = input.replace("j","");
        
        //Restituisco il numero complesso
        return new ComplexNumber(BigDecimal.ZERO,new BigDecimal(input));
    } 

    public Stack getStack() {
        return stack;
    }

    public Vars getVars() {
        return vars;
    }
    
}
