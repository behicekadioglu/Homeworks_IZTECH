public class Node<T> implements NodeInterface<T>{

    private T data;
    private Node<T> next;
    private int priority;

    public Node(T dataPortion) {
        this(dataPortion, null, 0);
    }

    public Node(T dataPortion, Node<T> nextNode) {
        this(dataPortion, nextNode, 0);
    }

    public Node(T dataPortion, int newPriority){
        this(dataPortion, null, newPriority);
    }

    public Node(T dataPortion, Node<T> nextNode, int newPriority){
        data = dataPortion;
        next = nextNode;
        priority = newPriority;
    }

    public Node<T> getNextNode(){
        return next;
    }

    public T getData(){
        return data;
    }

    public int getPriority(){
        return priority;
    }

    public void setNextNode(Node<T> newNext){
        next = newNext;
    }

    public void setData(T newData){
        data = newData;
    }
}
