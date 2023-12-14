/*
    GRUPPO 09
    GIANMARCO GUERRIERO
    ANGELO DI MIERI
    BIAGIO DE MARTINO
    ANTONIO CARBONE
*/

package scientificcalculator.exceptions;

public class InvalidInputException extends RuntimeException {
    //Costruttore per InvalidInputException
    public InvalidInputException() {
    }
    //Costruttore per InvalidInputException a cui viene passata una String
    public InvalidInputException(String msg) {
        super(msg);
    }
}
