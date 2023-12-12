/*
    GRUPPO 09
    GIANMARCO GUERRIERO
    ANGELO DI MIERI
    BIAGIO DE MARTINO
    ANTONIO CARBONE
*/

package scientificcalculator.exceptions;

public class UninitializedVariableException extends RuntimeException {

    public UninitializedVariableException() {
    }

    public UninitializedVariableException(String msg) {
        super(msg);
    }
}
