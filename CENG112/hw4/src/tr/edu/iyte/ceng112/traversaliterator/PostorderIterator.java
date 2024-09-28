package tr.edu.iyte.ceng112.traversaliterator;

import tr.edu.iyte.ceng112.stack.ArrayStack;
import tr.edu.iyte.ceng112.stack.StackInterface;
import tr.edu.iyte.ceng112.tree.BinaryNode;

import java.util.Iterator;


public class PostorderIterator<T> implements Iterator<T> {
	private StackInterface<BinaryNode<T>> nodeStack;
	private BinaryNode<T> currentNode;
	private StackInterface<BinaryNode<T>> nodeStack2;


	public PostorderIterator(BinaryNode<T> root) {
		nodeStack = new ArrayStack<>();
		nodeStack2 = new ArrayStack<>();
		currentNode = root;
		nodeStack.push(currentNode);
	}

	@Override
	public boolean hasNext() {
		return !nodeStack.isEmpty() || (currentNode != null);
	}

	@Override
	public T next() {

		BinaryNode<T> nextNode = null;
		nextNode = currentNode;

		while (!nodeStack.isEmpty()){
			nextNode = nodeStack.pop();
			nodeStack2.push(nextNode);

			if(nextNode.hasLeftChild()){
				nodeStack.push(nextNode.getLeftChild());
			}

			if(nextNode.hasRightChild()){
				nodeStack.push(nextNode.getRightChild());
			}
		}

		while (!nodeStack2.isEmpty()){
			nextNode = nodeStack2.pop();
		}

		return nextNode.getData();
	}
}
