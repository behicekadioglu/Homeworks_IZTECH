public class SortedList<T extends Comparable<? super T>> implements SortedListInterface<T>{
    private Node<T> firstNode;
    private int numberOfEntries;

    public SortedList() {
        firstNode = null;
        numberOfEntries = 0;
    }

    public void add(T newEntry) {
        Node<T> newNode = new Node<>(newEntry);
        Node<T> nodeBefore = getNodeBefore(newEntry);
        if (isEmpty() || (nodeBefore == null)) {
            // Add at beginning
            newNode.setNextNode(firstNode);
            firstNode = newNode;
        }
        else {
            // Add after nodeBefore
            Node<T> nodeAfter = nodeBefore.getNextNode();
            newNode.setNextNode(nodeAfter);
            nodeBefore.setNextNode(newNode);
        }
        numberOfEntries++;
    }

    public T remove(int givenPosition) {
        T result = null; // Return value
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            if (givenPosition == 1) {
                result = (T) firstNode.getData();
                firstNode = firstNode.getNextNode();
            }
            else {
                Node<T> nodeBefore = getNodeAt(givenPosition - 1);
                Node<T> nodeToRemove = nodeBefore.getNextNode();
                result = nodeToRemove.getData();
                Node<T> nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter);
            }
            numberOfEntries--;

        }
        else if (givenPosition<1 && givenPosition>numberOfEntries) {
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");

        }
        return result;
    }

    public boolean remove(T anEntry) {
        boolean result = false;
        int position = getPosition(anEntry);
        if (position > 0) {
            remove(position);
            result = true;
        }
        return result;
    }

    public T remove(){
        return remove(1);
    }


    public final void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    public boolean isEmpty() {
        boolean result;
        if (numberOfEntries == 0){
            assert firstNode == null;
            result = true;
        }
        else {
        assert firstNode != null;
        result = false;
        }
        return result;
    }

    public T[] toArray() {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Comparable[numberOfEntries];
        int index = 0;
        Node<T> currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        }
        return result;
    }

    public int getLength(){
        return numberOfEntries;
    }

    public T getEntry(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            return (T) getNodeAt(givenPosition).getData();
        } else
            throw new IndexOutOfBoundsException( "Illegal position given to getEntry operation.");
    }

    public int getPosition(T anEntry) {
        int position = 1;
        int length = getLength();
        while ( (position <= length) &&
                (anEntry.compareTo(getEntry(position)) > 0) ) {
            position++;
        }
        if ( (position > length) ||
                (anEntry.compareTo(getEntry(position)) != 0) ) {
            position = -position;
        }
    return position;
    }

    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            } else {
                currentNode = currentNode.getNextNode();
            }
        }
        return found;
    }

    public Node<T> getFirstNode(){
        return firstNode;
    }

    public Node<T> getLastNode(){
        return getNodeAt(numberOfEntries-1);
    }

    private Node<T> getNodeBefore(T anEntry) {
        Node<T> currentNode = firstNode;
        Node<T> nodeBefore = null;
        while ( (currentNode != null) && (anEntry.compareTo(currentNode.getData()) > 0) ) {
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
        }
        return nodeBefore;
    }

    private Node<T> getNodeAt(int givenPosition) {
        assert (firstNode != null) &&
                (1 <= givenPosition) && (givenPosition <= numberOfEntries);
        Node<T> currentNode = firstNode;
    // Traverse the chain to locate the desired node (skipped if givenPosition is 1)
        for (int counter = 1; counter < givenPosition; counter++) {
            currentNode = currentNode.getNextNode();
        }
        assert currentNode != null; return currentNode;
    }
}

