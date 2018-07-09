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
	private int index;
	private boolean isHasNextUsed;
	private boolean lastHasNextReturned;
	private boolean isNextUsed;

	public FilterIterator(List<T> list, Predicate<T> predicate) {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		this.list = list;
		this.predicate = predicate;
		this.listIterator = list.iterator();
		this.index = -1;
		this.isHasNextUsed = false;
		this.lastHasNextReturned = false;
		this.isNextUsed = false;
	}

	@Override
	public boolean hasNext() {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */

		if (!isHasNextUsed) {
			isHasNextUsed = true;
			for (int i = index + 1; i < list.size(); i++) {
				if (predicate.test(list.get(i))) {
					index = i;
					lastHasNextReturned = true;
					return true;
				}
			}
		} else {
			return lastHasNextReturned;
		}
		lastHasNextReturned = false;
		return false;
	}

	@Override
	public T next() {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		isNextUsed = true;
		if (hasNext()) {
			isHasNextUsed = false;
			return list.get(index);
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public void remove() {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		if(isNextUsed) {
			isNextUsed = false;
		list.remove(index);
		} else {
			throw new IllegalStateException();
		}
	}
}
