/*
    GRUPPO 09
    GIANMARCO GUERRIERO
    ANGELO DI MIERI
    BIAGIO DE MARTINO
    ANTONIO CARBONE
*/

package scientificcalculator.classes;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import java.math.BigDecimal;
import java.math.MathContext;

public final class UnaryCanonicOperations {
    public static ComplexNumber[] squareRoot(ComplexNumber n){
        ComplexNumber[] radix = new ComplexNumber[2];
        Double moduleRadix = sqrt(n.getModule().doubleValue());
        Double phase = n.getPhase().doubleValue()/2;
        Double phasePI = (n.getPhase().doubleValue()+2*PI)/2;
        //Calcolo la prima radice
        BigDecimal realPart = BigDecimal.valueOf(moduleRadix * cos(phase));
        BigDecimal imaginaryPart = BigDecimal.valueOf(moduleRadix * sin(phase));
        //Inserisco il numero all'interno del vettore
        radix[0]=new ComplexNumber(realPart,imaginaryPart);
        //Calcolo la seconda radice
        realPart = BigDecimal.valueOf((moduleRadix) * cos(phasePI));
        imaginaryPart = BigDecimal.valueOf((moduleRadix) * sin(phasePI));
        //Inserisco il numero all'interno del vettore
        radix[1]=new ComplexNumber(realPart,imaginaryPart);
        //Ritorno il vettore
        return radix;
    }
    public static ComplexNumber changeSign(ComplexNumber n){
        return new ComplexNumber((n.getRealPart().negate(MathContext.DECIMAL128)),(n.getImaginaryPart().negate(MathContext.DECIMAL128)));
    }
}
