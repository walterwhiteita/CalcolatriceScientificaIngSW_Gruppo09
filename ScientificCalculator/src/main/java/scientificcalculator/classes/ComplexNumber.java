package scientificcalculator.classes;

public class ComplexNumber {
    private double realPart;
    private double imaginaryPart;
    private double module;
    private double phase;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
        this.module = moduleCalculator();
        this.phase = phaseCalculator();
    }
    
    private double moduleCalculator(){
        return Math.sqrt(Math.pow(realPart, 2) + Math.pow(imaginaryPart, 2));
    }
    private double phaseCalculator(){
        return Math.atan2(imaginaryPart,realPart);
    }
    public String toString(){
        StringBuffer stringa = new StringBuffer("");
        if(realPart == 0 && imaginaryPart == 0){
            stringa.append("0");
            return stringa.toString();
        }
        else if(realPart == 0){
            if(Math.signum(imaginaryPart) > 0){
                if(imaginaryPart==1){
                    stringa.append("j");
                }
                else{
                    stringa.append(String.format(((imaginaryPart%1 == 0) ? "%.0fj" : "%.3fj"), Math.abs(imaginaryPart)));                    
                }
            }
            else if(Math.signum(imaginaryPart) < 0){
                if(imaginaryPart==-1){
                    stringa.append("-j");
                }
                else{
                    stringa.append(String.format(((imaginaryPart%1 == 0) ? "-%.0fj" : "-%.3fj"), Math.abs(imaginaryPart)));
                }
            }
        }
        else if(imaginaryPart == 0){
            if(Math.signum(realPart) > 0){
                stringa.append(String.format(((realPart%1 == 0) ? "%.0f" : "%.3f"), Math.abs(realPart)));
            }
            else if(Math.signum(realPart) < 0){
                stringa.append(String.format(((realPart%1 == 0) ? "-%.0f" : "-%.3f"), Math.abs(realPart)));
            }
        }
        else{
            if(Math.signum(realPart) > 0){
                stringa.append(String.format(((realPart%1 == 0) ? "%.0f" : "%.3f"), Math.abs(realPart)));
            }
            else if(Math.signum(realPart) < 0){
                stringa.append(String.format(((realPart%1 == 0) ? "-%.0f" : "-%.3f"), Math.abs(realPart)));
            }
            if(Math.signum(imaginaryPart) > 0){
                if(imaginaryPart == 1){
                    stringa.append(" + j");
                }
                else{
                    stringa.append(String.format(((imaginaryPart%1 == 0) ? " + %.0fj" : " + %.3fj"), Math.abs(imaginaryPart)));
                }
            }
            else if(Math.signum(imaginaryPart) < 0){
                if(imaginaryPart == -1){
                    stringa.append(" - j");
                }
                else{
                    stringa.append(String.format(((imaginaryPart%1 == 0) ? " - %.0fj" : " - %.3fj"), Math.abs(imaginaryPart)));
                }
            }
        }
        return stringa.toString().replace(',', '.');
    }
    
    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    public double getModule() {
        return module;
    }

    public void setModule(double module) {
        this.module = module;
    }

    public double getPhase() {
        return phase;
    }

    public void setPhase(double phase) {
        this.phase = phase;
    }
    
}
