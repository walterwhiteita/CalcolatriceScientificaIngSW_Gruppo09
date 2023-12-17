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
        //Definisco il MathContext per le varie operazioni
        final MathContext mc = MathContext.DECIMAL128;
        
        //Alloco il vettore per salvare i valori delle radici
        ComplexNumber[] radix = new ComplexNumber[2];
        
        //Calcolo la radice del modulo
        BigDecimal moduleRadix = BigDecimalMath.sqrt(n.getModule(), mc);
        
        //Effettuo la divisione della fase per 2
        BigDecimal phase = n.getPhase().divide(BigDecimal.valueOf(2),mc);
        

        /*Calcolo la prima radice, per la parte reale moltiplico la radice del modulo
        per il coseno della fase*/
        BigDecimal realPart = moduleRadix.multiply(
                BigDecimalMath.cos(phase, mc), mc);
        
        //Per la parte immaginaria moltiplico la radice del modulo per il seno della fase
        BigDecimal imaginaryPart = moduleRadix.multiply(
                BigDecimalMath.sin(phase, mc), mc);
        
        //Inserisco la prima radice calcolata all'interno del vettore
        radix[0]=new ComplexNumber(realPart,imaginaryPart);
        
        /*Calcolo la seconda radice, la parte reale della seconda radice corrisponde
        alla parte reale della prima ma negata. Questo perchè differiscono in fase di PI*/
        realPart = realPart.negate();
        
        /*La parte immaginaria della seconda radice corrisponde alla parte immaginaria
        della prima ma negata. Questo perchè differiscono in fase di PI*/
        imaginaryPart = imaginaryPart.negate();
        
        //Inserisco la seconda radice calcolata all'interno del vettore
        radix[1]=new ComplexNumber(realPart,imaginaryPart);
        
        //Restituisco il vettore popolato dalle radici
        return radix;
    }

    public static ComplexNumber changeSign(ComplexNumber n){
        //Ritorno il numero complesso con operazione di cambio segno effettuata
        return new ComplexNumber((n.getRealPart().negate(MathContext.DECIMAL128)),
                (n.getImaginaryPart().negate(MathContext.DECIMAL128)));
    }  
}
