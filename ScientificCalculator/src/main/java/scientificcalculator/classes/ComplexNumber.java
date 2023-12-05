package scientificcalculator.classes;

public class ComplexNumber {
    private double realPart;
    private double imaginaryPart;
    private double module;
    private double phase;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }
    
    private double moduleCalculator(){
        return 0;
    }
    private double phaseCalculator(){
        return 0;
    }
    public String toString(){
        return "debug";
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
