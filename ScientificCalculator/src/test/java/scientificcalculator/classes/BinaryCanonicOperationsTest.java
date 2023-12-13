
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
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("-23"),new BigDecimal("59"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("8.624"),new BigDecimal("81.729"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum5() {
        System.out.println("sum5");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("207.624"),new BigDecimal("22.729"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum6() {
        System.out.println("sum6");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("-23.618"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("-0.889"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum7() {
        System.out.println("sum7");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum8() {
        System.out.println("sum8");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("111111111111111111"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("111111111111111142.624"),new BigDecimal("22.729"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum9() {
        System.out.println("sum9");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("-22.729"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("54.624"),new BigDecimal("36.271"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum10() {
        System.out.println("sum10");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("-59"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("46"),new BigDecimal("0"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum11() {
        System.out.println("sum11");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("9"),new BigDecimal("-13.729"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("32"),new BigDecimal("45.271"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum12() {
        System.out.println("sum12");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("-12.528"),new BigDecimal("74"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("163.472"),new BigDecimal("74"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum13() {
        System.out.println("sum13");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("13.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("176"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("189.729"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum14() {
        System.out.println("sum14");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("13.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("13.729"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum15() {
        System.out.println("sum15");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("13.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("23.618"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("37.347"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum16() {
        System.out.println("sum16");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("13.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("111111111111111111"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("111111111111111102"),new BigDecimal("13.729"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum17() {
        System.out.println("sum17");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("176"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("176"),new BigDecimal("176"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum18() {
        System.out.println("sum18");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("23.618"),new BigDecimal("0"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("111111111111111111"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("111111111111111134.618"),new BigDecimal("0"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum19() {
        System.out.println("sum19");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("-23.618"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("111111111111111111"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("111111111111111111"),new BigDecimal("-23.618"));
        ComplexNumber result = BinaryCanonicOperations.sum(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum20() {
        System.out.println("sum20");
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
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("-23"),new BigDecimal("59"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("54.624"),new BigDecimal("-36.271"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub5() {
        System.out.println("sub5");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-144.376"),new BigDecimal("22.729"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub6() {
        System.out.println("sub6");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("-23.618"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("46.347"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub7() {
        System.out.println("sub7");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub8() {
        System.out.println("sub8");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("111111111111111111"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-111111111111111079.376"),new BigDecimal("22.729"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub9() {
        System.out.println("sub9");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("-22.729"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-8.624"),new BigDecimal("81.729"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub10() {
        System.out.println("sub10");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("-59"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0"),new BigDecimal("118"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub11() {
        System.out.println("sub11");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("9"),new BigDecimal("-13.729"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("14"),new BigDecimal("72.729"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub12() {
        System.out.println("sub12");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("-12.528"),new BigDecimal("74"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-188.528"),new BigDecimal("74"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub13() {
        System.out.println("sub13");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("13.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("176"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("-162.271"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub14() {
        System.out.println("sub14");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("13.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("13.729"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub15() {
        System.out.println("sub15");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("13.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("23.618"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("-9.889"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub16() {
        System.out.println("sub16");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("13.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("111111111111111111"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-111111111111111120"),new BigDecimal("13.729"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub17() {
        System.out.println("sub17");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("176"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("176"),new BigDecimal("-176"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub18() {
        System.out.println("sub18");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("23.618"),new BigDecimal("0"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("111111111111111111"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-111111111111111087.382"),new BigDecimal("0"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub19() {
        System.out.println("sub19");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("-23.618"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("111111111111111111"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-111111111111111111"),new BigDecimal("-23.618"));
        ComplexNumber result = BinaryCanonicOperations.sub(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSub20() {
        System.out.println("sub20");
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
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("-23"),new BigDecimal("59"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-2068.363"),new BigDecimal("1343.049"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testMultiply5() {
        System.out.println("multiply5");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("5565.824"),new BigDecimal("4000.304"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testMultiply6() {
        System.out.println("multiply6");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("-23.618"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("536.814"),new BigDecimal("-746.896"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testMultiply7() {
        System.out.println("multiply7");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testMultiply8() {
        System.out.println("multiply8");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("-22.729"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("2068.363"),new BigDecimal("1343.049"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testMultiply9() {
        System.out.println("multiply9");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("-59"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("4010"),new BigDecimal("0"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testMultiply10() {
        System.out.println("multiply10");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("9"),new BigDecimal("-13.729"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("1017.011"),new BigDecimal("215.233"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testMultiply11() {
        System.out.println("multiply11");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("-12.528"),new BigDecimal("74"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-2204.928"),new BigDecimal("13024"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testMultiply12() {
        System.out.println("multiply12");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("13.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("176"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-2416.304"),new BigDecimal("-1584"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testMultiply13() {
        System.out.println("multiply13");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("13.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0"),new BigDecimal("0"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testMultiply14() {
        System.out.println("multiply14");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("13.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("23.618"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-324.252"),new BigDecimal("-212.562"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMultiply15() {
        System.out.println("multiply15");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("176"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0"),new BigDecimal("30976"));
        ComplexNumber result = BinaryCanonicOperations.multiply(n1, n2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMultiply16() {
        System.out.println("multiply16");
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
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("-23"),new BigDecimal("59"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0.153"),new BigDecimal("-0.596"));
        ComplexNumber result = BinaryCanonicOperations.divide(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testDivide5() {
        System.out.println("divide5");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0.180"),new BigDecimal("0.129"));
        ComplexNumber result = BinaryCanonicOperations.divide(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testDivide6() {
        System.out.println("divide6");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("22.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("-23.618"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-0.962"),new BigDecimal("1.339"));
        ComplexNumber result = BinaryCanonicOperations.divide(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testDivide7() {
        System.out.println("divide7");
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
    public void testDivide8() {
        System.out.println("divide8");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("31.624"),new BigDecimal("-22.729"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-0.405"),new BigDecimal("1.575"));
        ComplexNumber result = BinaryCanonicOperations.divide(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testDivide9() {
        System.out.println("divide9");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("-59"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-0.736"),new BigDecimal("0.677"));
        ComplexNumber result = BinaryCanonicOperations.divide(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testDivide10() {
        System.out.println("divide10");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("23"),new BigDecimal("59"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("9"),new BigDecimal("-13.729"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-2.238"),new BigDecimal("3.142"));
        ComplexNumber result = BinaryCanonicOperations.divide(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testDivide11() {
        System.out.println("divide11");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("-12.528"),new BigDecimal("74"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("-0.071"),new BigDecimal("0.420"));
        ComplexNumber result = BinaryCanonicOperations.divide(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testDivide12() {
        System.out.println("divide12");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("13.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("176"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0.078"),new BigDecimal("0.051"));
        ComplexNumber result = BinaryCanonicOperations.divide(n1, n2);
        assertEquals(expResult, result);
    }
    @Test()
    public void testDivide13() {
        System.out.println("divide13");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("13.729"));
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
    public void testDivide14() {
        System.out.println("divide14");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("-9"),new BigDecimal("13.729"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("23.618"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0.581"),new BigDecimal("0.381"));
        ComplexNumber result = BinaryCanonicOperations.divide(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testDivide15() {
        System.out.println("divide15");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("176"),new BigDecimal("0"));
        ComplexNumber n2 = new ComplexNumber(new BigDecimal("0"),new BigDecimal("176"));
        ComplexNumber expResult = new ComplexNumber(new BigDecimal("0"),new BigDecimal("-1"));
        ComplexNumber result = BinaryCanonicOperations.divide(n1, n2);
        assertEquals(expResult, result);
    }
    @Test
    public void testDivide16() {
        System.out.println("divide16");
        ComplexNumber n1 = new ComplexNumber(new BigDecimal("2.5"),new BigDecimal("3.4"));
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
