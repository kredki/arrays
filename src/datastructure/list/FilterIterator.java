package datastructure.list;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * Filter iterator
 */
public class FilterIterator<T> implements Iterator<T> {
	/* (TODO Starterkit 1) Please introduce a sensible implementation */
	private List<T> list;
	private Predicate<T> predicate;
	private Iterator<T> listIterator;
	private T currentElement;
	private boolean isHasNextUsed;

	public FilterIterator(List<T> list, Predicate<T> predicate) {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		this.list = list;
		this.predicate = predicate;
		this.listIterator = list.iterator();
		this.currentElement = null;
		this.isHasNextUsed = false;
	}

	@Override
	public boolean hasNext() {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		isHasNextUsed = true;
		while (listIterator.hasNext()) {
			T temp = listIterator.next();
			if (predicate.test(temp)) {
				this.currentElement = temp;
				return true;
			}
		}
		return false;
	}

	@Override
	public T next() {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		if (isHasNextUsed) {
			return this.currentElement;
		} else {
			if(hasNext()) {
				return this.currentElement;
			} else {
				throw new NoSuchElementException();
			}
		}
	}

	@Override
	public void remove() {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
	}
}
