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
    //Metodo che effettua la somma tra due numeri complessi
    public static ComplexNumber sum(ComplexNumber n1, ComplexNumber n2){
        //Definisco il MathContext per le varie operazioni
        final MathContext mc = MathContext.DECIMAL128;
        
        //Calcolo la parte reale risultante, come somma delle due parti reali
        BigDecimal realPartResult = n1.getRealPart().add(n2.getRealPart(),mc);
        //Calcolo la parte immaginaria risultante, come somma delle due parti immaginarie
        BigDecimal imaginaryPartResult = n1.getImaginaryPart().add(
                n2.getImaginaryPart(),mc);
        
        //Restituisco il numero complesso con i valori calcolati prima
        return new ComplexNumber(realPartResult, imaginaryPartResult);
        
    }
    
    //Metodo che effettua la differenza tra due numeri complessi
    public static ComplexNumber sub(ComplexNumber n1, ComplexNumber n2){
        //Definisco il MathContext per le varie operazioni
        final MathContext mc = MathContext.DECIMAL128;
        
        //Calcolo la parte reale risultante, come differenza delle due parti reali
        BigDecimal realPartResult = n1.getRealPart().subtract(n2.getRealPart(),mc);
        //Calcolo la parte immaginaria risultante, come differenza delle due parti immaginarie
        BigDecimal imaginaryPartResult = n1.getImaginaryPart().
                subtract(n2.getImaginaryPart(),mc);
        
        //Restituisco il numero complesso con i valori calcolati prima
        return new ComplexNumber(realPartResult, imaginaryPartResult);
    }
    
    //Metodo che effettua la moltiplicazione tra due numeri complessi
    public static ComplexNumber multiply(ComplexNumber n1, ComplexNumber n2){
        //Definisco il MathContext per le varie operazioni
        final MathContext mc = MathContext.DECIMAL128;
        
        //Calcolo il prodotto delle parti reali dei due numeri
        BigDecimal prodReal = n1.getRealPart().multiply(n2.getRealPart(), mc);
        //Calcolo il prodotto delle parti immaginarie dei due numeri
        BigDecimal prodImaginary = n1.getImaginaryPart().multiply(
                n2.getImaginaryPart(), mc);
        
        //Calcolo la parte reale risultante come differenza tra i due prodotti calcolati prima
        BigDecimal resultRealPart = prodReal.subtract(prodImaginary, mc);
        
        //Calcolo i due prodotti misti
        BigDecimal prodMix1 = n1.getRealPart().multiply(n2.getImaginaryPart(), mc);
        BigDecimal prodMix2 = n1.getImaginaryPart().multiply(n2.getRealPart(), mc);
        
        //Calcolo la parte immaginaria risultante come somma tra i due prodotti calcolati prima
        BigDecimal resultImaginaryPart = prodMix1.add(prodMix2,mc);
        
        //Restituisco il numero complesso con i valori calcolati prima
        return new ComplexNumber(resultRealPart, resultImaginaryPart);
    }
    
    //Metodo che effettua la differenza tra due numeri complessi
    public static ComplexNumber divide(ComplexNumber n1, ComplexNumber n2){
        //Definisco il MathContext per le varie operazioni
        final MathContext mc = MathContext.DECIMAL128;
        
        //Calcolo il prodotto delle parti reali dei due numeri
        BigDecimal prodReal = n1.getRealPart().multiply(n2.getRealPart(), mc);
        //Calcolo il prodotto delle parti immaginarie dei due numeri
        BigDecimal prodImaginary = n1.getImaginaryPart().multiply(
                n2.getImaginaryPart(), mc);
        
        //Calcolo i due prodotti misti
        BigDecimal prodMix1 = n1.getImaginaryPart().multiply(n2.getRealPart(),mc);
        BigDecimal prodMix2 = n1.getRealPart().multiply(n2.getImaginaryPart(),mc);
        
        /*Calcolo il denominatore della divisione come somma dei quadrati della parte reale
        e di quella immaginaria, del secondo numero*/
        BigDecimal den = n2.getRealPart().pow(2).add(n2.getImaginaryPart().pow(2));
        
        /*Aggiungo al prodotto delle parte reali, il prodotto delle parti immaginarie,
        infine lo divido per il denominatore calcolato prima*/
        BigDecimal resultRealPart = prodReal.add(prodImaginary)
                .divide(den,BigDecimal.ROUND_HALF_UP);
        
        /*Sottraggo al primo prodotto misto, il secondo prodotto misto,
        infine lo divido per il denominatore calcolato prima*/
        BigDecimal resultImaginaryPart = prodMix1.subtract(prodMix2)
                .divide(den,BigDecimal.ROUND_HALF_UP);
        
        //Restituisco il numero complesso con i valori calcolati prima
        return new ComplexNumber(resultRealPart, resultImaginaryPart);
    }
}