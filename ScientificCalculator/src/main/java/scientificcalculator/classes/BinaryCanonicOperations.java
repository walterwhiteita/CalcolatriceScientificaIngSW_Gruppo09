/*
    GRUPPO 09
    GIANMARCO GUERRIERO
    ANGELO DI MIERI
    BIAGIO DE MARTINO
    ANTONIO CARBONE
*/

package scientificcalculator.classes;

import java.math.BigDecimal;
import java.math.MathContext;

public final class BinaryCanonicOperations {
    public static ComplexNumber sum(ComplexNumber n1, ComplexNumber n2){
        
        BigDecimal realPartResult = n1.getRealPart().add(n2.getRealPart(),MathContext.UNLIMITED);
        BigDecimal imaginaryPartResult = n1.getImaginaryPart().add(n2.getImaginaryPart(),MathContext.UNLIMITED);
        
        ComplexNumber result = new ComplexNumber(realPartResult, imaginaryPartResult);
        return result;
        
    }
    public static ComplexNumber sub(ComplexNumber n1, ComplexNumber n2){
        BigDecimal realPartResult = n1.getRealPart().subtract(n2.getRealPart(),MathContext.UNLIMITED);
        BigDecimal imaginaryPartResult = n1.getImaginaryPart().subtract(n2.getImaginaryPart(),MathContext.UNLIMITED);
        
        ComplexNumber result = new ComplexNumber(realPartResult, imaginaryPartResult);
        return result;
    }
    public static ComplexNumber multiply(ComplexNumber n1, ComplexNumber n2){
        BigDecimal prodReal = n1.getRealPart().multiply(n2.getRealPart(), MathContext.UNLIMITED);
        BigDecimal prodImaginary = n1.getImaginaryPart().multiply(n2.getImaginaryPart(), MathContext.UNLIMITED);
        
        BigDecimal resultRealPart = prodReal.subtract(prodImaginary, MathContext.UNLIMITED);
        
        BigDecimal prodMix1 = n1.getRealPart().multiply(n2.getImaginaryPart(), MathContext.UNLIMITED);
        BigDecimal prodMix2 = n1.getImaginaryPart().multiply(n2.getRealPart(), MathContext.UNLIMITED);
        
        BigDecimal resultImaginaryPart = prodMix1.add(prodMix2,MathContext.UNLIMITED);
        
        ComplexNumber result = new ComplexNumber(resultRealPart, resultImaginaryPart);
        return result;
    }
    public static ComplexNumber divide(ComplexNumber n1, ComplexNumber n2){
        BigDecimal prodReal = n1.getRealPart().multiply(n2.getRealPart());
        BigDecimal prodImaginary = n1.getImaginaryPart().multiply(n2.getImaginaryPart());
        
        BigDecimal prodMix1 = n1.getImaginaryPart().multiply(n2.getRealPart());
        BigDecimal prodMix2 = n1.getRealPart().multiply(n2.getImaginaryPart());
        
        BigDecimal den = n2.getRealPart().pow(2).add(n2.getImaginaryPart().pow(2));
        
        BigDecimal resultRealPart = prodReal.add(prodImaginary).divide(den,BigDecimal.ROUND_HALF_UP);
        BigDecimal resultImaginaryPart = prodMix1.subtract(prodMix2).divide(den,BigDecimal.ROUND_HALF_UP);
        
        ComplexNumber result = new ComplexNumber(resultRealPart, resultImaginaryPart);
        return result;
    }
}