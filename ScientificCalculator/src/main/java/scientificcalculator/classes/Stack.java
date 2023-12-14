/*
    GRUPPO 09
    GIANMARCO GUERRIERO
    ANGELO DI MIERI
    BIAGIO DE MARTINO
    ANTONIO CARBONE
*/

package scientificcalculator.classes;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import scientificcalculator.exceptions.InvalidOperandsException;

public class Stack {

    private Deque<ComplexNumber> stack;
    
    //Costruttore della classe Stack che instanzia la struttura dati LinkedList
    public Stack() {
        stack = new LinkedList();
    }
    
    //Metodo che aggiunge un elemento in testa allo Stack
    public void push(ComplexNumber input) {
        stack.addFirst(input);
    }

    //Metodo che rimuove un elemento in testa allo Stack
    public ComplexNumber pop() {
        ComplexNumber c = null;
        /*In caso di stack vuoto gestisco l'eccezione sollevata, lanciando
        un'altra eccezione gestita poi dal controller*/
        try{
            c = stack.removeFirst();
        }catch(NoSuchElementException ex){
            throw new InvalidOperandsException("Numero di operandi insufficiente");
        }
        return c;
    }
    
    //Metodo che preleva un elemento in testa allo Stack senza rimuoverlo
    public ComplexNumber top() {
        ComplexNumber c = stack.peekFirst();
        
        /*Nel caso in cui c sia null significa che lo stack è vuoto. Gestisco
        questa situazione lanciando un'eccezione*/
        if(c == null)
            throw new InvalidOperandsException("Numero di operandi insufficiente");
        return c;
    }
    
    //Metodo che gestisce l'operazione di clear
    public void clear() {
        stack.clear();
    }
    
    //Metodo che gestisce l'operazione di drop
    public void drop() throws InvalidOperandsException {
        this.pop();
    }

    //Metodo che gestisce l'operazione di swap
    public void swap() throws InvalidOperandsException {
        //Nel caso in cui non siano presenti almeno 2 elementi viene sollevata l'eccezione
        if(stack.size()<2){
            throw new InvalidOperandsException("Numero di operandi insufficiente!");
        }
        
        //Prelevo i 2 elementi dallo stack, sono sicuro che siano presenti
        ComplexNumber last = this.pop();
        ComplexNumber beforeLast = this.pop();
        
        //Inserisco nell'ordine corretto i 2 elementi all'interno dello stack
        this.push(last);
        this.push(beforeLast);

    }

    //Metodo che gestisce l'operazione di duplicate
    public void duplicate() throws InvalidOperandsException {
        //Nel caso di stack vuoto viene rilanciato l'eccezione
        ComplexNumber last = this.top();
        
        //Duplico la testa dello staclìk
        stack.push(last);

    }
    
    //Metodo che gestisce l'operazione di over
    public void over() throws InvalidOperandsException {
        //Nel caso in cui non siano presenti almeno 2 elementi viene sollevata l'eccezione
        if(stack.size()<2){
            throw new InvalidOperandsException("Numero di operandi insufficiente!");
        }
        
        //Ottengo i 2 elementi dallo stack, sono sicuro che siano presenti
        ComplexNumber last = this.pop();
        ComplexNumber beforeLast = this.top();
        
        //Inserisco nell'ordine corretto i 2 elementi all'interno dello stack
        this.push(last);
        this.push(beforeLast);

    }

    public Deque<ComplexNumber> getStack() {
        return stack;
    }

}
