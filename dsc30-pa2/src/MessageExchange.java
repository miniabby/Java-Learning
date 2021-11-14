import java.util.ArrayList;

/**
 * An interface that structures a message exchange service.
 */
public interface MessageExchange {

    /**
     * Method gets the log of messages stored.
     * @return an ArrayList of message log
     */
    ArrayList<Message> getLog();

    /**
     * Method gets a list of users joined.
     * @return an ArrayList of users joined
     */
    ArrayList<User> getUsers();

    /**
     * Method records a message to the log.
     * @param m message to record
     */
    void recordMessage(Message m);

}
