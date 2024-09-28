public class Queue<T> {
    private Node firstNode;
    private Node lastNode;

    public Queue() {
        firstNode = null;
        lastNode = null;
    }

    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);
        if (isEmpty())
            firstNode = newNode;
        else
            lastNode.setNextNode(newNode);
        lastNode = newNode;
    }

    public T getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("The queue is empty!");
        else
            return (T) firstNode.getData();
    }

    public T dequeue() {
        T front = getFront();
        assert firstNode != null;
        firstNode.setData(null);
        firstNode = firstNode.getNextNode();
        if (firstNode == null)
            lastNode = null;
        return front;
    }

    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }

    public void clear() {
        firstNode = null;
        lastNode = null;
    }

    public Node getFirstNode(){
        return firstNode;
    }

    public Node getLastNode(){
        return lastNode;
    }
}
