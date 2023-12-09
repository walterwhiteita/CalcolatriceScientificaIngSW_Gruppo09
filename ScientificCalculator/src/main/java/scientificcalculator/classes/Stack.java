package scientificcalculator.classes;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import scientificcalculator.exceptions.InvalidOperandsException;

public class Stack {

    private Deque<ComplexNumber> stack;
    //Only for debug
    private ComplexNumber n;

    public Stack() {
        stack = new LinkedList();
    }

    public void push(ComplexNumber input) {
        stack.addFirst(input);
    }

    public ComplexNumber pop() {
        ComplexNumber c = null;
        try{
            c = stack.removeFirst();
        }catch(NoSuchElementException ex){
            throw new InvalidOperandsException("Numero di operandi insufficiente");
        }
        return c;
    }

    public ComplexNumber top() {
        ComplexNumber c = stack.peekFirst();
        if(c == null)
            throw new InvalidOperandsException("Numero di operandi insufficiente");
        return c;
    }

    public void clear() {
        stack.clear();
    }

    public void drop() throws InvalidOperandsException {
        this.pop();
    }

    public void swap() throws InvalidOperandsException {
        if(stack.size()<2){
            throw new InvalidOperandsException("Numero di operandi insufficiente!");
        }
        ComplexNumber last = this.pop();
        ComplexNumber beforeLast = this.pop();
        this.push(last);
        this.push(beforeLast);

    }

    public void duplicate() throws InvalidOperandsException {
        ComplexNumber last = this.top();
        stack.push(last);

    }

    public void over() throws InvalidOperandsException {
        if(stack.size()<2){
            throw new InvalidOperandsException("Numero di operandi insufficiente!");
        }
        ComplexNumber last = this.pop();
        ComplexNumber beforeLast = this.top();
        this.push(last);
        this.push(beforeLast);

    }

    public Deque<ComplexNumber> getStack() {
        return stack;
    }

}
