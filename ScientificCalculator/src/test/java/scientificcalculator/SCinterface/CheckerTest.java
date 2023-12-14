package scientificcalculator.SCinterface;

import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import scientificcalculator.classes.ComplexNumber;
import scientificcalculator.classes.Stack;
import scientificcalculator.classes.*;
import scientificcalculator.exceptions.InvalidInputException;

public class CheckerTest {

    Vars var;
    Stack s;

    @BeforeEach
    public void setUp() {
        s = new Stack();
        var = new Vars(s);
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of checkInput method, of class Checker.
     */
    @Test
    public void testIsANumber1() {
        System.out.println("isANumber1");
        String input = "31.6238+22.729j";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber2() {
        System.out.println("isANumber2");
        String input = "23+59j";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber3() {
        System.out.println("isANumber3");
        String input = "-31.6238-22j";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber4() {
        System.out.println("isANumber4");
        String input = "-12.528+74j";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber5() {
        System.out.println("isANumber5");
        String input = "9-13.729j";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber6() {
        System.out.println("isANumber6");
        String input = "-31.6238+22j";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber7() {
        System.out.println("isANumber7");
        String input = "176";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber8() {
        System.out.println("isANumber8");
        String input = "-176";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber9() {
        System.out.println("isANumber9");
        String input = "23.816";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber10() {
        System.out.println("isANumber10");
        String input = "-23.816215";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber11() {
        System.out.println("isANumber11");
        String input = "176j";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber12() {
        System.out.println("isANumber12");
        String input = "-176j";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber13() {
        System.out.println("isANumber13");
        String input = "23.816j";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber14() {
        System.out.println("isANumber14");
        String input = "-23.816215j";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber15() {
        System.out.println("isANumber15");
        String input = "0";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber16() {
        System.out.println("isANumber16");
        String input = "0j";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber17() {
        System.out.println("isANumber17");
        String input = "-0j";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber18() {
        System.out.println("isANumber18");
        String input = "1j";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber19() {
        System.out.println("isANumber19");
        String input = "-1j";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber20() {
        System.out.println("isANumber20");
        String input = "0.0+0.0j";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber21() {
        System.out.println("isANumber21");
        String input = "11111111111111111111111111111111111111111111111111";
        boolean expResult = true;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber22() {
        System.out.println("isANumber22");
        String input = "-";
        boolean expResult = false;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber23() {
        System.out.println("isANumber23");
        String input = "DUP";
        boolean expResult = false;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber24() {
        System.out.println("isANumber24");
        String input = "DUP";
        boolean expResult = false;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber25() {
        System.out.println("isANumber25");
        String input = "OVR";
        boolean expResult = false;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber26() {
        System.out.println("isANumber26");
        String input = "ciao";
        boolean expResult = false;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber27() {
        System.out.println("isANumber27");
        String input = "test27j";
        boolean expResult = false;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber28() {
        System.out.println("isANumber28");
        String input = "23 + 52j";
        boolean expResult = false;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber29() {
        System.out.println("isANumber29");
        String input = "253.265 - 251j";
        boolean expResult = false;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsANumber30() {
        System.out.println("isANumber30");
        String input = "+";
        boolean expResult = false;
        boolean result = Checker.isANumber(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckOperation1() {
        System.out.println("checkOperation1");
        String input = "+";
        int expResult = 1;
        int result = Checker.checkOperation(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckOperation2() {
        System.out.println("checkOperation2");
        String input = "-";
        int expResult = 2;
        int result = Checker.checkOperation(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckOperation3() {
        System.out.println("checkOperation3");
        String input = "×";
        int expResult = 3;
        int result = Checker.checkOperation(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckOperation4() {
        System.out.println("checkOperation4");
        String input = "÷";
        int expResult = 4;
        int result = Checker.checkOperation(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckOperation5() {
        System.out.println("checkOperation5");
        String input = "±";
        int expResult = 5;
        int result = Checker.checkOperation(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckOperation6() {
        System.out.println("checkOperation6");
        String input = "√";
        int expResult = 6;
        int result = Checker.checkOperation(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckOperation7() {
        System.out.println("checkOperation7");
        String input = "CLR";
        int expResult = 11;
        int result = Checker.checkOperation(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckOperation8() {
        System.out.println("checkOperation8");
        String input = "DRP";
        int expResult = 12;
        int result = Checker.checkOperation(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckOperation9() {
        System.out.println("checkOperation9");
        String input = "SWP";
        int expResult = 13;
        int result = Checker.checkOperation(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckOperation10() {
        System.out.println("checkOperation10");
        String input = "DUP";
        int expResult = 14;
        int result = Checker.checkOperation(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckOperation11() {
        System.out.println("checkOperation11");
        String input = "OVR";
        int expResult = 15;
        int result = Checker.checkOperation(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckOperation12() {
        System.out.println("checkOperation12");
        String input = "più";
        int expResult = -1;
        int result = Checker.checkOperation(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckOperation13() {
        System.out.println("checkOperation13");
        String input = "2+3j";
        int expResult = -1;
        int result = Checker.checkOperation(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckInput1() {
        System.out.println("checkInput1");
        String input = "22.2541-3.1452j";
        boolean thrown = false;
        try {
            Checker.checkInput(input);
        } catch (InvalidInputException ex) {
            thrown = true;
        }

        assertEquals(false, thrown);
    }

    @Test
    public void testCheckInput2() {
        System.out.println("checkInput2");
        String input = "OVR";
        boolean thrown = false;
        try {
            Checker.checkInput(input);
        } catch (InvalidInputException ex) {
            thrown = true;
        }

        assertEquals(false, thrown);
    }

    @Test
    public void testCheckInput3() {
        System.out.println("checkInput3");
        String input = "test input errato";
        boolean thrown = false;
        try {
            Checker.checkInput(input);
        } catch (InvalidInputException ex) {
            thrown = true;
        }

        assertEquals(true, thrown);
    }

    @Test
    public void testCheckInput4() {
        System.out.println("checkInput4");
        String input = " + +j";
        boolean thrown = false;
        try {
            Checker.checkInput(input);
        } catch (InvalidInputException ex) {
            thrown = true;
        }

        assertEquals(true, thrown);
    }

    /**
     * Test of isInitialized method, of class Checker.
     */
    @Test
    public void testIsInitialized1() {

        System.out.println("isInitialized1");
        s.push(new ComplexNumber(new BigDecimal("3"), new BigDecimal("8")));
        var.popFromStack('A');
        Character variable = 'A';
        boolean expResult = true;
        boolean result = Checker.isInitialized(var, variable);
        assertEquals(expResult, result);

    }

    @Test
    public void testIsInitialized2() {

        System.out.println("isInitialized2");

        Character variable = 'A';
        boolean expResult = false;
        boolean result = Checker.isInitialized(var, variable);
        assertEquals(expResult, result);

    }

    @Test
    public void testIsInitialized3() {

        System.out.println("isInitialized3");
        var.getVariables().put('A', null);
        Character variable = 'A';
        boolean expResult = false;
        boolean result = Checker.isInitialized(var, variable);
        assertEquals(expResult, result);

    }

}
