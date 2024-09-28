import java.util.EmptyStackException;

public class Stack<T extends Comparable<? super T>> implements StackInterface<T> {

    private Node<T> topNode; // References the first node in the chain
    private int numberOfEntries;

    public Stack() {
        topNode = null;
        numberOfEntries = 0;
    }

    public void push(T newEntry) {
        Node<T> newNode = new Node<>(newEntry, topNode);
        topNode = newNode;
        numberOfEntries++;
    }

    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return topNode.getData();
    }

    public T pop() {
        T top = topNode.getData();
        topNode = topNode.getNextNode();
        numberOfEntries--;
        return top;
    }

    public boolean isEmpty() {
        return topNode == null;
    }

    public void clear() {
        topNode = null;
    }

    public T[] toArray(){
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Comparable[numberOfEntries];
        int index = 0;
        Node<T> currentNode = topNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        }
        return result;
    }

    public int getNumberOfEntries(){
        return numberOfEntries;
    }
}
