package datastructure.list;

/**
 * Component of linked list that stores a value and reference to the next element.
 */
public class Node<V> {
      /* (TODO Starterkit 1) Please introduce a sensible implementation */
	private Node<V> nextNode;
	private Node<V> previousNode;
	private V value;
	
	public Node(Node<V> nextNode, Node<V> previousNode, V value) {
		super();
		this.nextNode = nextNode;
		this.previousNode = previousNode;
		this.value = value;
	}
	
	public Node(V value) {
		super();
		this.nextNode = null;
		this.previousNode = null;
		this.value = value;
	}

	public Node<V> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<V> nextNode) {
		this.nextNode = nextNode;
	}

	public Node<V> getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node<V> previousNode) {
		this.previousNode = previousNode;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	
}
