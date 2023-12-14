package scientificcalculator.classes;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import scientificcalculator.exceptions.InvalidOperandsException;

/**
 *
 * @author antonio
 */
public class ScientificCalculatorTest {
    //Test metodo getStack()
    @Test
    public void testGetStack() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Test getStack()");
        ScientificCalculator sc = new ScientificCalculator();
        Field field = sc.getClass().getDeclaredField("stack");
        field.setAccessible(true);
        Stack s = new Stack();
        field.set(sc, s);
        assertEquals(s, sc.getStack());
    }
//Test metodo getVars()    
    @Test
    public void testGetVars() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Test getVars()");
        ScientificCalculator sc = new ScientificCalculator();
        Field field = sc.getClass().getDeclaredField("vars");
        field.setAccessible(true);
        Vars test = new Vars(new Stack());
        field.set(sc, test);
        assertEquals(test, sc.getVars());
    }
    
//Test metodo execute()
    
    @Test
    public void testExecute_01() {
        System.out.println("Test execute() con input=1 -> sum()");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        s.push(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("-59")));
        
        sc.execute(1); //sc.sum()
        assertEquals(new ComplexNumber(new BigDecimal("-10.472"), new BigDecimal("15")), s.pop());
    }
    
    @Test
    public void testExecute_02() {
        System.out.println("Test execute() con input=2 -> sub()");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        s.push(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("-59")));
        
        sc.execute(2); //sc.sub()
        assertEquals(new ComplexNumber(new BigDecimal("35.528"), new BigDecimal("133")), s.pop());
    }
      
    @Test
    public void testExecute_03() {
        System.out.println("Test execute() con input=3 -> multiply()");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        s.push(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("-59")));
        
        sc.execute(3); //sc.multiply()
        assertEquals(new ComplexNumber(new BigDecimal("4077.856"), new BigDecimal("-2441.152")), s.pop());
    }
    
    @Test
    public void testExecute_04() {
        System.out.println("Test execute() con input=4 -> divide()");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        s.push(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("-59")));
        
        sc.execute(4); //sc.divide()
        assertEquals(new ComplexNumber(new BigDecimal("-1.161"), new BigDecimal("-0.240")), s.pop());
    }
    
    @Test
    public void testExecute_05() {
        System.out.println("Test execute() con input=5 -> changeSign()");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        s.push(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("-59")));
        
        sc.execute(5); //sc.changeSign()
        assertEquals(new ComplexNumber(new BigDecimal("23"), new BigDecimal("59")), s.pop());
    }
    
    @Test
    public void testExecute_06() {
        System.out.println("Test execute() con input=6 -> squareRoot()");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        
        sc.execute(6); //sc.squareRoot()
        assertEquals(new ComplexNumber(new BigDecimal("-6.617"), new BigDecimal("-5.591")), s.pop());
        assertEquals(new ComplexNumber(new BigDecimal("6.617"), new BigDecimal("5.591")), s.pop());
    }
    
    @Test
    public void testExecute_07() {
        System.out.println("Test execute() con input=11 -> Stack.clear()");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        s.push(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("-59")));
        
        sc.execute(11); //sc.Stack.clear()
        assertTrue(s.getStack().isEmpty());
    }
    
    @Test
    public void testExecute_08() {
        System.out.println("Test execute() con input=12 -> Stack.drop()");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        s.push(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("-59")));
        
        sc.execute(12); //sc.Stack.drop()
        assertEquals(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")), s.pop());
        assertTrue(s.getStack().isEmpty());
    }
    
    @Test
    public void testExecute_09() {
        System.out.println("Test execute() con input=13 -> Stack.swap()");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        s.push(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("-59")));
        
        sc.execute(13); //sc.Stack.swap()
        assertEquals(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")), s.pop());
    }
    
    @Test
    public void testExecute_10() {
        System.out.println("Test execute() con input=14 -> Stack.duplicate()");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        s.push(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("-59")));
        
        sc.execute(14); //sc.Stack.duplicate()
        assertEquals(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("-59")), s.pop());
        assertEquals(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("-59")), s.pop());
    }
    
    @Test
    public void testExecute_11() {
        System.out.println("Test execute() con input=15 -> Stack.over()");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        s.push(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("-59")));
        
        sc.execute(15); //sc.Stack.over()
        assertEquals(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")), s.pop());
        s.pop();
        assertEquals(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")), s.pop());
    }
    
//Test metodo executeOnVariable()
    
    @Test
    public void testExecuteOnVariable_01() {
        System.out.println("Test executeOnVariable() input = >");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        Vars v = sc.getVars();
        
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        sc.executeOnVariable('A', '>');
        assertTrue(s.getStack().isEmpty());
        assertTrue(v.getVariables().containsKey('A'));
        assertTrue(v.getVariables().containsValue(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74"))));
        
    }
    
    @Test
    public void testExecuteOnVariable_02() {
        System.out.println("Test executeOnVariable() input = <");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        Vars v = sc.getVars();
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        v.popFromStack('A');
        sc.executeOnVariable('A', '<');
        assertTrue(v.getVariables().isEmpty());
        assertEquals(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")), s.pop());
        
    }
    
    @Test
    public void testExecuteOnVariable_03() {
        System.out.println("Test executeOnVariable() input = +");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        Vars v = sc.getVars();
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        s.push(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("-59")));
        v.popFromStack('A');
        sc.executeOnVariable('A', '+');
        assertTrue(s.getStack().isEmpty());
        assertTrue(v.getVariables().containsKey('A'));
        assertTrue(v.getVariables().containsValue(new ComplexNumber(new BigDecimal("-10.472"), new BigDecimal("15"))));
    }
    
    @Test
    public void testExecuteOnVariable_04() {
        System.out.println("Test executeOnVariable() input = -");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        Vars v = sc.getVars();
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        s.push(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("-59")));
        v.popFromStack('A');
        sc.executeOnVariable('A', '-');
        assertTrue(s.getStack().isEmpty());
        assertTrue(v.getVariables().containsKey('A'));
        assertTrue(v.getVariables().containsValue(new ComplexNumber(new BigDecimal("-35.528"), new BigDecimal("-133"))));
    }

//Test metodo sum()
    
    @Test
    public void testSum_01() {
        System.out.println("Test sum() in caso di stack vuoto");
        
        ScientificCalculator sc = new ScientificCalculator();
        int test=0;
        
        try{
            sc.sum();
        } catch (InvalidOperandsException exc) {
            test=1;
        }
        assertEquals(1, test);
    }
    
    @Test
    public void testSum_02() {
        System.out.println("Test sum() in caso di stack con un solo elemento");
        
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        int test=0;
        
        try{
            sc.sum();
        } catch (InvalidOperandsException exc) {
            test=1;
        }
        assertEquals(1, test);
    }
    
    @Test
    public void testSum_03() {
        System.out.println("Test sum() in caso di corretto funzionamento");
        
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        s.push(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("-59")));
        sc.sum();
        assertEquals(new ComplexNumber(new BigDecimal("-10.472"), new BigDecimal("15")), s.pop());
    }

//Test metodo sub()
    
    @Test
    public void testSub_01() {
        System.out.println("Test sub() in caso di stack vuoto");
        
        ScientificCalculator sc = new ScientificCalculator();
        int test=0;
        
        try{
            sc.sub();
        } catch (InvalidOperandsException exc) {
            test=1;
        }
        assertEquals(1, test);
    }
    
    @Test
    public void testSub_02() {
        System.out.println("Test sub() in caso di stack con un solo elemento");
        
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        int test=0;
        
        try{
            sc.sub();
        } catch (InvalidOperandsException exc) {
            test=1;
        }
        assertEquals(1, test);
    }
    
    @Test
    public void testSub_03() {
        System.out.println("Test sub() in caso di corretto funzionamento");
        
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        s.push(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("-59")));
        sc.sub();
        assertEquals(new ComplexNumber(new BigDecimal("35.528"), new BigDecimal("133")), s.pop());
    }
    
//Test metodo multiply()
    
    @Test
    public void testMultiply_01() {
        System.out.println("Test multiply() in caso di stack vuoto");
        
        ScientificCalculator sc = new ScientificCalculator();
        int test=0;
        
        try{
            sc.multiply();
        } catch (InvalidOperandsException exc) {
            test=1;
        }
        assertEquals(1, test);
    }
    
    @Test
    public void testMultiply_02() {
        System.out.println("Test multiply() in caso di stack con un solo elemento");
        
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        int test=0;
        
        try{
            sc.multiply();
        } catch (InvalidOperandsException exc) {
            test=1;
        }
        assertEquals(1, test);
    }
    
    @Test
    public void testMultiply_03() {
        System.out.println("Test multiply() in caso di corretto funzionamento");
        
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        s.push(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("-59")));
        sc.multiply();
        assertEquals(new ComplexNumber(new BigDecimal("4077.856"), new BigDecimal("-2441.152")), s.pop());
    }

//Test metodo divide()
    
    @Test
    public void testDivide_01() {
        System.out.println("Test divide() in caso di stack vuoto");
        
        ScientificCalculator sc = new ScientificCalculator();
        int test=0;
        
        try{
            sc.divide();
        } catch (InvalidOperandsException exc) {
            test=1;
        }
        assertEquals(1, test);
    }
    
    @Test
    public void testDivide_02() {
        System.out.println("Test divide() in caso di stack con un solo elemento");
        
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        int test=0;
        
        try{
            sc.divide();
        } catch (InvalidOperandsException exc) {
            test=1;
        }
        assertEquals(1, test);
    }
    
    @Test
    public void testDivide_03() {
        System.out.println("Test divide() in caso di corretto funzionamento");
        
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
        s.push(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("-59")));
        sc.divide();
        assertEquals(new ComplexNumber(new BigDecimal("-1.161"), new BigDecimal("-0.240")), s.pop());
    }

//Test metodo squareRoot()
    
    @Test
    public void testSquareRoot_01() {
        System.out.println("Test squareRoot() in caso di stack vuoto");
        
        ScientificCalculator sc = new ScientificCalculator();
        int test=0;
        
        try{
            sc.divide();
        } catch (InvalidOperandsException exc) {
            test=1;
        }
        assertEquals(1, test);
    }
    
    @Test
    public void testSquareRoot_02() {
        System.out.println("Test divide() in caso di corretto funzionamento");
        
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
            sc.squareRoot();
        assertEquals(new ComplexNumber(new BigDecimal("-6.617"), new BigDecimal("-5.591")), s.pop());
        assertEquals(new ComplexNumber(new BigDecimal("6.617"), new BigDecimal("5.591")), s.pop());
    }

 //Test metodo ChangeSign()
    
    @Test
    public void testChangeSign_01() {
        System.out.println("Test squareRoot() in caso di stack vuoto");
        
        ScientificCalculator sc = new ScientificCalculator();
        int test=0;
        
        try{
            sc.changeSign();
        } catch (InvalidOperandsException exc) {
            test=1;
        }
        assertEquals(1, test);
    }
    
    @Test
    public void testChangeSign_02() {
        System.out.println("Test divide() in caso di corretto funzionamento");
        
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        s.push(new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74")));
            sc.changeSign();
        assertEquals(new ComplexNumber(new BigDecimal("-12.528"), new BigDecimal("-74")), s.pop());
    }

//Test metodo insertComplexNumber() -> test metodo formatComplexNumber()
    
    @Test
    public void testInsertComplexNumber_01() {
        System.out.println("Test insertComplexNumber() con input complesso decimale positivo");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        sc.insertComplexNumber("31.6238+22.729j");
        assertEquals(new ComplexNumber(new BigDecimal("31.624"), new BigDecimal("22.729")), s.pop());
    }
    
    @Test
    public void testInsertComplexNumber_02() {
        System.out.println("Test insertComplexNumber() con input complesso decimale negativo");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        sc.insertComplexNumber("-31.6238-22.729j");
        assertEquals(new ComplexNumber(new BigDecimal("-31.624"), new BigDecimal("-22.729")), s.pop());
    }
    
    @Test
    public void testInsertComplexNumber_03() {
        System.out.println("Test insertComplexNumber() con input complesso decimale discordi");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        sc.insertComplexNumber("+31.6238-22.729j");
        assertEquals(new ComplexNumber(new BigDecimal("31.624"), new BigDecimal("-22.729")), s.pop());
    }
    
    @Test
    public void testInsertComplexNumber_04() {
        System.out.println("Test insertComplexNumber() con input complesso intero negativo");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        sc.insertComplexNumber("-23-59j");
        assertEquals(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("-59")), s.pop());
    }
    
    @Test
    public void testInsertComplexNumber_05() {
        System.out.println("Test insertComplexNumber() con input complesso intero positivo");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        sc.insertComplexNumber("+23+59j");
        assertEquals(new ComplexNumber(new BigDecimal("23"), new BigDecimal("59")), s.pop());
    }
    
    @Test
    public void testInsertComplexNumber_06() {
        System.out.println("Test insertComplexNumber() con input complesso intero discordi");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        sc.insertComplexNumber("-23+59j");
        assertEquals(new ComplexNumber(new BigDecimal("-23"), new BigDecimal("59")), s.pop());
    }
    
    @Test
    public void testInsertComplexNumber_07() {
        System.out.println("Test insertComplexNumber() con input reale decimale positivo");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        sc.insertComplexNumber("23.618");
        assertEquals(new ComplexNumber(new BigDecimal("23.618"), new BigDecimal("0.000")), s.pop());
    }
    
    @Test
    public void testInsertComplexNumber_08() {
        System.out.println("Test insertComplexNumber() con input reale decimale negativo");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        sc.insertComplexNumber("-23.618");
        assertEquals(new ComplexNumber(new BigDecimal("-23.618"), new BigDecimal("0.000")), s.pop());
    }
    
    @Test
    public void testInsertComplexNumber_09() {
        System.out.println("Test insertComplexNumber() con input reale intero positivo");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        sc.insertComplexNumber("176");
        assertEquals(new ComplexNumber(new BigDecimal("176"), new BigDecimal("0.000")), s.pop());
    }
    
    @Test
    public void testInsertComplexNumber_10() {
        System.out.println("Test insertComplexNumber() con input reale intero negativo");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        sc.insertComplexNumber("-176");
        assertEquals(new ComplexNumber(new BigDecimal("-176"), new BigDecimal("0.000")), s.pop());
    }
    
    @Test
    public void testInsertComplexNumber_11() {
        System.out.println("Test insertComplexNumber() con input immaginario decimale positivo");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        sc.insertComplexNumber("23.618j");
        assertEquals(new ComplexNumber(new BigDecimal("0.000"), new BigDecimal("23.618")), s.pop());
    }
    
    @Test
    public void testInsertComplexNumber_12() {
        System.out.println("Test insertComplexNumber() con input immaginario decimale negativo");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        sc.insertComplexNumber("-23.618j");
        assertEquals(new ComplexNumber(new BigDecimal("0.000"), new BigDecimal("-23.618")), s.pop());
    }
    
    @Test
    public void testInsertComplexNumber_13() {
        System.out.println("Test insertComplexNumber() con input immaginario intero positivo");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        sc.insertComplexNumber("176j");
        assertEquals(new ComplexNumber(new BigDecimal("0.000"), new BigDecimal("176")), s.pop());
    }
    
    @Test
    public void testInsertComplexNumber_14() {
        System.out.println("Test insertComplexNumber() con input immaginario intero negativo");
        ScientificCalculator sc = new ScientificCalculator();
        Stack s = sc.getStack();
        
        sc.insertComplexNumber("-176j");
        assertEquals(new ComplexNumber(new BigDecimal("0.000"), new BigDecimal("-176")), s.pop());
    }
}