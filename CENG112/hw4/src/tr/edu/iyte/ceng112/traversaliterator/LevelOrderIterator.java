package tr.edu.iyte.ceng112.traversaliterator;

import tr.edu.iyte.ceng112.queue.ArrayQueue;
import tr.edu.iyte.ceng112.queue.EmptyQueueException;
import tr.edu.iyte.ceng112.queue.QueueInterface;
import tr.edu.iyte.ceng112.tree.BinaryNode;

import java.util.Iterator;

public class LevelOrderIterator<T> implements Iterator<T> {
	private QueueInterface<BinaryNode<T>> nodeQueue;
	private BinaryNode<T> currentNode;


	public LevelOrderIterator(BinaryNode<T> root) {
		nodeQueue = new ArrayQueue<>();
		currentNode = (BinaryNode<T>) root;
	}

	@Override
	public boolean hasNext() {
		return !nodeQueue.isEmpty() || (currentNode != null);
	}

	@Override
	public T next() {
		BinaryNode<T> temp = null;
		try {
			currentNode = nodeQueue.dequeue();
		} catch (EmptyQueueException e) {
			throw new RuntimeException(e);
		}

		if (currentNode.hasLeftChild()) {
			nodeQueue.enqueue(currentNode.getLeftChild());
		}
		if (currentNode.hasRightChild()) {
			nodeQueue.enqueue(currentNode.getRightChild());
		}

		return temp.getData();
	}

}
