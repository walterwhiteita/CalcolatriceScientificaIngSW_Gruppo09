package scientificcalculator.classes;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import scientificcalculator.exceptions.InvalidOperandsException;

public class StackTest {
   
    @Test
    public void testGetStack_00() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getStack 00");
        Stack instance = new Stack();
        Field field = instance.getClass().getDeclaredField("stack");
        field.setAccessible(true);
        Deque<ComplexNumber> testGet = new LinkedList<>();
        field.set(instance, testGet);
        Deque<ComplexNumber> result = instance.getStack();
        assertEquals(testGet, result);       
    }
    
    @Test
    public void testPush_01() {
        System.out.println("push 01");
        ComplexNumber input = new ComplexNumber(new BigDecimal(-12.5284),new BigDecimal(-74.5269));
        Stack instance = new Stack();
        instance.push(input);
        assertEquals(input,instance.getStack().getFirst());
        
    }
    @Test
    public void testPush_02() {
        System.out.println("push 02");
        ComplexNumber input = new ComplexNumber(new BigDecimal(31.6238),new BigDecimal(-22.729));
        Stack instance = new Stack();
        instance.push(input);
        assertEquals(input,instance.getStack().getFirst());
        
    }   
    @Test
    public void testPush_03() {
        System.out.println("push 03");
        ComplexNumber input = new ComplexNumber(new BigDecimal(-12.5284),new BigDecimal(74.5269));
        Stack instance = new Stack();
        instance.push(input);
        assertEquals(input,instance.getStack().getFirst());
        
    }
    
    @Test
    public void testPush_04() {
        System.out.println("push 04");
        ComplexNumber input = new ComplexNumber(new BigDecimal(176),new BigDecimal(0));
        Stack instance = new Stack();
        instance.push(input);
        assertEquals(input,instance.getStack().getFirst());
        
    }
    
    @Test
    public void testPush_05() {
        System.out.println("push 05");
        ComplexNumber input = new ComplexNumber(new BigDecimal(-176),new BigDecimal(0));
        Stack instance = new Stack();
        instance.push(input);
        assertEquals(input,instance.getStack().getFirst());
        
    }
    @Test
    public void testPush_06() {
        System.out.println("push 06");
        ComplexNumber input = new ComplexNumber(new BigDecimal(23.6189),new BigDecimal(0));
        Stack instance = new Stack();
        instance.push(input);
        assertEquals(input,instance.getStack().getFirst());
        
    }
    
    @Test
    public void testPush_07() {
        System.out.println("push 07");
        ComplexNumber input = new ComplexNumber(new BigDecimal(-23.6189),new BigDecimal(0));
        Stack instance = new Stack();
        instance.push(input);
        assertEquals(input,instance.getStack().getFirst());
        
    }
    
    @Test
    public void testPush_08() {
        System.out.println("push 08");
        ComplexNumber input = new ComplexNumber(new BigDecimal(0),new BigDecimal(176));
        Stack instance = new Stack();
        instance.push(input);
        assertEquals(input,instance.getStack().getFirst());
        
    }
    
    @Test
    public void testPush_09() {
        System.out.println("push 09");
        ComplexNumber input = new ComplexNumber(new BigDecimal(0),new BigDecimal(-176));
        Stack instance = new Stack();
        instance.push(input);
        assertEquals(input,instance.getStack().getFirst());
        
    }
    @Test
    public void testPush_10() {
        System.out.println("push 10");
        ComplexNumber input = new ComplexNumber(new BigDecimal(0),new BigDecimal(23.6189));
        Stack instance = new Stack();
        instance.push(input);
        assertEquals(input,instance.getStack().getFirst());
        
    }
    
    @Test
    public void testPush_11() {
        System.out.println("push 11");
        ComplexNumber input = new ComplexNumber(new BigDecimal(0),new BigDecimal(-23.6189));
        Stack instance = new Stack();
        instance.push(input);
        assertEquals(input,instance.getStack().getFirst());
        
    }
    @Test
    public void testPush_12() {
        System.out.println("push 12");
        ComplexNumber input = new ComplexNumber(new BigDecimal("1111111111111111"),new BigDecimal(0));
        Stack instance = new Stack();
        instance.push(input);
        assertEquals(input,instance.getStack().getFirst());        
    }
    
    @Test
    public void testPush_13() {
        System.out.println("push 13");
        ComplexNumber input = new ComplexNumber(new BigDecimal("2.1584926487859"),new BigDecimal(0));
        Stack instance = new Stack();
        instance.push(input);
        assertEquals(input,instance.getStack().getFirst());
        
    }
    @Test
    public void testPush_14() {
        System.out.println("push 14");
        ComplexNumber input = new ComplexNumber(new BigDecimal(0),new BigDecimal(-1));
        Stack instance = new Stack();
        instance.push(input);
        assertEquals(input,instance.getStack().getFirst());
        
    }
    
    @Test
    public void testPush_15() {
        System.out.println("push 15");
        ComplexNumber input = new ComplexNumber(new BigDecimal(0.0),new BigDecimal(0.0));
        Stack instance = new Stack();
        instance.push(input);
        assertEquals(input,instance.getStack().getFirst());
        
    }
    @Test
    public void testPop_00() {
        System.out.println("pop 00");
        Stack instance = new Stack();
        ComplexNumber expResult = new ComplexNumber(new BigDecimal(31.6238),new BigDecimal(22.729));
        instance.push(expResult);
        ComplexNumber result = instance.pop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    @Test
    public void testPop_01() {
        System.out.println("pop 01");
        Stack instance = new Stack();
        ComplexNumber expResult1 = new ComplexNumber(new BigDecimal(31.6238),new BigDecimal(22.729));
        instance.push(expResult1);
        ComplexNumber expResult2 = new ComplexNumber(new BigDecimal(-12.5284),new BigDecimal(74.5269));
        instance.push(expResult2);
        ComplexNumber result2 = instance.pop();
        ComplexNumber result1 = instance.pop();
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);        
    }
    @Test
    public void testPop_02() {
        System.out.println("pop 02");
        boolean thrown = false;
        Stack instance = new Stack();
        try{
            ComplexNumber result = instance.pop();
        }catch(InvalidOperandsException ex){
            thrown = true;
        }
        assertTrue(thrown);       
    }

    @Test
    public void testTop_00() {
        System.out.println("top 00");
        Stack instance = new Stack();
        ComplexNumber expResult = new ComplexNumber(new BigDecimal(31.6238),new BigDecimal(22.729));
        instance.push(expResult);
        ComplexNumber result = instance.top();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testTop_01() {
        System.out.println("top 01");
        boolean thrown = false;
        Stack instance = new Stack();
        try{
            ComplexNumber result = instance.top();
        }catch(InvalidOperandsException ex){
            thrown = true;
        }
        assertTrue(thrown);   
    }
    @Test
    public void testClear() {
        System.out.println("clear");
        Stack instance = new Stack();
        ComplexNumber n1 = new ComplexNumber(new BigDecimal(31.6238),new BigDecimal(22.729));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal(-12.5284),new BigDecimal(74.5269));
        instance.push(n1);
        instance.push(n2);
        instance.clear();
        assertTrue(instance.getStack().isEmpty());
    }
    
    @Test
    public void testDrop_00() {
        System.out.println("drop 00");
        boolean thrown = false;
        Stack instance = new Stack();
        try{
            instance.drop();
        }catch(InvalidOperandsException ex){
            thrown = true;
        }    
        assertTrue(thrown);
    }
    @Test
    public void testDrop_01() {
        System.out.println("drop 01");
        Stack instance = new Stack();
        ComplexNumber n1 = new ComplexNumber(new BigDecimal(31.6238),new BigDecimal(22.729));
        instance.push(n1);
        instance.drop();
        assertTrue(instance.getStack().isEmpty());
    }
    @Test
    public void testDrop_02() {
        System.out.println("drop 02");
        int before;
        Stack instance = new Stack();
        ComplexNumber n1 = new ComplexNumber(new BigDecimal(31.6238),new BigDecimal(22.729));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal(-12.5284),new BigDecimal(74.5269));
        instance.push(n1);
        instance.push(n2);
        before = instance.getStack().size();
        instance.drop();
        before -=1;
        assertEquals(before,instance.getStack().size());
    }
    
    @Test
    public void testSwap_00() {
        System.out.println("swap 00");
        boolean thrown = false;
        Stack instance = new Stack();
        try{
            instance.swap();
        }catch(InvalidOperandsException ex){
            thrown = true;
        }
        assertTrue(thrown);
    }
    @Test
    public void testSwap_01() {
        System.out.println("swap 01");
        boolean thrown = false;
        Stack instance = new Stack();
        ComplexNumber n1 = new ComplexNumber(new BigDecimal(31.6238),new BigDecimal(22.729));
        instance.push(n1);
        try{
            instance.swap();
        }catch(InvalidOperandsException ex){
            thrown = true;
        }
        assertTrue(thrown);
    }   
    @Test
    public void testSwap_02() {
        System.out.println("swap 02");
        Stack instance = new Stack();
        ComplexNumber n1 = new ComplexNumber(new BigDecimal(31.6238),new BigDecimal(22.729));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal(-12.5284),new BigDecimal(74.5269));
        instance.push(n1);
        instance.push(n2);
        instance.swap();
        assertEquals(n1,instance.pop());
        assertEquals(n2,instance.pop());
    }
    @Test
    public void testDuplicate_00() {
        System.out.println("duplicate 00");
        boolean thrown = false;
        Stack instance = new Stack();
        try{
            instance.duplicate();
        }catch(InvalidOperandsException ex){
            thrown = true;
        }
        assertTrue(thrown);
    }
    @Test
    public void testDuplicate_01() {
        System.out.println("duplicate 01");
        Stack instance = new Stack();
        ComplexNumber n1 = new ComplexNumber(new BigDecimal(31.6238),new BigDecimal(22.729));
        instance.push(n1);
        instance.duplicate();
        assertEquals(n1,instance.pop());
        assertEquals(n1,instance.pop());
    }
    @Test
    public void testOver_00() {
        System.out.println("over 00");
        boolean thrown = false;
        Stack instance = new Stack();
        try{
            instance.over();
        }catch(InvalidOperandsException ex){
            thrown = true;
        }
        assertTrue(thrown);
    }
    @Test
    public void testOver_01() {
        System.out.println("over 01");
        boolean thrown = false;
        Stack instance = new Stack();
        ComplexNumber n1 = new ComplexNumber(new BigDecimal(31.6238),new BigDecimal(22.729));
        instance.push(n1);
        try{
            instance.over();
        }catch(InvalidOperandsException ex){
            thrown = true;
        }
        assertTrue(thrown);
    }
    @Test
    public void testOver_02() {
        System.out.println("over 02");
        Stack instance = new Stack();
        ComplexNumber n1 = new ComplexNumber(new BigDecimal(31.6238),new BigDecimal(22.729));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal(-12.5284),new BigDecimal(74.5269));
        instance.push(n1);
        instance.push(n2);
        instance.over();
        assertEquals(n1,instance.pop());
        assertEquals(n2,instance.pop());
        assertEquals(n1,instance.pop());
    }
}
