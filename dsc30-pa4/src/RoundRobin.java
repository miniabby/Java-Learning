/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */


/**
 * Implementation for Round Robin
 *
 * @author Kechen Zhao
 * @since 2020/02/04
 */
public class RoundRobin {

    // constants
    private static final int DEFAULT_QUANTUM = 3;
    private static final String TASK_HANDLED = "All tasks are already handled.";

    // instance variables
    private DoublyLinkedList<Task> waitlist, finished;
    private int quantum, burstTime, waitTime;

    /**
     * Add an element to the end of the list
     * @param toHandle a list of all tasks that needed to be handled
     * @throws IllegalArgumentException if no task need to be handled
     */
    public RoundRobin(Task[] toHandle) {
        if (toHandle == null || toHandle.length == 0) {
            throw new IllegalArgumentException();
        }
        // create a new DLL for waitlist
        waitlist = new DoublyLinkedList<Task>();
        for (int i = 0; i < toHandle.length; i++) {
            waitlist.add(i, toHandle[i]);
        }
        // initialize other variables
        finished = new DoublyLinkedList<Task>();
        this.quantum = DEFAULT_QUANTUM;
        burstTime = 0;
        waitTime = 0;
    }

    /**
     * Add an element to the end of the list
     * @param toHandle a list of all tasks that needed to be handled
     * @throws IllegalArgumentException if no task need to be handled
     */
    public RoundRobin(int quantum, Task[] toHandle) {
        if (quantum < 1 || toHandle == null || toHandle.length == 0) {
            throw new IllegalArgumentException();
        }
        // create a new DLL for waitlist
        waitlist = new DoublyLinkedList<Task>();
        for (int i = 0; i < toHandle.length; i++) {
            waitlist.add(i, toHandle[i]);
        }
        // initialize other variables
        finished = new DoublyLinkedList<Task>();
        this.quantum = quantum;
        burstTime = 0;
        waitTime = 0;
    }

    /**
     * Keep track of all tasks and calculate burst time and waste time
     * @return a string that contains the brust time, waste time
     * and the order of handled task
     */
    public String handleAllTasks() {
        // if there is no task in wait list
        // then all tasks handled
        if (waitlist.size() == 0) {
            return TASK_HANDLED;
        }
        while (waitlist.size() != 0) {
            // store the task at index 0
            Task currentTask = waitlist.get(0);
            for (int j = 0; j < quantum; j++) {
                boolean handled = currentTask.handleTask();
                // if after quantum units of time
                // current task still has remaining time
                // calculate the burst time and wait time
                if (handled) {
                    burstTime++;
                    waitTime = waitTime + waitlist.size() - 1;
                }
            }
            // if task is finished
            // add it to the finished list
            if (currentTask.isFinished()) {
                finished.add(currentTask);
            } else {
                // if not finish
                // add to the end of the wait list
                waitlist.add(currentTask);
            }
            // remove the current from the head of the list
            waitlist.remove(0);
        }
        // construct the string of finished task in order
        String taskOrder = finished.get(0).toString();
        for (int i = 1; i < finished.size(); i++) {
            String taskString = finished.get(i).toString();
            taskOrder = taskOrder + " -> " + taskString;
        }
        return "All tasks are handled within " + burstTime
                + " units of burst time and " + waitTime
                + " units of wait time. The tasks are finished in this order:\n"
                + taskOrder;
    }

    /**
     * Main method for testing.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Task[] test1 = {new Task("A",  3), new Task("B", 4), new Task("C", 4),
                        new Task("D", 12), new Task("E", 6), new Task("F", 3)};
        RoundRobin rr1 = new RoundRobin(test1); // Quantum: 3, ToHandle: test1
        System.out.println(rr1.handleAllTasks());   // Burst: 32, Wait: 86, Order: AFBCED
        System.out.println();
        System.out.println(rr1.handleAllTasks());   // TASK_HANDLED
        System.out.println();

        Task[] test2 = {new Task("A", 9), new Task("B", 8), new Task("C", 6),
                        new Task("D", 4), new Task("E", 4), new Task("F", 3)};
        RoundRobin rr2 = new RoundRobin(4, test2);  // Quantum: 4, ToHandle: test2
        System.out.println(rr2.handleAllTasks());   // Burst: 34, Wait: 123, Order: DEFBCA
        System.out.println();
        System.out.println(rr2.handleAllTasks());   // TASK_HANDLED
        System.out.println();

        Task[] test3 = {new Task("A", 7), new Task("B", 5), new Task("C", 3), new Task("D", 1),
                        new Task("E", 2), new Task("F", 4), new Task("G", 6), new Task("H", 8)};
        RoundRobin rr3 = new RoundRobin(test3);     // Quantum: 3, ToHandle: test3
        System.out.println(rr3.handleAllTasks());   // Burst: 36, Wait: 148, Order: CDEBFGAH
        System.out.println();
        System.out.println(rr3.handleAllTasks());   // TASK_HANDLED
        System.out.println();
    }
}
