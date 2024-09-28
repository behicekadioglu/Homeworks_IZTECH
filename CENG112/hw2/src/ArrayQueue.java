public class ArrayQueue<T> implements Queue<T> {
    // Circular array of queue entries and one unused location
    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private static final int DEFAULT_CAPACITY = 50;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int initialCapacity) {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[]) new Object[initialCapacity + 1];
        queue = tempQueue;
        frontIndex = 0;
        backIndex = initialCapacity;
    }

    public void enqueue(T newEntry) {
        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
    }

    public T getFront() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        else
            return queue[frontIndex];
    }

    public T dequeue()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("Queue is empty");
        }
        else
        {
            T front = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
            return front;
        }
    }

    public boolean isEmpty()
    {
        return frontIndex == ((backIndex + 1) % queue.length);
    }

    public void clear()
    {
        while(!isEmpty())
        {
            dequeue();
        }

        frontIndex = 0;
        backIndex = queue.length - 1;
    }

    private void ensureCapacity()
    {
        // If array is full, double size of array
        if (frontIndex == ((backIndex + 2) % queue.length))
        {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = 2 * oldSize;

            // The cast is safe because the new array contains null entries
            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[newSize];
            queue = tempQueue;

            for (int index = 0; index < oldSize - 1; index++)
            {
                queue[index] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            }

            frontIndex = 0;
            backIndex = oldSize - 2;
        }
    }

}

