package datatype;

import java.util.List;

/**
 * FIFO queue
 */
public class CustomQueue<T> extends AbstractCustomQueueAdapter<T> {
	List<T> storage = null;

	/* (TODO Starterkit 1) Please introduce a sensible implementation */
	public CustomQueue(List<T> storage) {
		this.storage = storage;
	}

	@Override
	public int size() {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		if (storage == null) {
			return 0;
		} else {
			return storage.size();
		}
	}

	@Override
	public boolean isEmpty() {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		if (size() != 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean add(T t) {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		storage.add(t);
		return true;
	}

	@Override
	public T poll() {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		return storage.remove(0);
	}

	@Override
	public T peek() {
		/* (TODO Starterkit 1) Please introduce a sensible implementation */
		return storage.get(0);
	}
}
