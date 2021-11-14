/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */

/**
 * The StandardUser class extends the User class.
 * @author Kechen Zhao
 * @since 2020/01/21
 */
public class StandardUser extends User {
    // Message to append when fetching non-text message
    private static final String FETCH_DENIED_MSG =
            "This message cannot be fetched because you are not a premium user.";

    private static final int FETCH_RATIO = 1 / 10;

    /**
     * Calls the super class with the input parameters.
     * @param /parameters are two strings that
     * represent username and bio respectively
     */
    public StandardUser(String username, String bio) {
        super(username, bio);
        // If the username or bio is null, throw an IllegalArgumentException.
        if (username == null || bio == null) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * For standard users, this method only fetch the latest
     * 1/10 of all the messages in the message exchange.
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
        int numFetch = numMessage * FETCH_RATIO;
        String fetchMessage = "";
        for (int i = 0; i < numFetch; i++) {
            // check the type of each message
            if (!(me.getLog().get(i) instanceof TextMessage)) {
                fetchMessage = fetchMessage + FETCH_DENIED_MSG + "\n";
            } else {
                fetchMessage = fetchMessage + me.getLog().get(i).getContents() + "\n";
            }
        }

        return fetchMessage;
    }

    /**
     * This method returns the username.
     * @param /no parameter for this method
     */
    public String displayName() {
        return username;
    }
}
