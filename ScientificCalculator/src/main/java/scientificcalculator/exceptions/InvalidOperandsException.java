package scientificcalculator.exceptions;

/**
 *
 * @author angel
 */
public class InvalidOperandsException extends RuntimeException {

    /**
     * Creates a new instance of <code>InvalidOperandsException</code> without
     * detail message.
     */
    public InvalidOperandsException() {
    }

    /**
     * Constructs an instance of <code>InvalidOperandsException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidOperandsException(String msg) {
        super(msg);
    }
}
