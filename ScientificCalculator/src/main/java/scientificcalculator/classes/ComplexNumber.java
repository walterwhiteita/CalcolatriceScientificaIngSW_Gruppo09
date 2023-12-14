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

public class ComplexNumber {
    private BigDecimal realPart;
    private BigDecimal imaginaryPart;
    private BigDecimal module;
    private BigDecimal phase;
    
    /*Costruttore della classe ComplexNumber, a cui vengono passati parte reale,
    parte immaginaria. Quando viene instanziato un nuovo oggetto è il costruttore stesso
    a chiamare i metodi appropriati per i calcoli di modulo e fase*/
    public ComplexNumber(BigDecimal realPart, BigDecimal imaginaryPart) {
        this.realPart = realPart.setScale(3,BigDecimal.ROUND_HALF_UP);
        this.imaginaryPart = imaginaryPart.setScale(3,BigDecimal.ROUND_HALF_UP);
        this.module = moduleCalculator();
        this.phase = phaseCalculator();
    }
    
    //Metodo usato dal costruttore per il calcolo del modulo
    private BigDecimal moduleCalculator(){
        //Definisco il MathContext per le varie operazioni
        MathContext mc = MathContext.DECIMAL128;

        //Creo un oggetto BigDecimal di valore pari a 2
        BigDecimal TWO = BigDecimal.valueOf(2);
        
        //Calcolo il quadrato della parte reale
        BigDecimal pow1 = BigDecimalMath.pow(realPart, TWO,mc);
        //Calcolo il quadrato della parte immaginaria
        BigDecimal pow2 = BigDecimalMath.pow(imaginaryPart, TWO,mc);
        
        /*Restituisco il risultato della radice quadrata della somma 
        dei due quadrati calcolati in precedenza*/
        return BigDecimalMath.sqrt(pow1.add
            (pow2, mc),mc);
    }
    
    //Metodo usato dal costruttore per il calcolo della fase
    private BigDecimal phaseCalculator(){
        //Nel caso in cui parte reale e parte immaginaria sono pari a 0, la fase è 0
        if(realPart.doubleValue() == 0 && imaginaryPart.doubleValue()== 0 ){
            return BigDecimal.ZERO;
        }
        
        /*Nel caso in cui, sia parte reale che immaginaria sono diversi da 0, allora
        prosso procedere ad effettuare il calcolo dell'arcotangente di y/x, con 
        y = imaginaryPart e x = realPart*/
        else{
            return BigDecimalMath.atan2
                (imaginaryPart,realPart,MathContext.DECIMAL128);
        }
    }
    
    //Metodo che fornisce una rappresentazione di un numero complesso restituendo una stringa
    @Override
    public String toString() {
        BigDecimal realPart=this.realPart;
        BigDecimal imaginaryPart=this.imaginaryPart;
        //Caso in cui parte reale e parte immaginaria sono pari a zero, restiutisco 0
        if (realPart.doubleValue() == 0 && imaginaryPart.doubleValue() == 0){
            return "0";
        }
        
        //Viene instanziato lo StringBuffer per poter costruire la stringa
        StringBuffer stringa = new StringBuffer("");
        //Controllo che la parte reale sia diversa da zero
        if (realPart.doubleValue() != 0){
            /*Controllo se il numero può essere interpretato come intero, utilizzando
            il metodo toBigIntegerExact(), che lancia un ArithmeticException. Nel caso
            in cui la conversione ad intero è possibile(senza perdere informazioni),
            alla stringa viene aggiunto il numero come intero. Altrimenti gestisco
            l'eccezione e aggiungo alla stringa il numero con la parte decimale*/
            try{
                stringa.append(realPart.toBigIntegerExact().toString());
            }catch(ArithmeticException ex){
                stringa.append(realPart.toPlainString());
            }
        }
        //Controllo che la parte immaginaria sia maggiore di zero
        if (imaginaryPart.compareTo(BigDecimal.ZERO) > 0) {
            //Controllo se il numero è preceduto da una parte reale
            if (realPart.doubleValue() != 0) {
                stringa.append(" + ");
            }
            
            //Se la parte immaginaria è pari a 1, inserisco solo j e non 1j
            if (imaginaryPart.doubleValue() == 1) {
                stringa.append("j");
            } else {
            /*Controllo se il numero può essere interpretato come intero, utilizzando
            il metodo toBigIntegerExact(), che lancia un ArithmeticException. Nel caso
            in cui la conversione ad intero è possibile(senza perdere informazioni),
            alla stringa viene aggiunto il numero come intero. Altrimenti gestisco
            l'eccezione e aggiungo alla stringa il numero con la parte decimale.
            In ogni caso, poichè è la parte immaginaria aggiungo j al termine della stringa*/
                try{
                    stringa.append(imaginaryPart.toBigIntegerExact().toString());
                    stringa.append("j");
                }catch(ArithmeticException ex){
                    stringa.append(imaginaryPart.toPlainString());
                    stringa.append("j");
                }
            }
            
        //Controllo che la parte immaginaria sia minore di zero
        } else if (imaginaryPart.compareTo(BigDecimal.ZERO) < 0) {
            //Controllo se il numero è preceduto da una parte reale
            if (realPart.doubleValue() != 0) {
                stringa.append(" - ");
            } 
            else {
                stringa.append("-");
            }
            
            //Se la parte immaginaria è pari a 1, inserisco solo j e non 1j
            if (imaginaryPart.doubleValue() == -1) {
                stringa.append("j");
            } else {
            /*Controllo se il numero può essere interpretato come intero, utilizzando
            il metodo toBigIntegerExact(), che lancia un ArithmeticException. Nel caso
            in cui la conversione ad intero è possibile(senza perdere informazioni),
            alla stringa viene aggiunto il numero come intero. Altrimenti gestisco
            l'eccezione e aggiungo alla stringa il numero con la parte decimale.
            In ogni caso, poichè è la parte immaginaria aggiungo j al termine della stringa*/    
                try {
                    stringa.append(imaginaryPart.negate().toBigIntegerExact().toString());
                    stringa.append("j");
                } catch (ArithmeticException ex) {
                    stringa.append(imaginaryPart.negate().toPlainString());
                    stringa.append("j");
                }
            }
        }
        //Restituisco la stringa, rimpiazzando ',' con '.'
        return stringa.toString().replace(',', '.');
    }
    
    //Metodo che genera l'hascode di un numero complesso
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.realPart.hashCode();
        hash = 53 * hash + this.imaginaryPart.hashCode();
        return hash;
    }
    
    //Metodo che permette di definire l'uguaglianza tra due numeri complessi
    @Override
    public boolean equals(Object obj) {
        //Se i reference di this e l'oggetto sono passati restiutisco truw
        if (this == obj) {
            return true;
        }
        //Se l'oggetto passato è null restituisco false
        if (obj == null) {
            return false;
        }
        //Se i due oggetti hanno classi diverse restituisco false
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        //Poichè ho effettuato il controllo prima posso effettuare il cast esplicito
        final ComplexNumber other = (ComplexNumber) obj;
        
        /*Restituisco true, se le parti reali e le parti immaginarie sono ugali,
        altrimenti restituisco false*/
        return this.realPart.equals(other.realPart) && 
                this.imaginaryPart.equals(other.imaginaryPart);
    }
    
    public BigDecimal getRealPart() {
        return realPart;
    }

    public BigDecimal getImaginaryPart() {
        return imaginaryPart;
    }

    public BigDecimal getModule() {
        return module;
    }

    public BigDecimal getPhase() {
        return phase;
    }

}
