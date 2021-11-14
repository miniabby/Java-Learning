/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */
import java.time.LocalDate;

/**
 * This abstract class is used to build messages of our messenger.
 * The message will have three categories (as three subclasses):
 * TextMessage, PhotoMessage, and StickerMessage.
 * These message instances will hold the sender of them and the contents of them.
 *
 * @author Kechen Zhao
 * @since 2020/01/21
 */

public abstract class Message {
    // Use these variable names as the msgType argument of sendMessage()
    // in user class
    public static final int TEXT    = 1000;
    public static final int PHOTO   = 1001;
    public static final int STICKER = 1002;

    // Error message to use in OperationDeniedException
    protected static final String DENIED_USER_GROUP =
            "This operation is disabled in your user group.";

    /* Declare instance variables */
    private LocalDate date;
    private User sender;
    protected String contents;

    /**
     * This constructor will set the sender and date fields.
     * @param /parameter is an instance of User
     */
    public Message(User sender) {
        // throw exception when sender is null
        if (sender == null) {
            throw new IllegalArgumentException();
        }
        // set sender and date fields
        this.sender = sender;
        this.date = LocalDate.now();
    }

    /**
     * Method will return the date of this message.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Method will return the sender of this message.
     */
    public User getSender() {
        return sender;
    }

    /**
     * This method will get the contents of the message
     */
    public abstract String getContents();

}
