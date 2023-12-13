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
    
    public ScientificCalculator() {
        this.stack=new Stack();
        this.vars=new Vars(this.stack);
    }
  
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
    
    public void sum() throws InvalidOperandsException{
        if(stack.getStack().size()<2){
            throw new InvalidOperandsException("Numeri di operandi per l'addizione!");
        }
        ComplexNumber n2 = stack.pop();
        ComplexNumber n1 = stack.pop();
        stack.push(BinaryCanonicOperations.sum(n1,n2));
    }
    
    public void sub() throws InvalidOperandsException{
        if(stack.getStack().size()<2){
            throw new InvalidOperandsException("Numeri di operandi per la sottrazione!");
        }
        ComplexNumber n2 = stack.pop();
        ComplexNumber n1 = stack.pop();
        stack.push(BinaryCanonicOperations.sub(n1,n2));
    }
    
    public void multiply() throws InvalidOperandsException{
        if(stack.getStack().size()<2){
            throw new InvalidOperandsException("Numeri di operandi per la moltiplicazione!");
        }
        ComplexNumber n2 = stack.pop();
        ComplexNumber n1 = stack.pop();
        stack.push(BinaryCanonicOperations.multiply(n1,n2));
    }
    
    public void divide() throws InvalidOperandsException,ArithmeticException{
        if(stack.top().getRealPart().doubleValue()==0 && stack.top().getImaginaryPart().doubleValue()==0){
            throw new ArithmeticException("Divisione per zero");
        }
        if(stack.getStack().size()<2){
            throw new InvalidOperandsException("Numero di operandi insufficiente per la divisione!");
        }
        ComplexNumber n2 = stack.pop();
        ComplexNumber n1 = stack.pop();
        stack.push(BinaryCanonicOperations.divide(n1,n2));
    }
    
    public void squareRoot() throws InvalidOperandsException{
        if(stack.top().getModule().doubleValue()==0){
            stack.pop();
            stack.push(new ComplexNumber(BigDecimal.ZERO,BigDecimal.ZERO));
            return;
        }
        ComplexNumber radixs[];
        radixs = UnaryCanonicOperations.squareRoot(stack.pop());
        stack.push(radixs[0]);
        stack.push(radixs[1]);
    }
    
    public void changeSign() throws InvalidOperandsException{
        stack.push(UnaryCanonicOperations.changeSign(stack.pop()));
    }
    
    public void insertComplexNumber(String input){
        stack.push(formatComplexNumber(input));
    }
    
    private ComplexNumber formatComplexNumber(String input){
        Pattern pattern = Pattern.compile("[-+]?\\d*\\.?\\d+[-+]\\d*\\.?\\d+j");
        if(pattern.matcher(input).matches()){
            input = input.replace("j","");
            String[] numbers = input.split("(?<=\\d)(?=[+-])");
            return new ComplexNumber(new BigDecimal(numbers[0]),new BigDecimal(numbers[0]));
        }
        pattern = Pattern.compile("[-+]?\\d*\\.?\\d+");
        if(pattern.matcher(input).matches()){
            return new ComplexNumber(new BigDecimal(input),BigDecimal.ZERO);
        }
        input = input.replace("j","");
        return new ComplexNumber(BigDecimal.ZERO,new BigDecimal(input));
    } 

    public Stack getStack() {
        return stack;
    }

    public Vars getVars() {
        return vars;
    }
    
}
