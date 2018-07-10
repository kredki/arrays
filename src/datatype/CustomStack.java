package datatype;

import java.util.EmptyStackException;
import java.util.List;

/**
 * Stack, LIFO queue
 */
public class CustomStack<T> extends AbstractCustomStackAdapter<T> {
    List<T> storage = null;

    /* (TODO Starterkit 1) Please introduce a sensible implementation */
    public CustomStack(List<T> storage) {
        this.storage = storage;
    }

    @Override
    public void push(T t) {
        /* (TODO Starterkit 1) Please introduce a sensible implementation */
    	storage.add(t);
    }

    @Override
    public T pop() {
        /* (TODO Starterkit 1) Please introduce a sensible implementation */
    	if(storage.size() == 0) {
    		throw new EmptyStackException();
    	}
        return storage.remove(storage.size() - 1);
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
}
