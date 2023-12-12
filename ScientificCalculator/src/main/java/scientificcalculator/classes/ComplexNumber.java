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
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
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
        
        realPart = realPart.setScale(3, BigDecimal.ROUND_HALF_UP);
        imaginaryPart = imaginaryPart.setScale(3, BigDecimal.ROUND_HALF_UP);
        
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

    public void setRealPart(BigDecimal realPart) {
        this.realPart = realPart;
    }

    public BigDecimal getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(BigDecimal imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    public BigDecimal getModule() {
        return module;
    }

    public void setModule(BigDecimal module) {
        this.module = module;
    }

    public BigDecimal getPhase() {
        return phase;
    }

    public void setPhase(BigDecimal phase) {
        this.phase = phase;
    }
    
    
}
