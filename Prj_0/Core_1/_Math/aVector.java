package Core._Math;

import java.util.Iterator;

import static Core._Math.A_I.N_Resolver.*;

import Core._PRIM.aList;
import Core._PRIM.A_I.iCollection;

public class aVector<N extends Number> extends aNumber
		implements Iterable<Number>, CharSequence, Comparable<Number>, iCollection<Number> {
	public aList elements;

	public aVector() {
		this(0f);
	}

	public aVector(Number type) {
		this.elements = new aList();
		elements.append(resolveTo(type, 0));
	}

	public aVector(Number... values) {
		this.elements = new aList();
		for (int i = 0; i < values.length; i++) {
			elements.append(values[i]);
		}
	}

	@Override
	public int getSize() {

		return this.elements.getSize();
	}

	@Override
	public void append(Number entry) {
		this.elements.append(entry);

	}

	@Override
	public void append(Number... entries) {
		this.elements.append(entries);

	}

	@Override
	public void insert(Number entry, int atIndex) {
		this.elements.insert(entry, atIndex);

	}

	@Override
	public void set(int at, Number to) {
		this.elements.set(at, to);

	}

	@Override
	public Number get(int index) {
		return (Number) this.elements.get(index);
	}

	@Override
	public void remove(int index) {
		this.elements.remove(index);

	}

	@Override
	public void clear() {
		this.elements.clear();
		this.append(0);
	}

	@Override
	public boolean contains(Number entry) {
		return this.elements.contains(entry);
	}

	@Override
	public boolean isEmpty() {
		return this.elements.isEmpty();
	}

	@Override
	public int compareTo(Number o) {
		return 0;
	}

	@Override
	public Iterator<Number> iterator() {
		return this.elements.iterator();
	}

	@Override
	public String toString() {
		// return this.elements.toString();String s = "";
		String s = "(";
		if (this.elements != null)
			for (int i = 0; i < this.elements.getSize(); i++) {
				s += /* "[" + i + "]" + */this.elements.get(i);
				if (i != this.elements.getSize() - 1)
					s += ",";
			}
		s += ")";
		return s;
	}
}
