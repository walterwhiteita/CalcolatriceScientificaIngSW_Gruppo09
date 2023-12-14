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
        final MathContext mc = MathContext.DECIMAL128;
        ComplexNumber[] radix = new ComplexNumber[2];
        
        BigDecimal moduleRadix = BigDecimalMath.sqrt(n.getModule(), mc);
        BigDecimal phase = n.getPhase().divide(BigDecimal.valueOf(2),mc);
        //Calcolo la prima radice
        BigDecimal realPart = moduleRadix.multiply(BigDecimalMath.cos(phase, mc), mc);
        BigDecimal imaginaryPart = moduleRadix.multiply(BigDecimalMath.sin(phase, mc), mc);
        //Inserisco il numero all'interno del vettore
        radix[0]=new ComplexNumber(realPart,imaginaryPart);
        
        //Calcolo la seconda radice
        realPart = realPart.negate();
        imaginaryPart = imaginaryPart.negate();
        //Inserisco il numero all'interno del vettore
        radix[1]=new ComplexNumber(realPart,imaginaryPart);
        //Ritorno il vettore
        return radix;
    }

    public static ComplexNumber changeSign(ComplexNumber n){
        return new ComplexNumber((n.getRealPart().negate(MathContext.DECIMAL128)),
                (n.getImaginaryPart().negate(MathContext.DECIMAL128)));
    }  
}
