/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */

/**
 * Implement a fitting room queue using Deque.
 * @author Kechen Zhao
 */

public class BookstoreFittingRoom {

    private static MyQueue customersQueue; // use this to form the line for customers
    private static MyQueue[] changingRooms; // use array of queues to hold the fitting rooms
    private static int numberOfItems = 3;
    private static int setUpTime = 1;

    /**
     * Main method to run simulations from.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        int[][] customer1 = {{1, 0, 4}, {0, 2, 0}, {0, 1, 2}, {3, 2, 0}};
        String output1 = timeInfo(customer1, 2, 20);
        System.out.println(output1);

        String output2 = timeInfo(customer1, 2, 22);
        System.out.println(output2);

        String output3 = timeInfo(customer1, 4, 10);
        System.out.println(output3);

        int[][] customer2 = {{1, 1, 2}, {1, 2, 0}, {1, 1, 5}, {4, 0, 0}, {1, 1, 0}, {3, 2, 0}};
        String output4 = timeInfo(customer2, 1, 35);
        System.out.println(output4);

        String output5 = timeInfo(customer2, 3, 14);
        System.out.println(output5);

        String output6 = timeInfo(customer2, 3, 20);
        System.out.println(output6);

        String output7 = timeInfo(customer2, 4, 18);
        System.out.println(output7);

        String output8 = timeInfo(customer2, 4, 20);
        System.out.println(output8);

        String output9 = timeInfo(customer2, 2, 15);
        System.out.println(output9);

        int[][] customer3 = {{1, 2, 1}, {2, 2, 0}, {1, 0, 2}};
        String output10 = timeInfo(customer3, 2, 10);
        System.out.println(output10);

        int[][] customer4 = {};
        String output11 = timeInfo(customer4, 2, 15);
        System.out.println(output11);
    }

    /**
     * Returns a string that contains information about total time
     * for checking out all customers and changing room idle time.
     * @param customers the customer queue
     * @param numberOfChangingRooms number of changing rooms opened
     * @param closingTime amount of time the store is open
     * @return a string that contains information about total time
     *         for checking out all customers and changing room idle time.
     */
    public static String timeInfo(int[][] customers, int numberOfChangingRooms, int closingTime) {
        int totalTime = closingTime;
        int idleTime = 0;
        int wasteTime = 0;
        // use array of queues to hold the fitting rooms
        changingRooms = new MyQueue[numberOfChangingRooms];
        if (customers.length == 0) {
            idleTime = closingTime;
            return "With " + numberOfChangingRooms + " rooms, the total time "
                    + "for everyone to try on their items was " + totalTime
                    + " time units with idle time of " + idleTime + " time units "
                    + "and wasted time of " + wasteTime + " time units";
        }
        for (int i = 0; i < numberOfChangingRooms; i++) {
            MyQueue queue = new MyQueue(closingTime);
            changingRooms[i] = queue;
        }
        // get the number of customers
        int numberOfCustomers = customers.length;
        // create a queue with the capacity is equal to
        // the number of customers
        customersQueue = new MyQueue(numberOfCustomers);
        // calculate the time for each customer
        // and add the time to the customerQueue
        for (int i = 0; i < numberOfCustomers; i++) {
            int time = setUpTime;
            for (int j = 0; j < numberOfItems; j++) {
                time = time + customers[i][j] * (j + 1);
            }
            customersQueue.enqueue(time);
        }
        // locate the first numberOfChangingRooms customers to each fitting room
        // then locate the following customers to the room that have the smallest size
        for (int i = 0; i < numberOfChangingRooms; i++) {
            int currentCustomerTime = customersQueue.dequeue();
            if (currentCustomerTime > closingTime) {
                wasteTime = wasteTime + currentCustomerTime;
            } else {
                for (int j = 0; j < currentCustomerTime; j++) {
                    // enqueue the queue that represent this room
                    // which means that these amount of time
                    // has been used
                    changingRooms[i].enqueue(1);
                }
            }
        }
        // find the current number of customers in line
        int currentNumberOfCustomer = customers.length - numberOfChangingRooms;
        // iterate through the customers
        for (int i = 0; i < currentNumberOfCustomer; i++) {
            // store their time
            int currentCustomerTime = customersQueue.dequeue();
            // find the empty room for them
            MyQueue currentRoom = findFirstEmptyChangingRoom();
            // if the room does not have enough time for this customer
            if (currentCustomerTime > (currentRoom.capacity() - currentRoom.size())) {
                // add the time to wasted time
                wasteTime = wasteTime + currentCustomerTime;
            } else {
                // enqueue that room to represent that
                // these amount of time is occupied
                for (int j = 0; j < currentCustomerTime; j++) {
                    // enqueue the queue that represent this room
                    // which means that these amount of time
                    // has been used
                    currentRoom.enqueue(1);
                }
            }
        }
        if (customersQueue.size() == 0) {
            for (int i = 0; i < numberOfChangingRooms; i++) {
                idleTime = idleTime + (changingRooms[i].capacity() - changingRooms[i].size());
            }
        }

        return "With " + numberOfChangingRooms + " rooms, the total time "
                + "for everyone to try on their items was " + totalTime
                + " time units with idle time of " + idleTime + " time units "
                + "and wasted time of " + wasteTime + " time units";
    }

    /**
     * Helper method to find the first empty changing room.
     * @return first empty changing room
     * since in timeInfo() I don't need this
     * helper function to return null
     * I changed the functionality of this helper function
     * to return only the first empty room
     */
    private static MyQueue findFirstEmptyChangingRoom() {
        // find the size of each fitting room
        // the one has the smallest size is the first empty room
        int minimumSize = Integer.MAX_VALUE;
        MyQueue firstEmptyRoom = changingRooms[0];
        for (int i = 0; i < changingRooms.length; i++) {
            if (changingRooms[i].size() < minimumSize) {
                minimumSize = changingRooms[i].size();
                firstEmptyRoom = changingRooms[i];
            }
        }
        return firstEmptyRoom;
    }

    /**
     * Helper method to determine if the shop is empty
     * @return true if the whole shop is empty
     * !NOTE: this method is not used in timeInfo()
     * My timeInfo() will automatically stop when
     * there is no customer in line
     */
    private static boolean storeIsEmpty() {
        if (customersQueue.size() == 0) {
            return true;
        }
        return false;
    }

}

