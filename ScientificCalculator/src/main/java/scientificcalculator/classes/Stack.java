package scientificcalculator.classes;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

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
            c = stack.peekFirst();stack.removeFirst();
        }catch(NoSuchElementException ex){
            System.out.println("Stack vuoto gay!");
        }
        return c;
    }

    public ComplexNumber top() {
        ComplexNumber c = null;
        try{
            c = stack.peekFirst();
        }catch(NoSuchElementException ex){
            System.out.println("Stack vuoto gay!");
        }
        return c;
    }

    public void clear() {
        stack.clear();

    }

    public void drop() {
        this.pop();
    }

    public void swap() {
        ComplexNumber last = this.pop();
        ComplexNumber beforeLast = this.pop();
        this.push(last);
        this.push(beforeLast);

    }

    public void duplicate() {
        ComplexNumber last = this.top();
        stack.push(last);

    }

    public void over() {
        ComplexNumber last = this.pop();
        ComplexNumber beforeLast = this.top();
        this.push(last);
        this.push(beforeLast);

    }

    public Deque<ComplexNumber> getStack() {
        return stack;
    }

}
