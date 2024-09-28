public class PriorityQueue<T extends Comparable<? super T>>
        implements PriorityQueueInterface<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;


    public PriorityQueue() {
        firstNode = null;
        lastNode = null;
        size  = 0;

    }
    public void enqueue(T data,int priority) {
        //add to queue using priority
        Node<T> newNode = new Node<>(data,priority);

        // if queue is empty add newNode to the head
        if (firstNode==null) {
            firstNode = newNode;
            size++;
            lastNode = newNode;
        }
        else {
            Node<T> pivot;

            // if queue has one element
            // if newNode's priority is less than the one we are looking,
            if(firstNode.getPriority() > newNode.getPriority()){
                pivot = firstNode;
            }

            // if newNode's priority is more than or equal to the one we are looking
            else{
                newNode.setNextNode(firstNode);
                firstNode = newNode;
                size++;
                return;
            }

            // if queue has more than one element
            while(pivot.getNextNode() != null){
                if(pivot.getNextNode().getPriority() > newNode.getPriority())
                {
                    pivot = pivot.getNextNode();
                }
                else
                {
                    newNode.setNextNode(pivot.getNextNode());
                    pivot.setNextNode(newNode);
                    size++;
                    return;
                }
            }

            lastNode.setNextNode(newNode);
            lastNode = newNode;
            size++;
        }
    }

    public T dequeue() {
        if ( firstNode == null)
            return null;
        Node<T> temp = firstNode;
        firstNode = firstNode.getNextNode();
        size--;
        return temp.getData();
    }


    public T getFront() {
        if (firstNode == null)
            return null;
        else{
            return firstNode.getData();
        }
    }


    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }

    public void clear() {
        firstNode = null;
        lastNode = null;
    }

    public Node<T> getFirstNode(){
        return firstNode;
    }

    public Node<T> getLastNode(){
        return lastNode;
    }

    public int getSize(){
        return size;
    }

}



