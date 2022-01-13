package Core._PRIM;

import static Core.AppUtils.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class aSet<T> implements Iterable<T> {

	//susceptible to duplicates

	
	private Object[] data;
	

	public aSet() {
		this.data = new Object[0];
	}
	

	private void growTo(int toCap) {
		data = Arrays.copyOf(data, toCap);
	}

	public void add(T object) {
		
		
		int i = data.length + 1;
		this.growTo(i);
		data[i - 1] = object;
		
	}

	public void remove(int i) {
		final int newSize;
		if ((newSize = data.length - 1) > i)
			System.arraycopy(this.data, i + 1, this.data, i, newSize - i);
		this.data[newSize] = null;
		this.growTo(data.length - 1);
	}

	public T get(int index) {

		if (index < data.length) {
			return (T) data[index];
		} else
			return null;
	}

	public int getSize() {
		return this.data.length;
	}

	public int indexOf(T object) {
		
		for (int i = 0; i < this.data.length; i++) {
			if (data[i] == object)
				return i;
		}
		return -1;
	}

	public boolean contains(Object obj) {
		String log = "aList{" + this.getSize()+"}\n";
		for (int i = 0; i <= this.data.length - 1; i++) {			
			if (data[i] == obj)
				return true;
		}
		return false;
	}

	public void clear() {
		for (int i = 0; i < this.data.length; i++) {
			this.remove(i);
		}
	}

	@Override
	public String toString() {
		String s  = "aSet{" + this.getSize()+"}\n";
		if (this.data != null)
			for (int i = 0; i < this.data.length; i++) {
				s += "[" + i + "]" + this.data[i] + "\n";
			}
		return s;
	}

	@Override
	public Iterator<T> iterator() {
		return new aListIterator(this);
	}

	public class aListIterator implements Iterator<T> {

		public aSet<T> array;
		int index = -1;
		boolean valid = true;

		public aListIterator(aSet<T> array) {
			this.array = array;
		}

		@Override
		public boolean hasNext() {

			if (!valid) {
				throw new RuntimeException("#iterator() cannot be used nested.");
			}
			return index < (array.getSize() - 1);
		}

		@Override
		public T next() {
			if (index >= (array.getSize()))
				throw new NoSuchElementException(String.valueOf(index));
			if (!valid) {
				throw new RuntimeException("#iterator() cannot be used nested.");
			}
			index++;

			return array.get(index);
		}

	}
}
