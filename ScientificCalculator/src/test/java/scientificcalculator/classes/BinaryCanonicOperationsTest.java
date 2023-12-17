
package scientificcalculator.classes;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryCanonicOperationsTest {
    
    @Test
    public void testSum1() {
        System.out.println("sum1");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("54.624"),new BigDecimal("81.729"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test 
    public void testSum2() {
        System.out.println("sum2");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("-13.729"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("22.624"),new BigDecimal("9"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum3() {
        System.out.println("sum3");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("-22.729"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("63.248"),new BigDecimal("0"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSum4() {
        System.out.println("sum4");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("207.624"),new BigDecimal("22.729"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum5() {
        System.out.println("sum5");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("-23.618"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("-0.889"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum6() {
        System.out.println("sum6");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum7() {
        System.out.println("sum7");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("111111111111111111"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("111111111111111142.624"),new BigDecimal("22.729"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum8() {
        System.out.println("sum8");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("-59"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("46"),new BigDecimal("0"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum9() {
        System.out.println("sum9");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("176"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("176"),new BigDecimal("176"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum10() {
        System.out.println("sum10");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of sub method, of class BinaryCanonicOperations.
     */
    @Test
    public void testSub1() {
        System.out.println("sub1");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("8.624"),new BigDecimal("-36.271"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub2() {
        System.out.println("sub2");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("-13.729"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("40.624"),new BigDecimal("36.458"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub3() {
        System.out.println("sub3");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("-22.729"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0"),new BigDecimal("45.458"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub4() {
        System.out.println("sub4");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-144.376"),new BigDecimal("22.729"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub5() {
        System.out.println("sub5");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("-23.618"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("46.347"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub6() {
        System.out.println("sub6");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub7() {
        System.out.println("sub7");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("111111111111111111"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-111111111111111079.376"),new BigDecimal("22.729"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSub8() {
        System.out.println("sub8");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("-59"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0"),new BigDecimal("118"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testSub9() {
        System.out.println("sub9");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("176"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("176"),new BigDecimal("-176"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSub10() {
        System.out.println("sub10");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    
    

    /**
     * Test of multiply method, of class BinaryCanonicOperations.
     */
    @Test
    public void testMultiply1() {
        System.out.println("multiply1");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-613.659"),new BigDecimal("2388.583"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testMultiply2() {
        System.out.println("multiply2");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("-13.729"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("27.430"),new BigDecimal("-638.727"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testMultiply3() {
        System.out.println("multiply3");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("-22.729"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("1516.685"),new BigDecimal("0"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testMultiply4() {
        System.out.println("multiply4");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("5565.824"),new BigDecimal("4000.304"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testMultiply5() {
        System.out.println("multiply5");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("-23.618"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("536.814"),new BigDecimal("-746.896"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testMultiply6() {
        System.out.println("multiply6");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testMultiply7() {
        System.out.println("multiply7");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("-59"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("4010"),new BigDecimal("0"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testMultiply8() {
        System.out.println("multiply8");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("176"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0"),new BigDecimal("30976"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMultiply9() {
        System.out.println("multiply9");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }

    /**
     * Test of divide method, of class BinaryCanonicOperations.
     */
    @Test
    public void testDivide1() {
        System.out.println("divide1");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0.516"),new BigDecimal("-0.335"));
        ComplexNumber result = BinaryCanonicOperations.divide(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testDivide2() {
        System.out.println("divide2");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("-13.729"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-2.214"),new BigDecimal("0.852"));
        ComplexNumber result = BinaryCanonicOperations.divide(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testDivide3() {
        System.out.println("divide3");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("-22.729"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0.319"),new BigDecimal("0.948"));
        ComplexNumber result = BinaryCanonicOperations.divide(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testDivide4() {
        System.out.println("divide4");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0.180"),new BigDecimal("0.129"));
        ComplexNumber result = BinaryCanonicOperations.divide(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testDivide5() {
        System.out.println("divide5");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("-23.618"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-0.962"),new BigDecimal("1.339"));
        ComplexNumber result = BinaryCanonicOperations.divide(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testDivide6() {
        System.out.println("divide6");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        boolean thrown = false;
        try{
            ComplexNumber result = BinaryCanonicOperations.divide(n1, n2);
        }catch(ArithmeticException exc){
            thrown = true;
        }
        assertTrue(thrown);
    }
    
    @Test
    public void testDivide7() {
        System.out.println("divide7");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("-59"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-0.736"),new BigDecimal("0.677"));
        ComplexNumber result = BinaryCanonicOperations.divide(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testDivide8() {
        System.out.println("divide8");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("176"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0"),new BigDecimal("-1"));
        ComplexNumber result = BinaryCanonicOperations.divide(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testDivide9() {
        System.out.println("divide9");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        boolean thrown = false;
        try{
            ComplexNumber result = BinaryCanonicOperations.divide(n1, n2);
        }catch(ArithmeticException exc){
            thrown = true;
        }
        assertTrue(thrown);
    }
    
}
