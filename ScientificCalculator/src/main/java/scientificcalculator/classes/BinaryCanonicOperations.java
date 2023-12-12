/*
    GRUPPO 09
    GIANMARCO GUERRIERO
    ANGELO DI MIERI
    BIAGIO DE MARTINO
    ANTONIO CARBONE
*/

package scientificcalculator.classes;

import static java.lang.Math.*;
import java.math.BigDecimal;
import java.math.MathContext;

public final class BinaryCanonicOperations {
    public static ComplexNumber sum(ComplexNumber n1, ComplexNumber n2){
        
        BigDecimal realPartResult = n1.getRealPart().add(n2.getRealPart(),MathContext.DECIMAL128);
        BigDecimal imaginaryPartResult = n1.getImaginaryPart().add(n2.getImaginaryPart(),MathContext.DECIMAL128);
        
        ComplexNumber result = new ComplexNumber(realPartResult, imaginaryPartResult);
        return result;
        
    }
    public static ComplexNumber sub(ComplexNumber n1, ComplexNumber n2){
        BigDecimal realPartResult = n1.getRealPart().subtract(n2.getRealPart(),MathContext.DECIMAL128);
        BigDecimal imaginaryPartResult = n1.getImaginaryPart().subtract(n2.getImaginaryPart(),MathContext.DECIMAL128);
        
        ComplexNumber result = new ComplexNumber(realPartResult, imaginaryPartResult);
        return result;
    }
    public static ComplexNumber multiply(ComplexNumber n1, ComplexNumber n2){
        
        BigDecimal resultModule = n1.getModule().multiply(n2.getModule(),MathContext.DECIMAL128);
        BigDecimal resultPhase = n1.getPhase().add(n2.getPhase(),MathContext.DECIMAL128);
        BigDecimal resultRealPart = resultModule.multiply(BigDecimal.valueOf(cos(resultPhase.doubleValue())),MathContext.DECIMAL128);
        BigDecimal resultImaginaryPart = resultModule.multiply(BigDecimal.valueOf(sin(resultPhase.doubleValue())),MathContext.DECIMAL128);
        
        ComplexNumber result = new ComplexNumber(resultRealPart, resultImaginaryPart);
        return result;
    }
    public static ComplexNumber divide(ComplexNumber n1, ComplexNumber n2){
        BigDecimal resultModule = n1.getModule().divide(n2.getModule(),MathContext.DECIMAL128);
        BigDecimal resultPhase = n1.getPhase().subtract(n2.getPhase(),MathContext.DECIMAL128);
        BigDecimal resultRealPart = resultModule.multiply(BigDecimal.valueOf(cos(resultPhase.doubleValue())),MathContext.DECIMAL128);
        BigDecimal resultImaginaryPart = resultModule.multiply(BigDecimal.valueOf(sin(resultPhase.doubleValue())),MathContext.DECIMAL128);
        
        ComplexNumber result = new ComplexNumber(resultRealPart, resultImaginaryPart);
        return result;
    }
}