package tr.edu.iyte.ceng112.traversaliterator;

import tr.edu.iyte.ceng112.stack.ArrayStack;
import tr.edu.iyte.ceng112.stack.StackInterface;
import tr.edu.iyte.ceng112.tree.BinaryNode;

import java.util.Iterator;


public class PreorderIterator<T> implements Iterator<T> {
	private StackInterface<BinaryNode<T>> nodeStack;
	private BinaryNode<T> currentNode;


	public PreorderIterator(BinaryNode<T> root) {
		nodeStack = new ArrayStack<>();
		currentNode = root;
	}

	@Override
	public boolean hasNext() {
		return !nodeStack.isEmpty() || (currentNode != null);
	}


	@Override
	public T next() {

		BinaryNode<T> nextNode = null;

		while(nodeStack.isEmpty() && currentNode != null)
			nodeStack.push(currentNode);

		if(!nodeStack.isEmpty()) {
			nextNode = nodeStack.pop();

			if (nextNode.hasRightChild()) {
				nodeStack.push(nextNode.getRightChild());
			}

			if (nextNode.hasLeftChild()) {
				nodeStack.push(nextNode.getLeftChild());
			}

			currentNode = null;
		}

		else
			currentNode = nodeStack.peek();

		return nextNode.getData();

	}


}
