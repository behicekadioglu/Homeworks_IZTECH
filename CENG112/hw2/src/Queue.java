public interface Queue<T> {
    // Adds a new entry to the back of this queue.
    public void enqueue(T newEntry);

    // Removes and returns the entry at the front of this queue.
    public T dequeue();

    // Retrieves the entry at the front of this queue.
    public T getFront();

    // Detects whether this queue is empty.
    public boolean isEmpty();

    // Removes all entries from this queue.
    public void clear();
}
