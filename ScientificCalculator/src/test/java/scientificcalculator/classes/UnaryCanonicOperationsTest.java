package scientificcalculator.classes;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class UnaryCanonicOperationsTest {
    /**
     * Test of squareRoot method, of class UnaryCanonicOperations.
     */
    @Test
    public void testSquareRoot1() {
        System.out.println("squareRoot1");
        ComplexNumber n = new ComplexNumber(new BigDecimal("2.5"),new BigDecimal("3.5"));
        ComplexNumber[] expResult = new ComplexNumber[2];
        expResult[0] = new ComplexNumber(new BigDecimal("1.844"),new BigDecimal("0.949"));
        expResult[1] = new ComplexNumber(new BigDecimal("-1.844"),new BigDecimal("-0.949"));
        ComplexNumber[] result = UnaryCanonicOperations.squareRoot(n);
        assertArrayEquals(expResult, result);
        
    }

    @Test
    public void testSquareRoot2() {
        System.out.println("squareRoot2");
        ComplexNumber n = new ComplexNumber(new BigDecimal("-4.824"),new BigDecimal("-2.32"));
        ComplexNumber[] expResult = new ComplexNumber[2];
        expResult[0] = new ComplexNumber(new BigDecimal("0.514"),new BigDecimal("-2.256"));
        expResult[1] = new ComplexNumber(new BigDecimal("-0.514"),new BigDecimal("2.256"));
        ComplexNumber[] result = UnaryCanonicOperations.squareRoot(n);
        assertArrayEquals(expResult, result);
        
    }

    @Test
    public void testSquareRoot3() {
        System.out.println("squareRoot3");
        ComplexNumber n = new ComplexNumber(new BigDecimal("0"),new BigDecimal("5.214"));
        ComplexNumber[] expResult = new ComplexNumber[2];
        expResult[0] = new ComplexNumber(new BigDecimal("1.615"),new BigDecimal("1.615"));
        expResult[1] = new ComplexNumber(new BigDecimal("-1.615"),new BigDecimal("-1.615"));
        ComplexNumber[] result = UnaryCanonicOperations.squareRoot(n);
        assertArrayEquals(expResult, result);
        
    }

    @Test
    public void testSquareRoot4() {
        System.out.println("squareRoot4");
        ComplexNumber n = new ComplexNumber(new BigDecimal("15.457"),new BigDecimal("0.000"));
        ComplexNumber[] expResult = new ComplexNumber[2];
        expResult[0] = new ComplexNumber(new BigDecimal("3.932"),new BigDecimal("0"));
        expResult[1] = new ComplexNumber(new BigDecimal("-3.932"),new BigDecimal("0"));
        ComplexNumber[] result = UnaryCanonicOperations.squareRoot(n);
        assertArrayEquals(expResult, result);
        
    }

    @Test
    public void testSquareRoot5() {
        System.out.println("squareRoot5");
        ComplexNumber n = new ComplexNumber(new BigDecimal("0.00006"),new BigDecimal("0"));
        ComplexNumber[] expResult = new ComplexNumber[2];
        expResult[0] = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        expResult[1] = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber[] result = UnaryCanonicOperations.squareRoot(n);
        assertArrayEquals(expResult, result);
        
    }
    @Test
    public void testSquareRoot6() {
        System.out.println("squareRoot6");
        ComplexNumber n = new ComplexNumber(new BigDecimal("35469.214"),new BigDecimal("-514.2416"));
        ComplexNumber[] expResult = new ComplexNumber[2];
        expResult[0] = new ComplexNumber(new BigDecimal("188.338"),new BigDecimal("-1.365"));
        expResult[1] = new ComplexNumber(new BigDecimal("-188.338"),new BigDecimal("1.365"));
        ComplexNumber[] result = UnaryCanonicOperations.squareRoot(n);
        assertArrayEquals(expResult, result);
        
    }
    
    @Test
    public void testSquareRoot7() {
        System.out.println("squareRoot7");
        ComplexNumber n = new ComplexNumber(new BigDecimal("-2145.98468"),new BigDecimal("14"));
        ComplexNumber[] expResult = new ComplexNumber[2];
        expResult[0] = new ComplexNumber(new BigDecimal("0.151"),new BigDecimal("46.325"));
        expResult[1] = new ComplexNumber(new BigDecimal("-0.151"),new BigDecimal("-46.325"));
        ComplexNumber[] result = UnaryCanonicOperations.squareRoot(n);
        assertArrayEquals(expResult, result);
        
    }
    
    /**
     * Test of changeSign method, of class UnaryCanonicOperations.
     */
    @Test
    public void testChangeSign1() {
        System.out.println("changeSign1");
        
        ComplexNumber n = new ComplexNumber(new BigDecimal("31.6238"),new BigDecimal("22.729"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-31.6238"),new BigDecimal("-22.729"));
        ComplexNumber result = UnaryCanonicOperations.changeSign(n);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testChangeSign2() {
        System.out.println("changeSign2");
        
        ComplexNumber n = new ComplexNumber(new BigDecimal("-12.528"),new BigDecimal("-74"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("12.528"),new BigDecimal("74"));
        ComplexNumber result = UnaryCanonicOperations.changeSign(n);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testChangeSign3() {
        System.out.println("changeSign3");
        
        ComplexNumber n = new ComplexNumber(new BigDecimal("23"),new BigDecimal("-13.729"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-23"),new BigDecimal("13.729"));
        ComplexNumber result = UnaryCanonicOperations.changeSign(n);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testChangeSign4() {
        System.out.println("changeSign4");
        
        ComplexNumber n = new ComplexNumber(new BigDecimal("-12.528"),new BigDecimal("74"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("12.528"),new BigDecimal("-74"));
        ComplexNumber result = UnaryCanonicOperations.changeSign(n);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testChangeSign5() {
        System.out.println("changeSign5");
        
        ComplexNumber n = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-176"),new BigDecimal("0"));
        ComplexNumber result = UnaryCanonicOperations.changeSign(n);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testChangeSign6() {
        System.out.println("changeSign6");
        
        ComplexNumber n = new ComplexNumber(new BigDecimal("-176"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber result = UnaryCanonicOperations.changeSign(n);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testChangeSign7() {
        System.out.println("changeSign7");
        
        ComplexNumber n = new ComplexNumber(new BigDecimal("0"),new BigDecimal("23.618"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0"),new BigDecimal("-23.618"));
        ComplexNumber result = UnaryCanonicOperations.changeSign(n);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testChangeSign8() {
        System.out.println("changeSign8");
        
        ComplexNumber n = new ComplexNumber(new BigDecimal("0"),new BigDecimal("-23.618"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0"),new BigDecimal("23.618"));
        ComplexNumber result = UnaryCanonicOperations.changeSign(n);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testChangeSign9() {
        System.out.println("changeSign9");
        
        ComplexNumber n = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber result = UnaryCanonicOperations.changeSign(n);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testChangeSign10() {
        System.out.println("changeSign10");
        
        ComplexNumber n = new ComplexNumber(new BigDecimal("1111111111111111111111111111"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-1111111111111111111111111111"),new BigDecimal("0"));
        ComplexNumber result = UnaryCanonicOperations.changeSign(n);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testChangeSign11() {
        System.out.println("changeSign11");
        
        ComplexNumber n = new ComplexNumber(new BigDecimal("0"),new BigDecimal("2.1584926487859"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0"),new BigDecimal("-2.1584926487859"));
        ComplexNumber result = UnaryCanonicOperations.changeSign(n);
        assertEquals(expResult, result);
    }
    
    
    
}
