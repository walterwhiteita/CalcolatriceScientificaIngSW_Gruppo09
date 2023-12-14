package scientificcalculator.classes;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComplexNumberTest {
//Test metodo toString()
    
    @Test
    public void testToString_00() {
        System.out.println("toString re[d] + im[d]j");
        
        ComplexNumber num = new ComplexNumber(new BigDecimal("31.6238"), new BigDecimal("22.729"));
        assertEquals("31.624 + 22.729j", num.toString());
    }
    
    @Test
    public void testToString_01() {
        System.out.println("toString re[i] + im[i]j");
        
        ComplexNumber num = new ComplexNumber(new BigDecimal("23"), new BigDecimal("59"));
        assertEquals("23 + 59j", num.toString());
    }
    
    @Test
    public void testToString_02() {
        System.out.println("toString re[d] + im[i]j");
        
        ComplexNumber num = new ComplexNumber(new BigDecimal("12.528"), new BigDecimal("74"));
        assertEquals("12.528 + 74j", num.toString());
    }
    
    @Test
    public void testToString_03() {
        System.out.println("toString -re[i] - im[d]j");
        
        ComplexNumber num = new ComplexNumber(new BigDecimal("-9"), new BigDecimal("-13.729"));
        assertEquals("-9 - 13.729j", num.toString());
    }
    
    @Test
    public void testToString_04() {
        System.out.println("toString +re[i]");
        
        ComplexNumber num = new ComplexNumber(new BigDecimal("+176"), new BigDecimal("0"));
        assertEquals("176", num.toString());
    }
    
    @Test
    public void testToString_05() {
        System.out.println("toString 0 + 0j");
        
        ComplexNumber num = new ComplexNumber(new BigDecimal("0"), new BigDecimal("0"));
        assertEquals("0", num.toString());
    }
    
    @Test
    public void testToString_06() {
        System.out.println("toString im[d]j (long)");
        
        ComplexNumber num = new ComplexNumber(new BigDecimal("0"), new BigDecimal("2.1584926487859"));
        assertEquals("2.158j", num.toString());
    }
    
    @Test
    public void testToString_07() {
        System.out.println("toString re[i] (long)");
        
        ComplexNumber num = new ComplexNumber(new BigDecimal("11111111111111"), new BigDecimal("0"));
        assertEquals("11111111111111", num.toString());
    }
    
    @Test
    public void testToString_08() {
        System.out.println("toString 1j");
        
        ComplexNumber num = new ComplexNumber(new BigDecimal("0"), new BigDecimal("1"));
        assertEquals("j", num.toString());
    }
    
    @Test
    public void testToString_09() {
        System.out.println("toString -1j");
        
        ComplexNumber num = new ComplexNumber(new BigDecimal("0"), new BigDecimal("-1"));
        assertEquals("-j", num.toString());
    }
  
//Test metodo getRealPart()
    
    @Test
    public void testGetRealPart_00() {
        System.out.println("getRealPart decimale positiva");
        ComplexNumber num = new ComplexNumber(new BigDecimal("31.624"), new BigDecimal("22.729"));
        assertEquals(new BigDecimal("31.624"), num.getRealPart());
    }
    
    @Test
    public void testGetRealPart_01() {
        System.out.println("getRealPart intera positiva");
        ComplexNumber num = new ComplexNumber(new BigDecimal("23"), new BigDecimal("59"));
        assertEquals(new BigDecimal("23.000"), num.getRealPart());
    }
    
    @Test
    public void testGetRealPart_02() {
        System.out.println("getRealPart decimale negativa");
        ComplexNumber num = new ComplexNumber(new BigDecimal("-12.528"), new BigDecimal("74"));
        assertEquals(new BigDecimal("-12.528"), num.getRealPart());
    }
    
    @Test
    public void testGetRealPart_03() {
        System.out.println("getRealPart intera negativa");
        ComplexNumber num = new ComplexNumber(new BigDecimal("-176"), new BigDecimal("0"));
        assertEquals(new BigDecimal("-176.000"), num.getRealPart());
    }
    
    @Test
    public void testGetRealPart_04() {
        System.out.println("getRealPart 0");
        ComplexNumber num = new ComplexNumber(new BigDecimal("0"), new BigDecimal("0"));
        assertEquals(new BigDecimal("0.000"), num.getRealPart());
    }
    
    @Test
    public void testGetRealPart_05() {
        System.out.println("getRealPart 0 su num con parte immaginaria");
        ComplexNumber num = new ComplexNumber(new BigDecimal("0"), new BigDecimal("23.618"));
        assertEquals(new BigDecimal("0.000"), num.getRealPart());
    }

//Test metodo sgetImaginaryPart()
    
    @Test
    public void testGetImaginaryPart_00() {
        System.out.println("getImaginaryPart decimale positiva");
        ComplexNumber num = new ComplexNumber(new BigDecimal("31.624"), new BigDecimal("22.729"));
        assertEquals(new BigDecimal("22.729"), num.getImaginaryPart());
    }
    
    @Test
    public void testGetImaginaryPart_01() {
        System.out.println("getImaginaryPart intera positiva");
        ComplexNumber num = new ComplexNumber(new BigDecimal("23"), new BigDecimal("59"));
        assertEquals(new BigDecimal("59.000"), num.getImaginaryPart());
    }
    
    @Test
    public void testGetImaginaryPart_02() {
        System.out.println("getImaginaryPart decimale negativa");
        ComplexNumber num = new ComplexNumber(new BigDecimal("74"), new BigDecimal("-12.528"));
        assertEquals(new BigDecimal("-12.528"), num.getImaginaryPart());
    }
    
    @Test
    public void testGetImaginaryPart_03() {
        System.out.println("getImaginaryPart intera negativa");
        ComplexNumber num = new ComplexNumber(new BigDecimal("0"), new BigDecimal("-176"));
        assertEquals(new BigDecimal("-176.000"), num.getImaginaryPart());
    }
    
    @Test
    public void testGetImaginaryPart_04() {
        System.out.println("getImaginaryPart 0");
        ComplexNumber num = new ComplexNumber(new BigDecimal("0"), new BigDecimal("0"));
        assertEquals(new BigDecimal("0.000"), num.getImaginaryPart());
    }
    
    @Test
    public void testGetImaginaryPart_05() {
        System.out.println("getImaginaryPart 0 su num con parte reale");
        ComplexNumber num = new ComplexNumber(new BigDecimal("23.618"), new BigDecimal("0"));
        assertEquals(new BigDecimal("0.000"), num.getImaginaryPart());
    }
    
//Test metodo getModule()
    
    @Test
    public void testGetModule_00() {
        System.out.println("getModule complesso decimale concordi");
        ComplexNumber num = new ComplexNumber(new BigDecimal("31.624"), new BigDecimal("22.729"));
        assertEquals(new BigDecimal("38.945"), num.getModule().setScale(3, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void testGetModule_01() {
        System.out.println("getModule complesso intero concordi");
        ComplexNumber num = new ComplexNumber(new BigDecimal("23"), new BigDecimal("59"));
        assertEquals(new BigDecimal("63.325"), num.getModule().setScale(3, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void testGetModule_02() {
        System.out.println("getModule complesso misto discordi [-im]");
        ComplexNumber num = new ComplexNumber(new BigDecimal("74"), new BigDecimal("-12.528"));
        assertEquals(new BigDecimal("75.053"), num.getModule().setScale(3, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void testGetModule_03() {
        System.out.println("getModule immaginario intero negativo");
        ComplexNumber num = new ComplexNumber(new BigDecimal("0"), new BigDecimal("-176"));
        assertEquals(new BigDecimal("176.000"), num.getModule().setScale(3, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void testGetModule_04() {
        System.out.println("getModule immaginario decimale negativo");
        ComplexNumber num = new ComplexNumber(new BigDecimal("0"), new BigDecimal("-23.618"));
        assertEquals(new BigDecimal("23.618"), num.getModule().setScale(3, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void testGetModule_05() {
        System.out.println("getModule 0");
        ComplexNumber num = new ComplexNumber(new BigDecimal("0"), new BigDecimal("0"));
        assertEquals(new BigDecimal("0.000"), num.getModule().setScale(3, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void testGetModule_06() {
        System.out.println("getModule reale decimale positivo");
        ComplexNumber num = new ComplexNumber(new BigDecimal("23.618"), new BigDecimal("0"));
        assertEquals(new BigDecimal("23.618"), num.getModule().setScale(3, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void testGetModule_07() {
        System.out.println("getModule complesso misto concordi [long]");
        ComplexNumber num = new ComplexNumber(new BigDecimal("111111111111111111"), new BigDecimal("2.1584926487859"));
        assertEquals(new BigDecimal("111111111111111111.000"), num.getModule().setScale(3, BigDecimal.ROUND_HALF_UP));
    }
    
//Test metodo getPhase()
    
    @Test
    public void testGetPhase_00() {
        System.out.println("getPhase complesso decimale concordi");
        ComplexNumber num = new ComplexNumber(new BigDecimal("31.624"), new BigDecimal("22.729"));
        assertEquals(new BigDecimal("0.623"), num.getPhase().setScale(3, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void testGetPhase_01() {
        System.out.println("getPhase complesso intero concordi");
        ComplexNumber num = new ComplexNumber(new BigDecimal("23"), new BigDecimal("59"));
        assertEquals(new BigDecimal("1.199"), num.getPhase().setScale(3, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void testGetPhase_02() {
        System.out.println("getPhase complesso misto discordi [-im]");
        ComplexNumber num = new ComplexNumber(new BigDecimal("74"), new BigDecimal("-12.528"));
        assertEquals(new BigDecimal("-0.168"), num.getPhase().setScale(3, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void testGetPhase_03() {
        System.out.println("getPhase immaginario intero negativo");
        ComplexNumber num = new ComplexNumber(new BigDecimal("0"), new BigDecimal("-176"));
        assertEquals(new BigDecimal("-1.571"), num.getPhase().setScale(3, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void testGetPhase_04() {
        System.out.println("getPhase immaginario decimale negativo");
        ComplexNumber num = new ComplexNumber(new BigDecimal("0"), new BigDecimal("-23.618"));
        assertEquals(new BigDecimal("-1.571"), num.getPhase().setScale(3, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void testGetPhase_05() {
        System.out.println("getPhase 0");
        ComplexNumber num = new ComplexNumber(new BigDecimal("0"), new BigDecimal("0"));
        assertEquals(new BigDecimal("0.000"), num.getPhase().setScale(3, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void testGetPhase_06() {
        System.out.println("getPhase reale decimale positivo");
        ComplexNumber num = new ComplexNumber(new BigDecimal("23.618"), new BigDecimal("0"));
        assertEquals(new BigDecimal("0.000"), num.getPhase().setScale(3, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void testGetPhase_07() {
        System.out.println("getPhase complesso misto concordi [long]");
        ComplexNumber num = new ComplexNumber(new BigDecimal("111111111111111111"), new BigDecimal("2.1584926487859"));
        assertEquals(new BigDecimal("0.000"), num.getPhase().setScale(3, BigDecimal.ROUND_HALF_UP));
    }
}