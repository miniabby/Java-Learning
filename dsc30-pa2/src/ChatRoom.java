/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */

import java.util.ArrayList;

/**
 * The ChatRoom class implements the MessageExchange interface.
 * The ChatRoom class is a simulator of a chat room that
 * moderates the communications between users
 * by storing logs of the messages,
 * and recording the users that are in a particular chat room.
 * @author Kechen Zhao
 * @since 2020/01/21
 */
public class ChatRoom implements MessageExchange {

    // instance variables
    private ArrayList<User> users;
    private ArrayList<Message> log;

    /**
     * This method initialize the above class variables
     * @param /no parameter for this method
     */
    public ChatRoom() {
        this.users = new ArrayList<User>();
        this.log = new ArrayList<Message>();
    }

    /**
     * Method returns the log of this chat room.
     * @param /no parameter for this method
     */
    public ArrayList<Message> getLog() {
        return log;
    }

    /**
     * Method returns the users of this chat room.
     * @param /no parameter for this method
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Method adds a new message to the log of this chat room.
     * @param /parameter is m with message type
     */
    public void recordMessage(Message m) {
        log.add(m);
    }
}
