/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */
import java.util.ArrayList;

/**
 * The User class is the abstract class that
 * defines the functionality of a user in our messaging app.
 * @author Kechen Zhao
 * @since 2020/01/21
 */

public abstract class User {

    // Error message to use in OperationDeniedException
    protected static final String JOIN_ROOM_FAILED =
            "Failed to join the chat room.";

    // instance variables
    protected String username;
    protected String bio;
    protected ArrayList<MessageExchange> rooms;

    /**
     * This constructor initializes the three variables
     * that declared above
     * @param /parameters are a User sender and a string
     * represents bio, which is a brief introduction of the user
     */
    public User(String username, String bio) {
        // throw IllegalArgumentException when input is null
        if (username == null || bio == null) {
            throw new IllegalArgumentException();
        }
        // initialize the class variables
        this.username = username;
        this.bio = bio;
        this.rooms = new ArrayList<MessageExchange>();
    }

    /**
     * This method updates the class variable bio with a new one.
     * @param /parameter is a string newBio
     * which represents a new brief introduction
     */
    public void setBio(String newBio) {
        // throw IllegalArgumentException when input is null
        if (newBio == null) {
            throw new IllegalArgumentException();
        }
        // set new value to instance variable bio
        this.bio = newBio;
    }

    /**
     * This method Returns the bio of a user
     * @param /no parameter for this method
     */
    public String displayBio() {
        return bio;
    }

    /**
     * This method adds the user to the list of users
     * in the message exchange platform and
     * adds the platform to the list of rooms of this user.
     * @param /parameter is an MessageExchange interface
     */
    public void joinRoom(MessageExchange me) throws OperationDeniedException {
        // throw IllegalArgumentException for null value input
        if (me == null) {
            throw new IllegalArgumentException();
        }
        //If the room is already in the list of rooms for this user’s,
        // throw an OperationDeniedException with message JOIN_ROOM_FAILED.
        if (this.rooms.contains(me)) {
            throw new OperationDeniedException(JOIN_ROOM_FAILED);
        }
        // add user to the list of users
        ArrayList userList = me.getUsers();
        userList.add(username);
        // add the platform to the list of rooms of this user
        this.rooms.add(me);
    }

    /**
     * This method removes the message exchange platform
     * from the list of rooms that this user is a member of
     * and removes the user from the list of users r
     * ecorded in the MessageExchange object.
     * @param /parameter is an MessageExchange interface
     */
    public void quitRoom(MessageExchange me) {
        // throw IllegalArgumentException for null value input
        if (me == null) {
            throw new IllegalArgumentException();
        }
        // remove user to the list of users
        ArrayList userList = me.getUsers();
        userList.remove(username);
        // remove the platform to the list of rooms of this user
        this.rooms.remove(me);
    }

    /**
     * This method creates a new chat room
     * and add the user in the users to this room.
     * @param /parameter is an array list of users
     */
    public MessageExchange createChatRoom(ArrayList<User> users) {
        // create a new instance of ChatRoom
        ChatRoom chatroom = new ChatRoom();
        // throw IllegalArgumentException for null value input
        if (users == null) {
            throw new IllegalArgumentException();
        }
        // use for loop to add user in the user list to room
        // if a user cannot join the room
        // exception will be handled and proceed to next user
        for (int i = 0; i < users.size(); i++) {
            try {
                users.get(i).joinRoom(chatroom);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    /**
     * This method will record the message and
     * add this message to the chat room
     * @param /parameter is an array list of users
     */
    public void sendMessage(MessageExchange me, int msgType, String contents) {
        // throw IllegalArgumentException for null value input
        if (me == null || contents == null) {
            throw new IllegalArgumentException();
        }
        // create an instance of a message if it has the correct type
        // if not, throw IllegalArgumentException
        User thisUser = new StandardUser(username, bio);
        if (msgType == Message.TEXT) {
            try {
                Message message = new TextMessage(this, contents);
                me.recordMessage(message);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (msgType == Message.PHOTO) {
            try {
                Message message = new PhotoMessage(this, contents);
                me.recordMessage(message);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (msgType == Message.STICKER) {
            try {
                Message message = new StickerMessage(this, contents);
                me.recordMessage(message);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public abstract String fetchMessage(MessageExchange me);

    public abstract String displayName();
}
