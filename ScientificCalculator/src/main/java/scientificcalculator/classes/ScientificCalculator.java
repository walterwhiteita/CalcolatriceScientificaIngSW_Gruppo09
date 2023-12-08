package scientificcalculator.classes;

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
  
    public void execute(int input) throws InvalidOperandsException{
        switch(input){
            case 1:
                this.sum();
                break;
            case 2:
                this.sub();
                break;
            case 3:
                this.multiply();
                break;
            case 4:
                this.divide();
            case 5:
                this.changeSign();
                break;
            case 6:
                this.squareRoot();
                break;
            case 11:
                stack.clear();
                break;
            case 12:
                stack.drop();
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
        System.out.println("Sto facendo la somma");
        stack.push(BinaryCanonicOperations.sum(stack.pop(),stack.pop()));
    }
    
    public void sub() throws InvalidOperandsException{
        stack.push(BinaryCanonicOperations.sub(stack.pop(),stack.pop()));
    }
    
    public void multiply() throws InvalidOperandsException{
        stack.push(BinaryCanonicOperations.multiply(stack.pop(),stack.pop()));
    }
    
    public void divide() throws InvalidOperandsException{
        stack.push(BinaryCanonicOperations.divide(stack.pop(),stack.pop()));
    }
    
    public void squareRoot() throws InvalidOperandsException{
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
            System.out.println(input);
            String[] numbers = input.split("(?<=\\d)(?=[+-])");
            return new ComplexNumber(Double.parseDouble(numbers[0]),Double.parseDouble(numbers[1]));
        }
        pattern = Pattern.compile("[-+]?\\d*\\.?\\d+");
        if(pattern.matcher(input).matches()){
            System.out.println(input);
            return new ComplexNumber(Double.parseDouble(input),0);
        }
        input = input.replace("j","");
        System.out.println("Immaginario");
        System.out.println(input);
        return new ComplexNumber(0,Double.parseDouble(input));
    } 

    public Stack getStack() {
        return stack;
    }

    public Vars getVars() {
        return vars;
    }
    
}
