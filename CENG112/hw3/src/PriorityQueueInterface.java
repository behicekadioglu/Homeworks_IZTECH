public interface PriorityQueueInterface<T extends Comparable<? super T>>{
    // Adds a new entry to the position according to its priority.
    public void enqueue(T newEntry,int priority);

    // Removes and returns the entry at the front of this queue.
    public T dequeue();

    // Retrieves the entry at the front of this queue.
    public T getFront();

    // Detects whether this queue is empty.
    public boolean isEmpty();

    // Removes all entries from this queue.
    public void clear();

    public Node getFirstNode();

    public Node getLastNode();

    public int getSize();
}
