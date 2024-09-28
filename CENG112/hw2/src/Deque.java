public interface Deque<T> {
    // Adds a new entry to the front/back of this deque.
    public void addToFront(T newEntry);
    public void addToBack(T newEntry);

    // Removes and returns the front/back entry of this deque.
    public T removeFront();
    public T removeBack();

    // Retrieves the front/back entry of this deque.
    public T getFront();
    public T getBack();

    // Detects whether this deque is empty.
    public boolean isEmpty();

    // Removes all entries from this deque.
    public void clear();
}
