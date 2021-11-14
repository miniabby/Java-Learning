/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * Deque Class.
 * A class of a deque implemented using a "circular" array.
 * @author Kechen Zhao
 */
public class Deque {

    private ArrayList list; // Stores the elements
    private int head; // Store the index of first element
    private int tail; // Store the index of last element
    private int size; // Store the size of the deque
    private int DEFAULT_SIZE = 5; // declare the default size
    private int capacity; // Store the maximum capacity of array list

    /**
     * Default Deque constructor.
     * Creates a Deque Object
     * @throws IllegalArgumentException
     */
    public Deque() throws IllegalArgumentException {
        // set the list to be a new array list with default size 5
        // and all its values are null
        list = new ArrayList<Integer>(Collections.nCopies(DEFAULT_SIZE, null));
        // since there is no int in the list
        // set the size to 0
        size = 0;
        capacity = DEFAULT_SIZE;
        // initialize head, tail
        head = 0;
        tail = 0;
    }

    /**
     * Deque constructor.
     * Creates a Deque Object
     * @param cap - capacity of list
     * @throws IllegalArgumentException - if capacity is negative.
     */
    public Deque(int cap) throws IllegalArgumentException {
        // initialize Capacity with cap
        capacity = cap;
        // throw IllegalArgumentException for cap < 0
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        // set the list to be a new array list with the size given
        // and all its values are null
        list = new ArrayList<Integer>(Collections.nCopies(capacity, null));
        // set the size to zero since there is no int in list
        size = 0;
        // initialize head, tail and size
        if (capacity >= 1) {
            head = list.indexOf(head);
            tail = list.indexOf(tail);
        }
    }

    /**
     * Capacity method.
     * Returns the capacity of the Deque, that is,
     * the maximum number of objects it can hold.
     * @return the capacity of the list
     */
    public int capacity() {
        return capacity;
    }

    /**
     * Size method.
     * Returns the number of elements in the Deque.
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * Is empty method.
     * Returns if the Deque is empty.
     * @return if the Deque is empty.
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Is full method.
     * Returns if the Deque is full.
     * @return if the Deque is full.
     */
    public boolean isFull() {
        if (size == capacity) {
            return true;
        }
        return false;
    }

    /**
     * Add Front Method.
     * Adds the specified element to the front the Deque.
     * @param i - the element to add to the front of the list
     * @return true if adding was successful, false if not
     * @throws NullPointerException if the specified element is null
     * and size is less than capacity
     */
    public boolean addFront(Integer i) throws NullPointerException {
        // throw NullPointerException for null input
        if (i == null) {
            throw new NullPointerException();
        }
        // check whether Deque is full or not
        if (isFull()) {
            return false;
        } else if (isEmpty()) {
            // set the index of both head and tail
            // as the first element if this list is empty
            head = 0;
            tail = 0;
        } else { // move the index of head one step backward
            if (head == 0) {
                head = capacity - 1;
            } else {
                head = head - 1;
            }
        }
        // insert the new element
        list.set(head, i);
        // increase the size by one
        size = size + 1;
        return true;
    }

    /**
     * Add Back Method.
     * Adds the specified element to the back of Deque.
     * Returns true if successful. False if not.
     * @param i - the new element to add to the back of the list
     * @return true if adding was successful, false if not
     * @throws NullPointerException if the specified element is null
     * and size is less than capacity
     */
    public boolean addBack(Integer i) throws NullPointerException {
        // throw NullPointerException for null input
        if (i == null) {
            throw new NullPointerException();
        }
        // check whether Deque if  full or not
        if (isFull()) {
            return false;
        } else if (isEmpty()) {
            // set the index of both head and tail
            // as the first element if this list is empty
            head = 0;
            tail = 0;
        } else { // move the index of tail one step forward
            if (tail == capacity - 1) {
                tail = 0;
            } else {
                tail = tail + 1;
            }
        }
        // insert the new element
        list.set(tail, i);
        // increase the size by one
        size = size + 1;
        return true;
    }

    /**
     * Remove Front Method.
     * Removes the element at the front of Deque.
     * Returns the element removed or returns null if there is no element.
     * @return  the element removed, or null if the size was zero.
     */
    public Integer removeFront() {
        // set the index of removed element
        int removeIndex = 0;
        if (isEmpty()) {
            return null;
        }
        // if head is at the end of the array list
        // move the head pointer to the start of the list
        if (head == capacity - 1) {
            head = 0;
            removeIndex = capacity - 1;
        } else { // move the index of head one step backward
            head = head + 1;
            removeIndex = head - 1;
        }
        // decrease the size by one
        size = size - 1;
        return (Integer) list.get(removeIndex);
    }

    /**
     * Remove Back Method.
     * Removes the element at the back of Deque.
     * Returns the element removed or returns null if there is no element.
     * @return  the element removed, or null if the size was zero.
     */
    public Integer removeBack() {
        int removeIndex = 0;
        if (isEmpty()) {
            return null;
        }
        // if tail is at the beginning of the array list
        // move the tail pointer to the end of the list
        if (tail == 0) {
            tail = capacity - 1;
            removeIndex = 0;
        } else { // move the index of tail one step backward
            tail = tail - 1;
            removeIndex = tail + 1;
        }
        // decrease the size by one
        size = size - 1;
        return (Integer) list.get(removeIndex);
    }

    /**
     * Peek Front Method.
     * Returns the element at the front of the Deque
     * or null if such element does not exist.
     * @return the element at the front or null if the size was zero.
     */
    public Integer peekFront() {
        if (isEmpty()) {
            return null;
        }
        return (Integer) list.get(head);
    }

    /**
     * Peek Back Method.
     * Returns the element at the back of the Deque
     * or null if such element does not exist.
     * @return the element at the back or null if the size was zero.
     */
    public Integer peekBack() {
        if (isEmpty()) {
            return null;
        }
        return (Integer) list.get(tail);
    }
}
