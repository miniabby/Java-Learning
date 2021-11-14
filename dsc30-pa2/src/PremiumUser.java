/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */

/**
 * The PremiumUser class extends the User class.
 * @author Kechen Zhao
 * @since 2020/01/21
 */

public class PremiumUser extends User {

    // instance variable
    private String customTitle;

    /**
     * This method calls the super class with the input parameters.
     * Also initializes the customTitle class variable which
     * is exclusive to the PremiumUser class.
     * @param /parameters are two strings that
     * represent username and bio respectively
     */
    public PremiumUser(String username, String bio) {
        super(username, bio);
        // initializes the customTitle
        customTitle = "Premium";
        // If the username or bio is null, throw an IllegalArgumentException.
        if (username == null || bio == null) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Fetches all messages from the log of the MessageExchange.
     * @param /parameter is an MessageExchange interface
     */
    public String fetchMessage(MessageExchange me) {
        // If input is null, throw an IllegalArgumentException.
        if (me == null) {
            throw new IllegalArgumentException();
        }
        // Throw an IllegalArgumentException if the input parameter is invalid.
        if (!(me instanceof MessageExchange)) {
            throw new IllegalArgumentException();
        }
        // get the total number of messages
        int numMessage = me.getLog().size();
        String fetchMessage = "";
        // fetch all messages
        for (int i = 0; i < numMessage; i++) {
            fetchMessage = fetchMessage + me.getLog().get(i).getContents() + "\n";
        }
        return fetchMessage;
    }

    /**
     * This method returns the customTitle and username.
     * @param /no parameter for this method
     */
    public String displayName() {
        return "<" + customTitle + "> " + username;
    }

    /**
     * This method Sets the customTitle variable to the new value.
     * @param /parameter is a string which represents the new title
     */
    public void setCustomTitle(String newTitle) {
        customTitle = newTitle;
    }
}
