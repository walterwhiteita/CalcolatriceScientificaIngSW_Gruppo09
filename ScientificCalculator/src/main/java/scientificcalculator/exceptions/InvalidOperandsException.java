/*
    GRUPPO 09
    GIANMARCO GUERRIERO
    ANGELO DI MIERI
    BIAGIO DE MARTINO
    ANTONIO CARBONE
*/

package scientificcalculator.exceptions;

public class InvalidOperandsException extends RuntimeException {
    //Costruttore per InvalidOperandsException
    public InvalidOperandsException() {
    }
    //Costruttore per InvalidOperandsException a cui viene passata una String
    public InvalidOperandsException(String msg) {
        super(msg);
    }
}
