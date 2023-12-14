package scientificcalculator.classes;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import scientificcalculator.exceptions.InvalidOperandsException;
import scientificcalculator.exceptions.UninitializedVariableException;

public class VarsTest {
    /**
     * Test of getStack method, of class Vars.
     */
    @Test
    public void testGetStack() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getStack");
        Stack expResult = new Stack();
        Vars instance = new Vars(expResult);
        Field field = instance.getClass().getDeclaredField("stack");
        field.setAccessible(true);
        field.set(instance, expResult);
        Stack result = instance.getStack();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getVariables method, of class Vars.
     */
    @Test
    public void testGetVariables() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getVariables");
        Stack s = new Stack();
        Vars instance = new Vars(s);
        Map<Character, ComplexNumber> expResult = new HashMap<>();
        Field field = instance.getClass().getDeclaredField("variables");
        field.setAccessible(true);
        field.set(instance,expResult);
        Map<Character, ComplexNumber> result = instance.getVariables();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getValueOf method, of class Vars.
     */
    @Test
    public void testGetValueOf() {
        System.out.println("getValueOf");
        Character variable = 'A';
        Stack s = new Stack();
        Vars instance = new Vars(s);
        ComplexNumber expResult = new ComplexNumber(new BigDecimal(-1.5),new BigDecimal(2.3));
        instance.getVariables().put(variable, expResult);
        ComplexNumber result = instance.getValueOf(variable);
        assertEquals(expResult, result);
    }

    /**
     * Test of setValueOf method, of class Vars.
     */
    @Test
    public void testSetValueOf() {
        System.out.println("setValueOf");
        Character variable = 'A';
        ComplexNumber n = new ComplexNumber(new BigDecimal(-1.5),new BigDecimal(2.3));
        Vars instance = new Vars(new Stack());
        instance.setValueOf(variable, n);
        assertEquals(n,instance.getValueOf(variable));
    }
    
    /**
     * Test of popFromStack method, of class Vars.
     */
    @Test
    public void testPopFromStack1() {
        System.out.println("popFromStack 1");
        Character variable = 'A';
        Stack s = new Stack();
        Vars instance = new Vars(s);
        ComplexNumber n = new ComplexNumber(new BigDecimal(-1.5),new BigDecimal(2.3));
        s.push(n);
        instance.popFromStack(variable);
        assertEquals(n,instance.getValueOf(variable));
    }
    
    @Test
    public void testPopFromStack2() {
        System.out.println("popFromStack 2");
        boolean thrown = false;
        Character variable = 'A';
        Vars instance = new Vars(new Stack());
        try{
            instance.popFromStack(variable);        
        }catch(InvalidOperandsException ex){
            thrown = true;
        }
        assertTrue(thrown);
    }

    /**
     * Test of pushInStack method, of class Vars.
     */
    @Test
    public void testPushInStack1() {
        System.out.println("pushInStack 1");
        Character variable = 'A';
        ComplexNumber n = new ComplexNumber(new BigDecimal(-1.5),new BigDecimal(2.3));
        Stack s = new Stack();
        Vars instance = new Vars(s);
        instance.setValueOf(variable, n);
        instance.pushInStack(variable);
        assertEquals(n, s.pop());
        assertTrue(instance.getVariables().isEmpty());
    }

    @Test
    public void testPushInStack2() {
        System.out.println("pushInStack 2");
        Character variable = 'A';
        ComplexNumber n = new ComplexNumber(new BigDecimal(-1.5),new BigDecimal(2.3));
        Stack s = new Stack();
        Vars instance = new Vars(s);
        instance.setValueOf(variable, n);
        variable = 'B';
        n = new ComplexNumber(new BigDecimal(2.5),new BigDecimal(4.3));
        instance.setValueOf(variable, n);
        int before = instance.getVariables().size();
        instance.pushInStack(variable);
        assertEquals(n, s.pop());
        assertEquals((before -1),instance.getVariables().size());
        
    }

    @Test
    public void testPushInStack3() {
        System.out.println("pushInStack 3");
        boolean thrown = false;
        Character variable = 'A';
        Vars instance = new Vars(new Stack());
        try{
            instance.pushInStack(variable);
        }catch(UninitializedVariableException ex){
            thrown = true;
        }
        assertTrue(thrown);
    }
    /**
     * Test of sumFromStack method, of class Vars.
     */
    @Test
    public void testSumFromStack1() {
        System.out.println("sumFromStack 1");
        boolean thrownStack = false;
        boolean thrownVars = false;
        Character variable = 'A';
        Stack s = new Stack();
        Vars instance = new Vars(s);
        ComplexNumber n1 = new ComplexNumber(new BigDecimal(-1.5),new BigDecimal(2.3));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal(2.5),new BigDecimal(-4.6));
        instance.setValueOf(variable, n1);
        s.push(n2);
        int before = s.getStack().size();
        try{
            instance.sumFromStack(variable);
        }catch(UninitializedVariableException ex){
            thrownVars = true;
        }catch(InvalidOperandsException ex){
            thrownStack = true;
        }
        assertFalse(thrownVars);
        assertFalse(thrownStack);
        assertEquals(BinaryCanonicOperations.sum(n1,n2),instance.getValueOf(variable));
        assertEquals((before - 1),s.getStack().size());
    }
    @Test
    public void testSumFromStack2() {
        System.out.println("sumFromStack 2");
        boolean thrownStack = false;
        boolean thrownVars = false;
        Character variable = 'A';
        Stack s = new Stack();
        Vars instance = new Vars(s);
        ComplexNumber n = new ComplexNumber(new BigDecimal(-1.5),new BigDecimal(2.3));
        instance.setValueOf(variable,n);
        int stackSize = s.getStack().size();
        ComplexNumber before = instance.getValueOf(variable);
        try{
            instance.sumFromStack(variable);
        }catch(UninitializedVariableException ex){
            thrownVars = true;
        }catch(InvalidOperandsException ex){
            thrownStack = true;
        }
        assertFalse(thrownVars);
        assertTrue(thrownStack);
        assertEquals(before,instance.getValueOf(variable));
        assertEquals(stackSize,s.getStack().size());
    }
    
    @Test
    public void testSumFromStack3() {
        System.out.println("sumFromStack 3");
        boolean thrownStack = false;
        boolean thrownVars = false;
        Character variable = 'A';
        Stack s = new Stack();
        Vars instance = new Vars(s);
        ComplexNumber n = new ComplexNumber(new BigDecimal(-1.5),new BigDecimal(2.3));
        s.push(n);
        int stackSize = s.getStack().size();
        ComplexNumber before = instance.getValueOf(variable);
        try{
            instance.sumFromStack(variable);
        }catch(UninitializedVariableException ex){
            thrownVars = true;
        }catch(InvalidOperandsException ex){
            thrownStack = true;
        }
        assertTrue(thrownVars);
        assertFalse(thrownStack);
        assertEquals(before,instance.getValueOf(variable));
        assertEquals(stackSize,s.getStack().size());
    }
    
    @Test
    public void testSumFromStack4() {
        System.out.println("sumFromStack 4");
        boolean thrownStack = false;
        boolean thrownVars = false;
        Character variable = 'A';
        Stack s = new Stack();
        Vars instance = new Vars(s);
        int stackSize = s.getStack().size();
        ComplexNumber before = instance.getValueOf(variable);
        try{
            instance.sumFromStack(variable);
        }catch(UninitializedVariableException ex){
            thrownVars = true;
        }catch(InvalidOperandsException ex){
            thrownStack = true;
        }
        assertTrue(thrownVars);
        assertFalse(thrownStack);
        assertEquals(before,instance.getValueOf(variable));
        assertEquals(stackSize,s.getStack().size());
    }

    /**
     * Test of subFromStack method, of class Vars.
     */
    @Test
    public void testSubFromStack1() {
        System.out.println("subFromStack 1");
        boolean thrownStack = false;
        boolean thrownVars = false;
        Character variable = 'A';
        Stack s = new Stack();
        Vars instance = new Vars(s);
        ComplexNumber n1 = new ComplexNumber(new BigDecimal(-1.5),new BigDecimal(2.3));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal(2.5),new BigDecimal(-4.6));
        instance.setValueOf(variable, n1);
        s.push(n2);
        int before = s.getStack().size();
        try{
            instance.subFromStack(variable);
        }catch(UninitializedVariableException ex){
            thrownVars = true;
        }catch(InvalidOperandsException ex){
            thrownStack = true;
        }
        assertFalse(thrownVars);
        assertFalse(thrownStack);
        assertEquals(BinaryCanonicOperations.sub(n1,n2),instance.getValueOf(variable));
        assertEquals((before - 1),s.getStack().size());
    }
    @Test
    public void testSubFromStack2() {
        System.out.println("subFromStack 2");
        boolean thrownStack = false;
        boolean thrownVars = false;
        Character variable = 'A';
        Stack s = new Stack();
        Vars instance = new Vars(s);
        ComplexNumber n = new ComplexNumber(new BigDecimal(-1.5),new BigDecimal(2.3));
        instance.setValueOf(variable,n);
        int stackSize = s.getStack().size();
        ComplexNumber before = instance.getValueOf(variable);
        try{
            instance.subFromStack(variable);
        }catch(UninitializedVariableException ex){
            thrownVars = true;
        }catch(InvalidOperandsException ex){
            thrownStack = true;
        }
        assertFalse(thrownVars);
        assertTrue(thrownStack);
        assertEquals(before,instance.getValueOf(variable));
        assertEquals(stackSize,s.getStack().size());
    }
    
    @Test
    public void testSubFromStack3() {
        System.out.println("subFromStack 3");
        boolean thrownStack = false;
        boolean thrownVars = false;
        Character variable = 'A';
        Stack s = new Stack();
        Vars instance = new Vars(s);
        ComplexNumber n = new ComplexNumber(new BigDecimal(-1.5),new BigDecimal(2.3));
        s.push(n);
        int stackSize = s.getStack().size();
        ComplexNumber before = instance.getValueOf(variable);
        try{
            instance.subFromStack(variable);
        }catch(UninitializedVariableException ex){
            thrownVars = true;
        }catch(InvalidOperandsException ex){
            thrownStack = true;
        }
        assertTrue(thrownVars);
        assertFalse(thrownStack);
        assertEquals(before,instance.getValueOf(variable));
        assertEquals(stackSize,s.getStack().size());
    }
    
    @Test
    public void testSubFromStack4() {
        System.out.println("subsFromStack 4");
        boolean thrownStack = false;
        boolean thrownVars = false;
        Character variable = 'A';
        Stack s = new Stack();
        Vars instance = new Vars(s);
        int stackSize = s.getStack().size();
        ComplexNumber before = instance.getValueOf(variable);
        try{
            instance.subFromStack(variable);
        }catch(UninitializedVariableException ex){
            thrownVars = true;
        }catch(InvalidOperandsException ex){
            thrownStack = true;
        }
        assertTrue(thrownVars);
        assertFalse(thrownStack);
        assertEquals(before,instance.getValueOf(variable));
        assertEquals(stackSize,s.getStack().size());
    }
    
    /**
     * Test of toStringArrayList method, of class Vars.
     */
    @Test
    public void testToStringArrayList1() {
        System.out.println("toStringArrayList 1");
        Vars instance = new Vars(new Stack());
        ArrayList<String> expResult = new ArrayList();
        ArrayList<String> result = instance.toStringArrayList();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToStringArrayList2() {
        System.out.println("toStringArrayList 2");
        Vars instance = new Vars(new Stack());
        Character variable = 'A';
        ComplexNumber n = new ComplexNumber(new BigDecimal(-1.5),new BigDecimal(2.3));
        ArrayList<String> expResult = new ArrayList();
        String e = variable + " = " + n.toString();
        expResult.add(e);
        expResult.sort(null);
        instance.setValueOf(variable, n);
        ArrayList<String> result = instance.toStringArrayList();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToStringArrayList3() {
        System.out.println("toStringArrayList 3");
        Vars instance = new Vars(new Stack());
        ArrayList<String> expResult = new ArrayList();
        Character variable = 'D';
        ComplexNumber n = new ComplexNumber(new BigDecimal(-1.5),new BigDecimal(2.3));
        instance.setValueOf(variable, n);
        String e = variable + " = " + n.toString();
        expResult.add(e);
        variable = 'A';
        n = new ComplexNumber(new BigDecimal(8.985),new BigDecimal(-23.4582));
        instance.setValueOf(variable, n);
        e = variable + " = " + n.toString();
        expResult.add(e);
        expResult.sort(null);
        ArrayList<String> result = instance.toStringArrayList();
        assertEquals(expResult, result);
    }
}