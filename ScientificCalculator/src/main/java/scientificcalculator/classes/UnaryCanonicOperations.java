package scientificcalculator.classes;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

/**
 *
 * @author angel
 */
public final class UnaryCanonicOperations {
    public static ComplexNumber[] squareRoot(ComplexNumber n){
        ComplexNumber[] radix = new ComplexNumber[2];
        //Calcolo la prima radice
        double realPart = sqrt(n.getModule())*cos(n.getPhase()/2);
        double imaginaryPart = sqrt(n.getModule())*sin(n.getPhase()/2);
        //Inserisco il numero all'interno del vettore
        radix[0]=new ComplexNumber(realPart,imaginaryPart);
        //Calcolo la seconda radice
        realPart = sqrt(n.getModule())*cos((n.getPhase()+2*PI)/2);
        imaginaryPart = sqrt(n.getModule())*sin((n.getPhase()+2*PI)/2);
        //Inserisco il numero all'interno del vettore
        radix[1]=new ComplexNumber(realPart,imaginaryPart);
        //Ritorno il vettore
        return radix;
    }
    public static ComplexNumber changeSign(ComplexNumber n){
        return new ComplexNumber((n.getRealPart())*(-1),(n.getImaginaryPart())*(-1));
    }
}
