/*
    GRUPPO 09
    GIANMARCO GUERRIERO
    ANGELO DI MIERI
    BIAGIO DE MARTINO
    ANTONIO CARBONE
*/

package scientificcalculator.exceptions;

public class UninitializedVariableException extends RuntimeException {
    //Costruttore per UninitializedVariableException
    public UninitializedVariableException() {
    }
    //Costruttore per UninitializedVariableException a cui viene passa una String
    public UninitializedVariableException(String msg) {
        super(msg);
    }
}
