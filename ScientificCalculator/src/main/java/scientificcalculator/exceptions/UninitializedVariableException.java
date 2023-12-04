package scientificcalculator.exceptions;

/**
 *
 * @author angel
 */
public class UninitializedVariableException extends RuntimeException {

    /**
     * Creates a new instance of <code>UninitializedVariableException</code>
     * without detail message.
     */
    public UninitializedVariableException() {
    }

    /**
     * Constructs an instance of <code>UninitializedVariableException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public UninitializedVariableException(String msg) {
        super(msg);
    }
}
