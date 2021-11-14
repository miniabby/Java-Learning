/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */
import java.time.LocalDate;

/**
 * The TextMessage class will ‘extend’ the abstract class Message.
 * @author Kechen Zhao
 * @since 2020/01/21
 */

public class TextMessage extends Message {

    // Error message to use in OperationDeniedException
    private static final String EXCEED_MAX_LENGTH =
            "Your input exceeded the maximum length limit.";

    // input validation criteria
    private static final int MAX_TEXT_LENGTH = 1000;

    /**
     * This constructor calls ‘super’ and
     * initialize contents with the argument text.
     * @param /parameter are a User sender and a String text
     */
    public TextMessage(User sender, String text) throws OperationDeniedException {
        super(sender);
        // If the sender or text is null, throw an IllegalArgumentException.
        if (sender == null || text == null) {
            throw new IllegalArgumentException();
        }
        // initialize contents with argument text
        this.contents = text;
        // If the length of text exceeds the maximum length limit (1000),
        // throw an OperationDeniedException with message EXCEED_MAX_LENGTH.
        if (text.length() > MAX_TEXT_LENGTH) {
            throw new OperationDeniedException(EXCEED_MAX_LENGTH);
        }
    }

    /**
     * This constructor returns a String in the form:
     * “SenderName [2020-01-15]: A sample text message.”
     * @param /no parameter for this method
     */
    public String getContents() {
        // use superclass method to get the user
        User sender = getSender();
        // use superclass method to get the date
        LocalDate date = getDate();
        String time = date.toString();
        return sender.displayName() + " [" + time + "]: " + contents;
    }

}
