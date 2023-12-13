/*
    GRUPPO 09
    GIANMARCO GUERRIERO
    ANGELO DI MIERI
    BIAGIO DE MARTINO
    ANTONIO CARBONE
*/

package scientificcalculator.classes;

import java.math.BigDecimal;


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
        return BigDecimal.valueOf(Math.sqrt(Math.pow(realPart.doubleValue(), 2) + Math.pow(imaginaryPart.doubleValue(), 2)));
    }
    private BigDecimal phaseCalculator(){
        if(realPart.doubleValue() == 0 && imaginaryPart.doubleValue() == 0){
            return BigDecimal.ZERO;
        }
        else{
            return BigDecimal.valueOf(Math.atan2(imaginaryPart.doubleValue(),realPart.doubleValue()));
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
    
    

}
