/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */

/**
 * MyStack class.
 * Implements Stack using MyQueue.
 * @author Kechen Zhao
 */
public class MyStack {

    private MyQueue list;

    /** Constructor for a MyStack object, using default MyQueue */
    public MyStack() {
        list = new MyQueue();
    }

    /** Constructor for a MyStack object, using MyQueue */
    public MyStack(int maxCap) {
        list = new MyQueue(maxCap);
    }

    /**
     * Returns the capacity of this Stack, that is, the maximum number of
     * elements it can hold.
     *
     * @return the capacity of this Stack
     */
    public int capacity() {
        return list.capacity();
    }

    /**
     * Returns the number of elements in this Stack.
     *
     * @return the number of elements in this Stack
     */
    public int size() {
        return list.size();
    }

    /**
     * Returns whether or not the Stack is empty.
     * @return whether or not the Stack is empty.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns whether or not the Stack is full.
     * @return whether or not the Stack is full.
     */
    public boolean isFull() {
        return list.isFull();
    }

    /**
     * Adds the specified element to the top of this Stack.
     *
     * @param i the element to add to the stack
     * @return true if the element was added, else false.
     * @throws NullPointerException if the specified element is null,
     * and size is less than capacity
     * I interpret "top of the stack" as "head of the queue"
     */
    public boolean push(Integer i) {
        if (i == null) {
            throw new NullPointerException();
        }
        // create a stack that has the same capacity as list
        int stackCapacity = list.capacity();
        // store the initial size of list
        int listSize = list.size();
        if (listSize == stackCapacity) {
            return false;
        }
        MyQueue stack = new MyQueue(stackCapacity);
        // enqueue the integer to this new queue
        // so that this element will be at the head
        stack.enqueue(i);
        if (!(list.isEmpty())) {
            for (int j = 0; j < listSize; j++) {
                // remove the remaining elements from head
                int element  = list.dequeue();
                // enqueue the element to the tail
                stack.enqueue(element);
            }
        }
        list = stack;
        return true;
    }

    /**
     * Removes the element at the top of this Stack.
     *
     * @return  the element removed, or null if the size was zero.
     */
    public Integer pop() {
        return list.dequeue();
    }

    /**
     * Returns the element at the top of this Stack,
     * or null if there was no such element.
     *
     * @return the element at the top, or null if the size was zero.
     */
    public Integer peek() {
        return list.peek();
    }
}
