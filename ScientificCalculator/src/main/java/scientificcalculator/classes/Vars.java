package scientificcalculator.classes;

import java.util.HashMap;
import java.util.Map;
import scientificcalculator.exceptions.UninitializedVariableException;
import scientificcalculator.exceptions.InvalidOperandsException;

public class Vars {
    public Map<Character, ComplexNumber> variables;
    private Stack stack;

    public Vars(Stack stack) {
        this.variables = new HashMap<>();
        this.stack = stack;
    }
    
    public void popFromStack(Character variable) throws InvalidOperandsException{
        this.setValueOf(variable, this.stack.pop());
    }
    
    public void pushInStack(Character variable) throws UninitializedVariableException{
        if(!this.variables.containsKey(variable))
            throw new UninitializedVariableException("Variabile selezionata non inizializzata!");
        
        this.stack.push(this.variables.remove(variable));
    }
    
    public void sumFromStack(Character variable) throws InvalidOperandsException, UninitializedVariableException{
        if(!this.variables.containsKey(variable))
            throw new UninitializedVariableException("Variabile selezionata non inizializzata!");
        
        ComplexNumber num1 = this.stack.pop();
        ComplexNumber num2 = this.variables.remove(variable);
        
        this.setValueOf(variable, BinaryCanonicOperations.sum(num2, num1));
    }
    
    public void subFromStack(Character variable) throws InvalidOperandsException, UninitializedVariableException{
        if(!this.variables.containsKey(variable))
            throw new UninitializedVariableException("Variabile selezionata non inizializzata!");
        
        ComplexNumber num1 = this.stack.pop();
        ComplexNumber num2 = this.variables.remove(variable);
        
        this.setValueOf(variable, BinaryCanonicOperations.sub(num2, num1));
    }
    
    public ComplexNumber getValueOf(Character variable){
        return this.variables.get(variable);
    }
    
    public void setValueOf(Character variable, ComplexNumber n){
        this.variables.put(variable, n);
    }

    public Map<Character, ComplexNumber> getVariables() {
        return variables;
    }
    
    public Stack getStack() {
        return stack;
    }
}
