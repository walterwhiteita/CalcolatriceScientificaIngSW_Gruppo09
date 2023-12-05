package scientificcalculator.classes;

import java.util.Map;

public class Vars {
    private Map<Character, ComplexNumber> variables;
    private Stack stack;
    //Only for debug
    private ComplexNumber n;
    public Vars(Stack stack) {
        this.stack = stack;
    }
    public void popFromStack(Character variable){
        
    }
    public void pushInStack(Character variable){
        
    }
    public void suzmFromStack(Character variable){
        
    }
    public void subFromStack(Character variable){
        
    }
    public ComplexNumber getValueOf(Character variable){
        return n;
    }
    public void setValueOf(Character variable, ComplexNumber n){
        
    }

    public Map<Character, ComplexNumber> getVariables() {
        return variables;
    }
    public Stack getStack() {
        return stack;
    }
    

    
}
