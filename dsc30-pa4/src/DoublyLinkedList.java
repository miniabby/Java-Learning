/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */

import java.util.AbstractList;

/**
 * Doubly-Linked List Implementation
 *
 * @author Kechen Zhao
 * @since 2020/01/29
 */
public class DoublyLinkedList<T> extends AbstractList<T> {
    private int nelems; // size, number of nodes in the list
    private Node head; // no value, next field is the start of list
    private Node tail; // no value, previous field is the end of list
    private int indexShifting = 1;

    /**
     * Node for chaining together to create a linked list
     */
    protected class Node {
        T data; // contains the information stored in this position
        Node next; // a reference to the next node
        Node prev; // a reference to the previous node

        /**
         * Constructor to create singleton Node
         */
        private Node(T element) {
            data = element;
        }

        /**
         * Constructor to create singleton link it between previous and next
         *
         * @param element  Element to add, can be null
         * @param nextNode successor Node, can be null
         * @param prevNode predecessor Node, can be null
         */
        private Node(T element, Node nextNode, Node prevNode) {
            data = element;
            next = nextNode;
            prev = prevNode;
        }

        /**
         * Set the element
         *
         * @param element new element
         */
        public void setElement(T element) {
            data = element;
        }

        /**
         * Accessor to get the Nodes Element
         */
        public T getElement() {
            return data;
        }

        /**
         * Set the next node in the list
         *
         * @param n new next node
         */
        public void setNext(Node n) {
            next = n;
        }

        /**
         * Get the next node in the list
         *
         * @return the successor node
         */
        public Node getNext() {
            return next;
        }

        /**
         * Set the previous node in the list
         *
         * @param p new previous node
         */
        public void setPrev(Node p) {
            prev = p;
        }


        /**
         * Accessor to get the prev Node in the list
         *
         * @return predecessor node
         */
        public Node getPrev() {
            return prev;
        }

        /**
         * Remove this node from the list.
         * Update previous and next nodes
         */
        public void remove() {
            next = null;
            prev = null;
        }
    }

    /**
     * Creates a new, empty doubly-linked list.
     */
    public DoublyLinkedList() {
        // complete default constructor
        // create dummy head and tail
        head = new Node(null);
        tail = new Node(null);
        head.setNext(tail);
        tail.setPrev(head);
        // list is empty
        nelems = 0;
    }

    /**
     * Add an element to the end of the list
     * @param element data to be added
     * @return whether or not the element was added
     * @throws NullPointerException if data received is null
     */
    @Override
    public boolean add(T element) throws NullPointerException {
        //implementation of adding the new data
        if (element == null) {
            throw new NullPointerException();
        }
        // create the added node
        Node addedNode = new Node(element);
        // add the node before tail
        addedNode.setNext(tail);
        // find the last node
        Node prevNode = head;
        for (int i = 0; i < nelems; i++) {
            prevNode = prevNode.getNext();
        }
        prevNode.setNext(addedNode);
        addedNode.setPrev(prevNode);
        nelems = nelems + 1;
        return true;
    }


    /**
     * Adds an element to a certain index in the list, shifting exist elements
     * create room. Does not accept null values.
     * @param index
     * @param element data to be added at index position
     * @throws NullPointerException if data received is null
     * @throws IndexOutOfBoundsException for index for invalid index
     */
    @Override
    public void add(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        }
        // increase the index by one since head is at index 0
        index = index + indexShifting;
        if (index > nelems + 1 || index <= 0) {
            throw new IndexOutOfBoundsException();
        }
        // create the node
        Node addedNode = new Node(element);
        Node prevNode = head;
        Node nextNode = head;
        for (int i = 0; i < index - 1; i++) {
            prevNode = prevNode.getNext();
        }
        for (int i = 0; i < index; i++) {
            nextNode = nextNode.getNext();
        }
        // call super class method to add the element
        // to specific index position
        prevNode.setNext(addedNode);
        nextNode.setPrev(addedNode);
        addedNode.setPrev(prevNode);
        addedNode.setNext(nextNode);
        nelems = nelems + 1;
    }

    /**
     * Clear the linked list
     */
    @Override
    public void clear() {
        super.clear();
        nelems = 0;
    }

    /**
     * Determine if the list contains the data element anywhere in the list.
     * @param element data is contained in the list or not
     * @return whether or not the element is contained
     */
    @Override
    public boolean contains(Object element) {
        T data = (T) element;
        Node currentNode = head;
        for (int i = 0; i < nelems; i++) {
            currentNode = currentNode.getNext();
            if (currentNode.getElement() == data) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves the element stored with a given index on the list.
     * @param index specify the target node at that index position
     * @return return the data of that node
     * @throws IndexOutOfBoundsException if index is invalid
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        // increase the index by one since head is at index 0
        index = index + indexShifting;
        if (index > nelems || index <= 0) {
            throw new IndexOutOfBoundsException();
        }
        Node targetNode = head;
        // use loop to get the target node
        for (int i = 0; i < index; i++) {
            targetNode = targetNode.getNext();
        }
        return (T) targetNode.getElement();
    }

    /**
     * Helper method to get the Nth node in our list
     * @param index specify the target node at that index position
     * @return return the node at that index position
     */
    private Node getNth(int index) {
        Node targetNode = head.getNext();
        for (int i = 0; i < index; i++) {
            targetNode = targetNode.getNext();
        }
        return targetNode;
    }

    /**
     * Determine if the list empty
     * @return return whether the list is empty or not
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * Remove the element from position index in the list
     * @param index specify the target node at that index position
     * @return return the original data in that index position
     * @throws IndexOutOfBoundsException if index is invalid
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        // increase the index by one since head is at index 0
        index = index + indexShifting;
        if (index > nelems || index <= 0) {
            throw new IndexOutOfBoundsException();
        }
        Node targetNode = head;
        // get the removed node
        for (int i = 0; i < index; i++) {
            targetNode = targetNode.getNext();
        }
        Node prevNode = targetNode.getPrev();
        Node nextNode = targetNode.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        nelems = nelems - 1;
        return (T) targetNode.getElement();
    }

    /**
     * Set the value of an element at a certain index in the list.
     * @param index
     * @param element data to be set at index position
     * @return return the original data in that node
     * @throws NullPointerException if data received is null
     * @throws IndexOutOfBoundsException for invalid index
     */
    @Override
    public T set(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        index = index + indexShifting;
        if (index > nelems || index <= 0) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new NullPointerException();
        }
        Node targetNode = head;
        // get the removed node
        for (int i = 0; i < index; i++) {
            targetNode = targetNode.getNext();
        }
        // store the previous data
        T nodeData = targetNode.getElement();
        // set the previous data
        targetNode.setElement(element);
        return nodeData;
    }

    /**
     * Retrieves the amount of elements that are currently on the list.
     * @return return the number of node in the list
     */
    @Override
    public int size() {
        return nelems;
    }

    /**
     * String representation of this list in the form of:
     * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]"
     * @return a string representation of the list
     */
    @Override
    public String toString() {
        String listString = "";
        String listHead = "[(head) -> ";
        String listTail = "(tail)]";
        if (nelems == 0) {
            return listHead + listTail;
        } else {
            Node currentNode = head;
            for (int i = 0; i < nelems; i++) {
                currentNode = currentNode.getNext();
                String nodeString = currentNode.getElement().toString();
                listHead = listHead + nodeString + " -> ";
            }
        }
        return listHead + listTail;
    }

    /* ==================== EXTRA CREDIT ==================== */

    /**
     * Inserts another linked list of the same type into this one
     * @param index specify the target node at that index position
     * @param otherList the list that need to be inserted
     * @return return the new list
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public void splice(int index, DoublyLinkedList<T> otherList) throws IndexOutOfBoundsException {
        //index = index + indexShifting;
        if (index > nelems || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        // store the size of the list
        int originSize = this.size();
        // create two new lists
        // to store two parts of list
        DoublyLinkedList left = new DoublyLinkedList();
        DoublyLinkedList right = new DoublyLinkedList();
        for (int i = 1; i <= index; i++) {
            left.add(this.get(i - 1));
        }
        for (int i = index + 1; i <= this.nelems; i++) {
            right.add(this.get(i - 1));
        }
        this.clear();
        Node leftNode = left.head;
        Node rightNode = right.head;
        Node otherNode = otherList.head;
        // add all three parts of list together
        for (int i = 1; i <= originSize + otherList.size(); i++) {
            if (i <= left.size()) {
                leftNode = leftNode.getNext();
                this.add(leftNode.getElement());
            }
            if (i > left.size() && i <= (otherList.size() + left.size())) {
                otherNode = otherNode.getNext();
                this.add(otherNode.getElement());
            }
            if (i > (otherList.size() + left.size()) && i <= originSize + otherList.size()) {
                rightNode = rightNode.getNext();
                this.add(rightNode.getElement());
            }
        }
    }

    /**
     * Determine the starting indices that match the subSequence
     * @param subsequence the list that need to be found
     * @return return the index of all matching location
     */
    public int[] match(DoublyLinkedList<T> subsequence) {

        //A list to hold all the starting indices found
        DoublyLinkedList<Integer> indices = new DoublyLinkedList<>();

        String originalList = this.toString();
        int originalSize = originalList.length();
        String subList = subsequence.toString();
        int subSize = subList.length();
        for (int i = 0; i < originalSize - subSize; i++) {
            if (originalList.substring(i, subSize) == subList) {
                indices.add(i);
            }
        }
        // Array Conversion
        int[] startingIndices = new int[indices.size()];
        for (int i = 0; i < indices.size(); i++) {
            startingIndices[i] = indices.get(i);
        }
        return startingIndices;
    }

}

