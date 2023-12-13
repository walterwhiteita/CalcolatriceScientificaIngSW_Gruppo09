/*
    GRUPPO 09
    GIANMARCO GUERRIERO
    ANGELO DI MIERI
    BIAGIO DE MARTINO
    ANTONIO CARBONE
*/

package scientificcalculator.classes;

import ch.obermuhlner.math.big.BigDecimalMath;
import java.math.BigDecimal;
import java.math.MathContext;

public final class UnaryCanonicOperations {
    public static ComplexNumber[] squareRoot(ComplexNumber n){
        ComplexNumber[] radix = new ComplexNumber[2];
        BigDecimal moduleRadix = BigDecimalMath.sqrt(n.getModule(), MathContext.DECIMAL128);
        BigDecimal phase = n.getPhase().divide(BigDecimal.valueOf(2),MathContext.DECIMAL128);
        BigDecimal phasePI = (n.getPhase().add(BigDecimal.valueOf(2).multiply(BigDecimalMath.pi(MathContext.DECIMAL128)))).divide(BigDecimal.valueOf(2), MathContext.DECIMAL128);
        //Calcolo la prima radice
        BigDecimal realPart = moduleRadix.multiply(BigDecimalMath.cos(phase, MathContext.DECIMAL128), MathContext.DECIMAL128);
        BigDecimal imaginaryPart = moduleRadix.multiply(BigDecimalMath.sin(phase, MathContext.DECIMAL128), MathContext.DECIMAL128);
        //Inserisco il numero all'interno del vettore
        radix[0]=new ComplexNumber(realPart,imaginaryPart);
        
        //Calcolo la seconda radice
        realPart = moduleRadix.multiply(BigDecimalMath.cos(phasePI, MathContext.DECIMAL128), MathContext.DECIMAL128);
        imaginaryPart = moduleRadix.multiply(BigDecimalMath.sin(phasePI, MathContext.DECIMAL128), MathContext.DECIMAL128);
        //Inserisco il numero all'interno del vettore
        radix[1]=new ComplexNumber(realPart,imaginaryPart);
        //Ritorno il vettore
        return radix;
    }

    public static ComplexNumber changeSign(ComplexNumber n){
        return new ComplexNumber((n.getRealPart().negate(MathContext.UNLIMITED)),(n.getImaginaryPart().negate(MathContext.UNLIMITED)));
    }  
}
