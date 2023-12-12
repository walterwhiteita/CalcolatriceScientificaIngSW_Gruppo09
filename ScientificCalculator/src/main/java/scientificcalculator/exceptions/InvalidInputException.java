/*
    GRUPPO 09
    GIANMARCO GUERRIERO
    ANGELO DI MIERI
    BIAGIO DE MARTINO
    ANTONIO CARBONE
*/

package scientificcalculator.exceptions;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException() {
    }

    public InvalidInputException(String msg) {
        super(msg);
    }
}
