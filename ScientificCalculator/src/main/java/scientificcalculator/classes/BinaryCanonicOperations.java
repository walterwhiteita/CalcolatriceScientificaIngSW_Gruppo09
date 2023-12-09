package scientificcalculator.classes;

import static java.lang.Math.*;

public final class BinaryCanonicOperations {
    public static ComplexNumber sum(ComplexNumber n1, ComplexNumber n2){
        
        double realPartResult = n1.getRealPart() + n2.getRealPart();
        double imaginaryPartResult = n1.getImaginaryPart() + n2.getImaginaryPart();
        
        ComplexNumber result = new ComplexNumber(realPartResult, imaginaryPartResult);
        return result;
        
    }
    public static ComplexNumber sub(ComplexNumber n1, ComplexNumber n2){
        double realPartResult = n1.getRealPart() - n2.getRealPart();
        double imaginaryPartResult = n1.getImaginaryPart() - n2.getImaginaryPart();
        
        ComplexNumber result = new ComplexNumber(realPartResult, imaginaryPartResult);
        return result;
    }
    public static ComplexNumber multiply(ComplexNumber n1, ComplexNumber n2){
        
        double resultModule = n1.getModule() * n2.getModule();
        double resultPhase = n1.getPhase() + n2.getPhase();
        double resultRealPart = resultModule * cos(resultPhase);
        double resultImaginaryPart = resultModule * sin(resultPhase);
        
        ComplexNumber result = new ComplexNumber(resultRealPart, resultImaginaryPart);
        return result;
    }
    public static ComplexNumber divide(ComplexNumber n1, ComplexNumber n2){
        double resultModule = n1.getModule() / n2.getModule();
        double resultPhase = n1.getPhase() - n2.getPhase();
        double resultRealPart = resultModule * cos(resultPhase);
        double resultImaginaryPart = resultModule * sin(resultPhase);
        
        ComplexNumber result = new ComplexNumber(resultRealPart, resultImaginaryPart);
        return result;
    }
}