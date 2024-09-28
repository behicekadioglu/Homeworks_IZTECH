public class ArrayDeque<T> implements Deque<T> {
    // Circular array of deque entries and one unused location
    private T[] deque;
    private int frontIndex;
    private int backIndex;
    private static final int DEFAULT_CAPACITY = 50;

    public ArrayDeque()
    {
        this(DEFAULT_CAPACITY);
    }

    public ArrayDeque(int initialCapacity)
    {
        @SuppressWarnings("unchecked")
        T[] tempDeque = (T[]) new Object[initialCapacity + 1];
        deque = tempDeque;
        frontIndex = 0;
        backIndex = initialCapacity;
    }

    public T getBack()
    {
        if (isEmpty())
            throw new IllegalStateException("Deque is empty");
        else
            return deque[backIndex];
    }

    public T getFront()
    {
        if (isEmpty())
            throw new IllegalStateException("Deque is empty");
        else
            return deque[frontIndex];
    }

    public T removeBack()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("Deque is empty");
        }
        else
        {
            T back = deque[backIndex];
            deque[backIndex] = null;
            backIndex = (backIndex + 1) % deque.length;
            return back;
        }
    }

    public T removeFront()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("Deque is empty");
        }
        else
        {
            T front = deque[frontIndex];
            deque[frontIndex] = null;
            frontIndex = (frontIndex + 1) % deque.length;
            return front;
        }
    }

    public void addToBack(T newEntry)
    {
        ensureCapacity();
        backIndex = (backIndex + 1) % deque.length;
        deque[backIndex] = newEntry;
    }

    public void addToFront(T newEntry)
    {
        ensureCapacity();
        frontIndex = (frontIndex + 1) % deque.length;
        deque[frontIndex] = newEntry;
    }

    public boolean isEmpty()
    {
        return frontIndex == ((backIndex + 1) % deque.length);
    }

    public void clear()
    {
        while(!isEmpty())
        {
            removeFront();
        }

        frontIndex = 0;
        backIndex = deque.length - 1;
    }

    private void ensureCapacity()
    {
        // If array is full, double size of array
        if (frontIndex == ((backIndex + 2) % deque.length))
        {
            T[] oldDeque = deque;
            int oldSize = oldDeque.length;
            int newSize = 2 * oldSize;

            // The cast is safe because the new array contains null entries
            @SuppressWarnings("unchecked")
            T[] tempDeque = (T[]) new Object[newSize];
            deque = tempDeque;

            for (int index = 0; index < oldSize - 1; index++)
            {
                deque[index] = oldDeque[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            }

            frontIndex = 0;
            backIndex = oldSize - 2;
        }
    }

}
