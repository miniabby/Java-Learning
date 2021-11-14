/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */

import org.junit.*;
import static org.junit.Assert.*;

// Packages for implementations
import java.time.LocalDate;

/**
 * This class will contain all the test case for PA2
 * @author Kechen Zhao
 * @since 2020/01/21
 */
public class MessengerApplicationTest {


    /*
      Messages defined in starter code.
     */
    private static final String INVALID_INPUT =
            "The source path given cannot be parsed as photo.";
    private static final String EXCEED_MAX_LENGTH =
            "Your input exceeded the maximum length limit.";
    protected static final String DENIED_USER_GROUP =
            "This operation is disabled in your user group.";


    /*
      declare static variables
     */
    static PremiumUser nabi, yuxuan;
    static StandardUser dragon;
    static MessageExchange room;
    static LocalDate date = LocalDate.now();


    /*
      @Before method always run before executing every @Test method. It can be
      used for initializations.
     */
    @Before
    public void setup() {
        nabi = new PremiumUser("Nabi", "CSE Student");
        yuxuan = new PremiumUser("Yuxuan", "DSC Tutor");
        dragon = new StandardUser("Recursive Dragon", "on a trip");
        room = new ChatRoom();
    }

    // test case for getDate()
    @Test
    public void testgetDate() {
        assertEquals(LocalDate.now(), date);
    }

    // test case for TextMessage(User sender, String text) throws OperationDeniedException
    @Test (expected = IllegalArgumentException.class)
    public void testTextMessage() throws OperationDeniedException {
        TextMessage text = new TextMessage(nabi, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test2TextMessage() throws OperationDeniedException {
        TextMessage text = new TextMessage(null, null);
    }

    @Test (expected = OperationDeniedException.class)
    public void test3TextMessage() throws OperationDeniedException {
        String repeat = "repeat";
        for (int i = 0; i < 1000; i++) {
            repeat = repeat + "repeat";
        }
        TextMessage text = new TextMessage(nabi, repeat);
    }

    // test case for getContents
    @Test
    public void testgetTMContent() throws OperationDeniedException {
        TextMessage textMessage1 = new TextMessage(nabi, "hello");
        assertEquals("<Premium> Nabi [2020-01-21]: hello", textMessage1.getContents());
        TextMessage textMessage2 = new TextMessage(dragon, "hello");
        assertEquals("Recursive Dragon [2020-01-21]: hello", textMessage2.getContents());
        TextMessage textMessage3 = new TextMessage(yuxuan, "hello");
        assertEquals("<Premium> Yuxuan [2020-01-21]: hello", textMessage3.getContents());
    }

    // test case for PhotoMessage
    @Test (expected = IllegalArgumentException.class)
    public void testPhotoMessage() throws OperationDeniedException {
        PhotoMessage photoMessage = new PhotoMessage(null, "hello.gif");
    }

    @Test (expected = IllegalArgumentException.class)
    public void test2PhotoMessage() throws OperationDeniedException {
        PhotoMessage photoMessage = new PhotoMessage(nabi, null);
    }

    @Test (expected = OperationDeniedException.class)
    public void test3PhotoMessage() throws OperationDeniedException {
        PhotoMessage photoMessage = new PhotoMessage(dragon, "hello.gif");
        assertEquals(DENIED_USER_GROUP, photoMessage);
    }

    @Test (expected = OperationDeniedException.class)
    public void test4PhotoMessage() throws OperationDeniedException {
        PhotoMessage photoMessage = new PhotoMessage(nabi, "hello");
        assertEquals(INVALID_INPUT, photoMessage);
    }


    // test case for getExtension()
    @Test
    public void testgetExtension() throws OperationDeniedException {
        PhotoMessage pm1 = new PhotoMessage(nabi, "hello.png");
        assertEquals("png", pm1.getExtension());
        PhotoMessage pm2 = new PhotoMessage(nabi, "hello.jpeg");
        assertEquals("jpeg", pm2.getExtension());
        PhotoMessage pm3 = new PhotoMessage(nabi, "hello.GIF");
        assertEquals("gif", pm3.getExtension());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test2getExtension() throws OperationDeniedException {
        PhotoMessage photoMessage = new PhotoMessage(nabi, null);
    }


    //test case for getContents()
    @Test
    public void testgetPMContents() throws OperationDeniedException {
        PhotoMessage photoMessage1 = new PhotoMessage(nabi, "hello.gif");
        assertEquals("<Premium> Nabi [2020-01-21]: Picture at hello.gif",
                photoMessage1.getContents());
        PhotoMessage photoMessage2 = new PhotoMessage(yuxuan, "hello.jpeg");
        assertEquals("<Premium> Yuxuan [2020-01-21]: Picture at hello.jpeg",
                photoMessage2.getContents());
    }

    @Test (expected = OperationDeniedException.class)
    public void testgetPMContentsThrowsODM() throws OperationDeniedException {
        PhotoMessage photoMessage = new PhotoMessage(dragon, "hello.GIF");
        assertEquals("Recursive Dragon [2020-01-21]: Picture at hello.GIF",
                photoMessage.getContents());
    }

    @Test
    public void test1getPMContents() throws OperationDeniedException {
        PhotoMessage photoMessage = new PhotoMessage(nabi, "hello.gif");
        assertEquals("<Premium> Nabi [2020-01-21]: Picture at hello.gif",
                photoMessage.getContents());
    }

    //test case for StickerMessage
    @Test (expected = IllegalArgumentException.class)
    public void testStickerMessage() throws OperationDeniedException {
        StickerMessage stickerMessage = new StickerMessage(nabi, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test2StickerMessage() throws OperationDeniedException {
        StickerMessage stickerMessage = new StickerMessage(null, "name/name");
    }

    @Test (expected = OperationDeniedException.class)
    public void test3StickerMessage() throws OperationDeniedException {
        StickerMessage stickerMessage = new StickerMessage(dragon, "name/name");
        assertEquals(DENIED_USER_GROUP, stickerMessage);
    }

    //test case for getPackName()
    @Test
    public void testgetPackName() throws OperationDeniedException {
        StickerMessage stickermessage = new StickerMessage(nabi, "packname/stickername");
        assertEquals("packname", stickermessage.getPackName());
        StickerMessage stickermessage2 = new StickerMessage(nabi, "Hello/World");
        assertEquals("Hello", stickermessage2.getPackName());
        StickerMessage stickermessage3 = new StickerMessage(nabi, "[][][]/()()()");
        assertEquals("[][][]", stickermessage3.getPackName());
    }

    //test case for getContents()
    @Test
    public void testSMgetContents() throws OperationDeniedException {
        StickerMessage stickermessage = new StickerMessage(nabi, "packname/stickername");
        assertEquals("<Premium> Nabi [2020-01-21]: Sticker [stickername] from Pack "
                + "[packname]", stickermessage.getContents());
        StickerMessage stickermessage2 = new StickerMessage(yuxuan, "Hello/World");
        assertEquals("<Premium> Yuxuan [2020-01-21]: Sticker [World] from Pack "
                + "[Hello]", stickermessage2.getContents());
        StickerMessage stickermessage3 = new StickerMessage(nabi, "[][][]/()()()");
        assertEquals("<Premium> Nabi [2020-01-21]: Sticker [()()()] from Pack "
                + "[[][][]]", stickermessage3.getContents());
    }

    // test case for joinRoom
    @Test (expected = IllegalArgumentException.class)
    public void testjoinRoom() throws OperationDeniedException {
        nabi.joinRoom(null);
    }

    // test case for createChatRoom
    @Test (expected = IllegalArgumentException.class)
    public void testcreateChatRoom() {
        nabi.createChatRoom(null);
    }

    // test case for sendMessage
    @Test (expected = IllegalArgumentException.class)
    public void testsendMessage() {
        nabi.sendMessage(room, 101, "hello");
    }

    @Test (expected = IllegalArgumentException.class)
    public void test2sendMessage() {
        nabi.sendMessage(null, 1001, "hello");
    }

    @Test (expected = IllegalArgumentException.class)
    public void test3sendMessage() {
        nabi.sendMessage(room, 1001, null);
    }

    //test case for fetchMessage
    @Test (expected = IllegalArgumentException.class)
    public void testfetchMessage() {
        nabi.fetchMessage(null);
    }

    //test case for displayName
    @Test
    public void testdislpayName() {
        assertEquals("<Premium> Nabi", nabi.displayName());
        assertEquals("<Premium> Yuxuan", yuxuan.displayName());
        assertEquals("Recursive Dragon", dragon.displayName());
    }

    // test case for setBio
    @Test
    public void testSetBio() {
        nabi.setBio("DSC 30");
        assertEquals("DSC 30", nabi.displayBio());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test2SetBio() {
        User user1 = new StandardUser("Abigail", null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test3SetBio() {
        User user2 = new StandardUser(null, "hello");
    }

    //test case for displayBio()
    @Test
    public void test1displayBio() {
        User user1 = new StandardUser("Abigail", "hello");
        assertEquals("hello", user1.displayBio());
    }

    @Test
    public void test1DisplayBio() {
        assertEquals("CSE Student", nabi.displayBio());
        assertEquals("DSC Tutor", yuxuan.displayBio());
        assertEquals("on a trip", dragon.displayBio());
    }

    // test case for PremiumUser
    @Test (expected = IllegalArgumentException.class)
    public void testPremiumUserThrowsIAE() {
        PremiumUser marina = new PremiumUser("Marina", null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testStandardUserThrowsIAE() {
        StandardUser marina = new StandardUser(null, null);
    }


    /*
      An example of testing exception with exception message.
     */
    @Test
    public void testPhotoMessageThrowsODE() {
        try {
            PhotoMessage pm = new PhotoMessage(nabi, "PA02ExampleTest.java");
            assertTrue(false);
            // If the constructor does not throw the exception we want, this assert
            // will be executed, and it will raise an assertion error to indicate
            // the test is failed.
        } catch (OperationDeniedException ode) {
            assertEquals(INVALID_INPUT, ode.getMessage());
        }
    }


    /*
    ============================= The "best way" =============================
    // (1) At the top of the file:
    import org.junit.rules.ExpectedException;

    // (2) Declare the following statement (once for the entire file):
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // (3) Write test method in this format:
    @Test
    public void testPhotoMessageThrowsODE() throws OperationDeniedException {
        // expected type and message of exception
        thrown.expect(OperationDeniedException.class);
        thrown.expectMessage(INVALID_INPUT);

        // method call that will throw an exception
        PhotoMessage pm = new PhotoMessage(nabi, "PhotoMessage.java");
    }
    ==========================================================================
    */


    /*
      An example of testing methods with complicated logic.
     */
    @Test
    public void testFetchMessage() {
        // test fetching log with full text messages
        nabi.sendMessage(room, Message.TEXT, "My name is Nabi");
        yuxuan.sendMessage(room, Message.TEXT, "My name is Yuxuan");
        dragon.sendMessage(room, Message.TEXT, "Roar!");

        String expectedPremium1 =
                        "<Premium> Nabi [" + date + "]: My name is Nabi\n"
                        + "<Premium> Yuxuan [" + date + "]: My name is Yuxuan\n"
                        + "Recursive Dragon [" + date + "]: Roar!\n";
        assertEquals(expectedPremium1, nabi.fetchMessage(room));    // ... of premium user

        // test fetching log with all kinds of messages
        for (int i = 1; i <= 5; i++) {
            dragon.sendMessage(room, Message.TEXT, "Spam #" + i);
        }
        for (int i = 1; i <= 3; i++) {
            yuxuan.sendMessage(room, Message.PHOTO, "images/IMG_000" + i + ".jpg");
        }
        for (int i = 1; i <= 3; i++) {
            nabi.sendMessage(room, Message.STICKER, "nabi-selfies/serialNo" + i);
        }

        String expectedPremium2 = expectedPremium1 + "";
        for (int i = 1; i <= 5; i++) {
            expectedPremium2 += ("Recursive Dragon [" + date + "]: Spam #" + i + "\n");
        }
        for (int i = 1; i <= 3; i++) {
            expectedPremium2 += ("<Premium> Yuxuan [" + date + "]: Picture at images/IMG_000"
                    + i + ".jpg\n");
        }
        for (int i = 1; i <= 3; i++) {
            expectedPremium2 += ("<Premium> Nabi [" + date + "]: Sticker [serialNo"
                    + i + "] from Pack [nabi-selfies]\n");
        }
        assertEquals(expectedPremium2, yuxuan.fetchMessage(room));  // ... of premium user
    }


    /*
      An example simulating an empty log in the ChatRoom class.
     */
    @Test
    public void test1FetchNoMessage() {
        String messageResults = "";
        assertEquals(messageResults, nabi.fetchMessage(room));
        assertEquals(messageResults, yuxuan.fetchMessage(room));
    }

}
