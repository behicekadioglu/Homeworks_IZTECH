public interface NodeInterface<T> {
    Node<T> getNextNode();
    T getData();
    void setNextNode(Node<T> newNext);
    void setData(T newData);
}
