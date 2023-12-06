/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package scientificcalculator.classes;

/**
 *
 * @author Gianmarco Uni
 */
public class TestStack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stack s = new Stack();
        
        s.push(new ComplexNumber(3, 5));
        s.push(new ComplexNumber(2, 3));
        s.push(new ComplexNumber(8, 3));
        
        System.out.println("Prova 1");
        for(ComplexNumber c : s.getStack()){
            System.out.println(c);
        }
        
        s.drop();
        System.out.println("Prova drop");
        for(ComplexNumber c : s.getStack()){
            System.out.println(c);
        }
        
        /*s.duplicate();
        System.out.println("Prova dup");
        for(ComplexNumber c : s.getStack()){
            System.out.println(c);
        }*/
        
        s.over();
        System.out.println("Prova over");
        for(ComplexNumber c : s.getStack()){
            System.out.println(c);
        }
        
        s.swap();
        System.out.println("Prova swap");
        for(ComplexNumber c : s.getStack()){
            System.out.println(c);
        }
        
        s.clear();
        s.pop();
        s.top();
        s.drop();
        
    }
    
}
