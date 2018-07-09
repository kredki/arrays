package datastructure.list;

import java.awt.HeadlessException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * List based on recursively related objects
 *
 * @param <T>
 */
public class CustomLinkedList<T> extends AbstractCustomListAdapter<T> {
	/*
	 * (TODO Starterkit 1) Please introduce a sensible implementation for
	 * storage
	 */

	private Node<T> head = null;
	private Node<T> tail = null;

	@Override
	public int size() {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		int size = 0;
		if (head == null)
			return size;
		else {
			Node<T> node = head;
			while (node.getNextNode() != null) {
				size++;
				node = node.getNextNode();
			}
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(Object o) {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		if (head == null)
			return false;
		else {
			Node<T> node = head;
			if (node.getValue().equals(o))
				return true;

			while (node.getNextNode() != null) {
				node = node.getNextNode();
				if (node.getValue().equals(o))
					return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		return new CustomLinkedListIterator<>();
	}

	@Override
	public boolean add(T t) {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		if (head == null) {
			head = new Node<T>(t);
			head.setNextNode(head);
			tail = head;
			return true;
		} else {
			Node<T> temp = new Node<T>(null, tail, t);
			tail.setNextNode(temp);
			tail = temp;
			return true;
		}
	}

	@Override
	public boolean remove(Object o) {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		if (head == null)
			return false;
		else {
			Node<T> node = head;
			if (node.getValue().equals(o)) {
				head = node.getNextNode();
				return true;
			}

			while (node.getNextNode() != null) {
				node = node.getNextNode();
				if (node.getValue().equals(o)) {
					Node<T> newNextNode = node.getNextNode();
					Node<T> newPreviousNode = node.getPreviousNode();
					newPreviousNode.setNextNode(newNextNode);
					newNextNode.setPreviousNode(newPreviousNode);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void clear() {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		head = null;
		tail = null;
	}

	@Override
	public T get(int index) {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		if (index < 0 || index >= size() || head == null)
			throw new IndexOutOfBoundsException();
		else {
			Node<T> node = head;
			int i = 0;
			do {
				if (i == index) {
					return node.getValue();
				}
				node = node.getNextNode();
				i++;
			} while (node.getNextNode() != null);
		}
		return null;
	}

	@Override
	public T set(int index, T element) {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		if (index < 0 || index >= size() || head == null)
			throw new IndexOutOfBoundsException();
		else {
			Node<T> node = head;
			int i = 0;
			do {
				if (i == index) {
					T previousValue = node.getValue();
					node.setValue(element);
					return previousValue;
				}
				node = node.getNextNode();
				i++;
			} while (node.getNextNode() != null);
		}
		return null;
	}

	@Override
	public void add(int index, T element) {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		if (index < 0 || index >= size() || head == null)
			throw new IndexOutOfBoundsException();
		else {
			Node<T> node = head;
			int i = 0;
			do {
				if (i == index) {
					Node<T> newNextNode = node.getNextNode();
					Node<T> newPreviousNode = node.getPreviousNode();
					Node<T> addedNode = new Node<>(node, newPreviousNode, element);
					newPreviousNode.setNextNode(addedNode);
					newNextNode.setPreviousNode(addedNode);
				}
				node = node.getNextNode();
				i++;
			} while (node.getNextNode() != null);
		}
	}

	@Override
	public T remove(int index) {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		if (index < 0 || index >= size() || head == null) {
			throw new IndexOutOfBoundsException();
		} else {
			Node<T> node = head;
			int i = 0;
			do {
				if (i == index) {
					Node<T> newNextNode = node.getNextNode();
					Node<T> newPreviousNode = node.getPreviousNode();
					newPreviousNode.setNextNode(newNextNode);
					newNextNode.setPreviousNode(newPreviousNode);
					return node.getValue();
				}
				node = node.getNextNode();
				i++;
			} while (node.getNextNode() != null);
		}
		return null;
	}

	@Override
	public int indexOf(Object o) {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		if (head == null) {
			return -1;
		} else {
			Node<T> node = head;
			if (node.getValue().equals(o)) {
				head = node.getNextNode();
				return true;
			}

			int index = 0;
			do {

				if (node.getValue().equals(o)) {
					return index;
				}
				index++;
				node = node.getNextNode();

			} while (node.getNextNode() != null);
		}

		return -1;
	}

	/**
	 * Iterator for CustomLinkedList
	 */
	private class CustomLinkedListIterator<E> implements Iterator<E> {

		private Node<E> currentNode = (Node<E>) CustomLinkedList.this.head;
		private boolean isNextUsed = false;
		private boolean isRemovedUsed = false;
		private int index = -1;

		@Override
		public boolean hasNext() {
			/* (TODO Starterkit 1) Please introduce a sensible implementation */
			if (currentNode == null) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		public E next() {
			/* (TODO Starterkit 1) Please introduce a sensible implementation */
			isNextUsed = true;
			isRemovedUsed = false;
			if(currentNode == null) {
				throw new NoSuchElementException();
			} else {
				index++;
				return this.currentNode.getValue();
			}
		}

		@Override
		public void remove() {
			/* (TODO Starterkit 1)Please introduce a sensible implementation */
			if(isNextUsed && !isRemovedUsed) {
				isNextUsed = false;
				isRemovedUsed = true;
				CustomLinkedList.this.remove(this.index);
			} else {
				isNextUsed = false;
				throw new IllegalStateException();
			}
		}
	}
}
