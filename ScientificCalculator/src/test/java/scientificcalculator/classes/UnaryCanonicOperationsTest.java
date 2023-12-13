package scientificcalculator.classes;

import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Gianmarco Uni
 */
public class UnaryCanonicOperationsTest {
    
    public UnaryCanonicOperationsTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of squareRoot method, of class UnaryCanonicOperations.
     */
    /*@Test
    public void testSquareRoot() {
        System.out.println("squareRoot");
        ComplexNumber n = null;
        ComplexNumber[] expResult = null;
        ComplexNumber[] result = UnaryCanonicOperations.squareRoot(n);
        assertArrayEquals(expResult, result);
        
    }*/

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
