/**
 * Implementation of OperationDeniedException.
 */
public class OperationDeniedException extends Exception {

    /**
     * Initialize an OperationDeniedMessage.
     */
    public OperationDeniedException() {
        super();
    }

    /**
     * Initialize an OperationDeniedMessage with message.
     * @param s String exception message
     */
    public OperationDeniedException(String s) {
        super(s);
    }

}
