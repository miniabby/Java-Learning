/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */
import java.time.LocalDate;

/**
 * The StickerCourse class will also ‘extend’ the abstract class Message.
 * @author Kechen Zhao
 * @since 2020/01/21
 */

public class StickerMessage extends Message {

    // instance variable
    private String packName;

    /**
     * This constructor calls ‘super’.
     * Extract the name of a sticker pack and a sticker from stickerSource.
     * Initialize contents with the sticker name extracted,
     * and initialize packName with the sticker pack name extracted.
     * @param /parameters are a user sender and a string
     * represents sticker source.
     */
    public StickerMessage(User sender, String stickerSource) throws OperationDeniedException {
        super(sender);
        // null value input will cause IllegalArgumentException
        if (sender == null || stickerSource == null) {
            throw new IllegalArgumentException();
        }
        // standard user causes OperationDeniedException
        if (!(sender instanceof PremiumUser)) {
            throw new OperationDeniedException(DENIED_USER_GROUP);
        }
        // initialize contents with sticker name
        // initialize packName with pack name
        for (int i = 0; i < stickerSource.length() - 1; i++) {
            if (stickerSource.substring(i, i + 1).equals("/")) {
                contents = stickerSource.substring(i + 1, stickerSource.length());
                packName = stickerSource.substring(0, i);
            }
        }
    }

    /**
     * This constructor returns a String in the form:
     * “SenderName [2019-10-29]: Sticker [Questioning] from Pack [yourcraft-8]”
     * @param /no parameter for this method
     */
    public String getContents() {
        // use superclass method to get the sender
        User sender = getSender();
        // use superclass method to get the date
        LocalDate date = getDate();
        String time = date.toString();
        return sender.displayName() + " [" + time + "]: "
                + "Sticker [" + contents + "] " + "from Pack [" + packName + "]";
    }

    /**
     * This constructor returns the pack name of a sticker source
     * @param /no parameter for this method
     */
    public String getPackName() {
        return packName;
    }
}
