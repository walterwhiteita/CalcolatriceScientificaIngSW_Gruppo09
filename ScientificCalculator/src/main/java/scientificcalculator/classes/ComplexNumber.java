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
        stringa.append(String.format("%.3f", realPart));
        if(Math.signum(imaginaryPart) > 0){
            stringa.append(" + ");
            stringa.append(String.format("%.3f", Math.abs(imaginaryPart)));
            stringa.append("j");
        }
        else if(Math.signum(imaginaryPart) < 0){
            stringa.append(" - ");
            stringa.append(String.format("%.3f", Math.abs(imaginaryPart)));
            stringa.append("j");
        }
        return stringa.toString();
    }

    public double getRealPart() {
        return realPart;
    }

    private void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    private void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    public double getModule() {
        return module;
    }

    private void setModule(double module) {
        this.module = module;
    }

    public double getPhase() {
        return phase;
    }

    private void setPhase(double phase) {
        this.phase = phase;
    }
    
}
