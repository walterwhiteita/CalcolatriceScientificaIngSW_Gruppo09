/*
    GRUPPO 09
    GIANMARCO GUERRIERO
    ANGELO DI MIERI
    BIAGIO DE MARTINO
    ANTONIO CARBONE
*/

package scientificcalculator.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import scientificcalculator.exceptions.UninitializedVariableException;
import scientificcalculator.exceptions.InvalidOperandsException;

public class Vars {
    private Map<Character, ComplexNumber> variables;
    private Stack stack;

    /*
        Costruttore, inizializza gli attributi della classe.
        Per l'implementazione della struttura dati responsabile della memorizzazione
        delle variabili è stata scelta una HashMap<Character, ComplexNumber>, per poter gestire 
        le assiociazioni variabile-valore con esclusione di duplicati.
    */
    public Vars(Stack stack) {
        this.variables = new HashMap<>();
        this.stack = stack;
    }
    
    /*
        Metodo responsabile dell'implementazione dell'operazione ">x",
        rilancia l'eccezione che potrebbe essere generata dal tentato accesso
        ad uno stack vuoto (lanciata dal metodo pop della classe Stack).
    */
    public void popFromStack(Character variable) throws InvalidOperandsException{
        this.setValueOf(variable, this.stack.pop());
    }
    
    /*
        Metodo responsabile dell'implementazione dell'operazione "<x",
        lancia un'eccezione nel momento in cui si dovesse tentare l'accesso ad una variabile
        non ancora inizializzata.
    */
    public void pushInStack(Character variable) throws UninitializedVariableException{
        if(!this.variables.containsKey(variable))
            throw new UninitializedVariableException("Variabile selezionata non inizializzata!");
        
        this.stack.push(this.variables.remove(variable));
    }
    
    /*
        Metodo responsabile dell'implementazione dell'operazione "+x",
        rilancia l'eccezione (lanciata dal metodo pop della classe Stack) 
        nel caso in cui si dovesse tentare l'accesso ad uno stack vuoto e lancia 
        un'eccezione nel momento in cui la variabile passata come argomento
        dovesse risultare ancora non inizializzata.
    */
    public void sumFromStack(Character variable) throws InvalidOperandsException, UninitializedVariableException{
        if(!this.variables.containsKey(variable))
            throw new UninitializedVariableException("Variabile selezionata non inizializzata!");
        
        ComplexNumber num2 = this.stack.pop();
        ComplexNumber num1 = this.variables.remove(variable);
        
        this.setValueOf(variable, BinaryCanonicOperations.sum(num1, num2));
    }
    
    /*
        Metodo responsabile dell'implementazione dell'operazione "-x",
        rilancia l'eccezione (lanciata dal metodo pop della classe Stack) 
        nel caso in cui si dovesse tentare l'accesso ad uno stack vuoto e lancia 
        un'eccezione nel momento in cui la variabile passata come argomento
        dovesse risultare ancora non inizializzata.
    */
    public void subFromStack(Character variable) throws InvalidOperandsException, UninitializedVariableException{
        if(!this.variables.containsKey(variable)) //Verifica che la chiave 'variable' sia presente nella map.
            throw new UninitializedVariableException("Variabile selezionata non inizializzata!");
        
        ComplexNumber num2 = this.stack.pop();
        ComplexNumber num1 = this.variables.remove(variable);
        
        this.setValueOf(variable, BinaryCanonicOperations.sub(num1, num2));
    }
    
    /*
        Metodo che restituisce il ComplexNumber associato alla variabile
        'variable' passata come argomento.
    */
    public ComplexNumber getValueOf(Character variable){
        return this.variables.get(variable);
    }
    
    /*
        Metodo che permette di inserire nella HashMap variables
        l'associazione 'variable'-'n' passata come argomento.
    */
    public void setValueOf(Character variable, ComplexNumber n){
        this.variables.put(variable, n);
    }

    /*
        Metodo che restituisce il reference alla HashMap<Character, ComplexNumber> 'variables'.
    */
    public Map<Character, ComplexNumber> getVariables() {
        return variables;
    }
    
    /*
        Metodo che restituisce il reference all'oggetto di tipo Stack 'stack'.
    */
    public Stack getStack() {
        return stack;
    }
    
    /*
        Metodo che resstituisce sotto forma di ArrayList<String> la HashMap definita in questa classe.
        Utile a costruire la schermata di visualizzazione delle variabili allocate.
    */
    public ArrayList<String> toStringArrayList() {
        ArrayList<String> out = new ArrayList<>();
        for(Entry<Character, ComplexNumber> element : this.variables.entrySet()){
            StringBuffer sb = new StringBuffer();
            sb.append(element.getKey().toString());
            sb.append(" = ");
            sb.append(element.getValue().toString());
            out.add(sb.toString());
            out.sort(null);
        }
        return out;
    }
}
