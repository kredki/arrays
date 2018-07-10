package datastructure.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * List based on the table
 *
 * @param <T>
 */
public class CustomArrayList<T> extends AbstractCustomListAdapter<T> {
	/*
	 * (TODO Starterkit 1) Please introduce a sensible implementation for
	 * storage
	 */

	private Object[] array = null;
	private int size = 0;
	private int initialCapacity = 0;
	private static final int MIN_SIZE = 100;

	public CustomArrayList() {
		initialCapacity = MIN_SIZE;
		array = new Object[MIN_SIZE];
	}

	public CustomArrayList(int initialCapacity) {
		/*
		 * (TODO Starterkit 1) Please introduce a sensible implementation for
		 * storage
		 */
		if (initialCapacity < 0) {
			throw new IllegalArgumentException();
		} else if (initialCapacity < MIN_SIZE) {
			this.initialCapacity = MIN_SIZE;
			array = new Object[MIN_SIZE];
		} else {
			this.initialCapacity = initialCapacity;
			array = new Object[initialCapacity];
		}
	}

	@Override
	public int size() {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		return size;
	}

	@Override
	public boolean isEmpty() {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		if (size > 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean contains(Object o) {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		if(o == null) {
			return containsNull();
		}
		
		for (int i = 0; i < size; i++) {
			if (array[i].equals(o)) {
				return true;
			}
		}
		return false;
	}
	private boolean containsNull() {
		for (int i = 0; i < size; i++) {
			if (array[i] == null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		return new CustomArrayListIterator<>();
	}

	@Override
	public boolean add(T t) {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		changeArraySize();
		array[size] = t;
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		changeArraySize();
		for (int i = 0; i < size - 1; i++) {
			if (array[i].equals(o)) {
				for (int j = i + 1; j < size; j++) {
					array[j - 1] = array[j];
				}
				size--;
				return true;
			}
		}
		return false;
	}

	@Override
	public void clear() {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		array = new Object[this.initialCapacity];
		size = 0;
	}

	@Override
	public T get(int index) {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		if (!checkBoundries(index)) {
			throw new IndexOutOfBoundsException();
		} else {
			return (T) array[index];
		}
	}

	@Override
	public T set(int index, T element) {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		changeArraySize();
		if (!checkBoundries(index)) {
			throw new IndexOutOfBoundsException();
		} else {
			Object previousValue = array[index];
			array[index] = element;
			return (T) previousValue;
		}
	}

	@Override
	public void add(int index, T element) {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		changeArraySize();
		if (!checkBoundries(index)) {
			throw new IndexOutOfBoundsException();
		} else {
			/*for (int i = size; i < index + 1; i--) {
				array[i + 1] = array[i];
			}*/
			System.arraycopy(this.array, index, this.array, index +1, this.size - index);
			array[index] = element;
			this.size++;
		}
	}

	@Override
	public T remove(int index) {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		changeArraySize();
		if (!checkBoundries(index)) {
			throw new IndexOutOfBoundsException();
		} else {
			Object removedObject = array[index];
			for (int j = index + 1; j < size; j++) {
				array[j - 1] = array[j];
			}
			for(int i = 0; i < this.size; i++) {
				System.out.println(array[i]);
			}
			this.size--;
			return (T) removedObject;
		}
	}

	@Override
	public int indexOf(Object o) {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		for (int i = 0; i < size; i++) {
			if (array[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}
	
	private boolean checkBoundries(int index) {
		if (index < 0 || index >= this.size) {
			return false;
		} else {
			return true;
		}
	}
	
	public int getAllocatedSize() {
		return array.length;
	}

	private void changeArraySize() {
		int newSize = initialCapacity;
		if (size > array.length * 0.9) {
			newSize = (int) (1.1 * array.length);
			resizeArray(newSize);
		} else if (size < array.length * 0.6) {
			newSize = (int) (0.9 * array.length);
			if (newSize < initialCapacity) {
				newSize = initialCapacity;
			}
			if (newSize > this.size) {
				resizeArray(newSize);
			}
		}
	}

	private void resizeArray(int size) {
		Object[] newArray = new Object[size];
		for (int i = 0; i < this.size; i++) {
			newArray[i] = this.array[i];
		}
		array = newArray;
	}

	/**
	 * Iterator for CustomArrayList
	 */
	private class CustomArrayListIterator<E> implements Iterator<E> {
		private int index = 0;
		private boolean isNextUsed = false;
		private boolean isRemovedUsed = false;

		@Override
		public boolean hasNext() {
			/* (TODO Starterkit 1) Please introduce a sensible implementation */
			if (index >= CustomArrayList.this.size) {
				return false;
			}
			return true;
		}

		@Override
		public E next() {
			/* (TODO Starterkit 1) Please introduce a sensible implementation */
			isNextUsed = true;
			isRemovedUsed = false;
			if(index >= CustomArrayList.this.size) {
				throw new NoSuchElementException();
			} else {
				index++;
				return (E)CustomArrayList.this.array[index];
			}
		}

		@Override
		public void remove() {
			/* (TODO Starterkit 1) Please introduce a sensible implementation */
			if(isNextUsed && !isRemovedUsed) {
				isNextUsed = false;
				isRemovedUsed = true;
				CustomArrayList.this.remove(index);
			} else {
				isNextUsed = false;
				throw new IllegalStateException();
			}
		}
	}
}
