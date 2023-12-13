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

    public ComplexNumber(BigDecimal realPart, BigDecimal imaginaryPart) {
        this.realPart = realPart.setScale(3,BigDecimal.ROUND_HALF_UP);
        this.imaginaryPart = imaginaryPart.setScale(3,BigDecimal.ROUND_HALF_UP);
        this.module = moduleCalculator();
        this.phase = phaseCalculator();
    }
    
    private BigDecimal moduleCalculator(){
        BigDecimal TWO = BigDecimal.valueOf(2);
        BigDecimal pow1 = BigDecimalMath.pow(realPart, TWO,MathContext.DECIMAL128);
        BigDecimal pow2 = BigDecimalMath.pow(imaginaryPart, TWO,MathContext.DECIMAL128);
        return BigDecimalMath.sqrt(pow1.add(pow2, MathContext.DECIMAL128),MathContext.DECIMAL128);
    }
    private BigDecimal phaseCalculator(){
        if(realPart.doubleValue() == 0 && imaginaryPart.doubleValue()== 0 ){
            return BigDecimal.ZERO;
        }
        else{
            return BigDecimalMath.atan2(imaginaryPart,realPart,MathContext.DECIMAL128);
        }
    }
    @Override
    public String toString() {
        BigDecimal realPart=this.realPart;
        BigDecimal imaginaryPart=this.imaginaryPart;
        
        if (realPart.doubleValue() == 0 && imaginaryPart.doubleValue() == 0){
            return "0";
        }
        
        StringBuffer stringa = new StringBuffer("");
        if (realPart.doubleValue() != 0){
            try{
                stringa.append(realPart.toBigIntegerExact().toString());
            }catch(ArithmeticException ex){
                stringa.append(realPart.toPlainString());
            }
        }
        
        if (imaginaryPart.compareTo(BigDecimal.ZERO) > 0) {
            if (realPart.doubleValue() != 0) {
                stringa.append(" + ");
            }
            if (imaginaryPart.doubleValue() == 1) {
                stringa.append("j");
            } else {
                try{
                    stringa.append(imaginaryPart.toBigIntegerExact().toString());
                    stringa.append("j");
                }catch(ArithmeticException ex){
                    stringa.append(imaginaryPart.toPlainString());
                    stringa.append("j");
                }
            }
        } else if (imaginaryPart.compareTo(BigDecimal.ZERO) < 0) {
            if (realPart.doubleValue() != 0) {
                stringa.append(" - ");
            } else {
                stringa.append("-");
            }
            if (imaginaryPart.doubleValue() == -1) {
                stringa.append("j");
            } else {
                try {
                    stringa.append(imaginaryPart.negate().toBigIntegerExact().toString());
                    stringa.append("j");
                } catch (ArithmeticException ex) {
                    stringa.append(imaginaryPart.negate().toPlainString());
                    stringa.append("j");
                }
            }
        }
        return stringa.toString().replace(',', '.');
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.realPart.hashCode();
        hash = 53 * hash + this.imaginaryPart.hashCode();
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComplexNumber other = (ComplexNumber) obj;

        return this.realPart.equals(other.realPart) && this.imaginaryPart.equals(other.imaginaryPart) ;
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
