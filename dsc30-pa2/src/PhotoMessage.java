/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */
import java.time.LocalDate;

/**
 * The PhotoMessage class will also ‘extend’ the abstract class Message.
 * @author Kechen Zhao
 * @since 2020/01/21
 */

public class PhotoMessage extends Message {

    // Error message to use in OperationDeniedException
    private static final String INVALID_INPUT =
            "The source path given cannot be parsed as photo.";

    // input validation criteria
    private static final String[] ACCEPTABLE_EXTENSIONS =
            new String[]{"jpg", "jpeg", "gif", "png", "tif"};

    // instance variable
    private String extension;

    /**
     * This constructor calls ‘super’,
     * initialize contents with the argument photoSource,
     * and make the file extension extracted from photoSource
     * to lowercase and store it to the variable extension.
     * @param /parameters are a User sender and a string
     * represents photoSource
     */
    public PhotoMessage(User sender, String photoSource) throws OperationDeniedException {
        super(sender);
        // null values cause IllegalArgumentException
        if (sender == null || photoSource == null) {
            throw new IllegalArgumentException();
        }
        // initialize contents with argument photoSource
        this.contents = photoSource;
        // make the string lower case to extract the extension
        String lowSource = contents.toLowerCase();
        extension = "";
        int leng = lowSource.length();
        for (int i = 0; i < leng - 1; i++) {
            if (lowSource.substring(i, i + 1).equals(".")) {
                extension = lowSource.substring(i + 1, leng);
            }
        }
        //invalid extension cause OperationDeniedException
        if (!extension.equals("jpg") && !extension.equals("jpeg")
                && !extension.equals("gif") && !extension.equals("png")
                && !extension.equals("tif")) {
            throw new OperationDeniedException(INVALID_INPUT);
        }
        // standard user cause OperationDeniedException
        if (!(sender instanceof PremiumUser)) {
            throw new OperationDeniedException(DENIED_USER_GROUP);
        }
    }

    /**
     * This constructor returns a String in the form:
     * “SenderName [2020-01-15]: Picture at image/example.tif”
     * @param /no parameter for this method
     */
    public String getContents() {
        // use superclass method to get the sender
        User sender = getSender();
        // use superclass method to get the date
        LocalDate date = getDate();
        String time = date.toString();
        return sender.displayName() + " [" + time + "]: " + "Picture at " + contents;
    }

    /**
     * This constructor returns the extension of a photo source
     * @param /no parameter for this method
     */
    public String getExtension() {
        return extension;
    }
}


