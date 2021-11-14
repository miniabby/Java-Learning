public class Deque {

    private DoublyLinkedList<Integer> list;

    public Deque() throws IllegalArgumentException {
        list = new DoublyLinkedList<Integer>();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean addFront(Integer i) throws NullPointerException {
        if (i == null) {
            throw new NullPointerException();
        }
        list.add(0, i);
        return true;
    }

    public boolean addBack(Integer i) throws NullPointerException {
        if (i == null) {
            throw new NullPointerException();
        }
        list.add(i);
        return true;
    }

    public Integer removeFront() {
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    public Integer removeBack() {
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(list.size() - 1);
    }

    public Integer peekFront() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public Integer peekBack() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

}
