package shopping_cart;
/**
	An interface that describes the operations of a bag of objects.
	@author Michael Bushman
*/
public class ArrayBag<T> implements BagInterface<T> {
	private T[] cart;
	private int entries;
	
	public ArrayBag() {
		cart = (T[])new Object[0];
		entries = 0;
	}
	@Override
	public int getCurrentSize() {
		return entries;
	}

	@Override
	public boolean isEmpty() {
		if (entries == 0)
			return true;
		
		return false;
	}

	@Override
	public boolean add(T newEntry) {
		if (entries == cart.length) 
			return false;
		else {
			cart[entries] = newEntry;
			entries++;
		}
		return true;
	}

	@Override
	public T remove() {
		T remove = null;
		
		if (!isEmpty()) {
			remove = cart[entries - 1];
			entries--;
		}
		return remove;
	}

	@Override
	public boolean remove(T anEntry) {
		for (int i = 0; i < cart.length; i++) {
			if (cart[i].equals(anEntry)) {
				cart[i] = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public void clear() {
		cart = (T[])new Object[0];
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
		
		for (int i = 0; i < cart.length; i++) {
			if (cart[i].equals(anEntry)) 
				frequency++;
		}
		return frequency;
	}

	@Override
	public boolean contains(T anEntry) {
		for (int i = 0; i < cart.length; i++) {
			if(cart[i].equals(anEntry))
				return true;
			}
		return true;
	}

	@Override
	public T[] toArray() {
		return cart;
	}
}
