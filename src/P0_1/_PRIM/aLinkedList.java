package Core._PRIM;

import static Core.AppUtils.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import Core._PRIM.A_I.iCollection;
import Core._PRIM.A_I.iConnection;
import Core._PRIM.A_I.iNodeIterator;

public class aLinkedList<T> implements iCollection<T> {

	public aNode<T> first;
	public aNode<T> last;

	LinkedList L;

	@Override
	public void append(T entry) {

		this.linkNode(entry);

	}

	@Override
	public void append(T... entries) {
		for (int i = 0; i < entries.length; i++)
			this.append(entries[i]);
	}

	@Override
	public void insert(T entry, int atIndex) {
		// TODO Auto-generated method stub

	}

	private void linkNode(T entry) {
		aNode newNode = new aNode(entry);
		boolean F = (this.first != null);
		boolean L = (this.last != null);

		if (!F && !L) {
			this.first = newNode;
			this.last = newNode;
		} else {
			this.linkNode(this.last, newNode, null);
			this.last = newNode;
		}

	}

	private void linkNode(aNode previous, aNode entry, aNode next) {
		// (0,1,0) = initial node or default last
		// (1,1,0) = append
		// (1,1,1) = insert
		// int P = (previous != null) ? 1 : 0;
		// int E = (entry != null) ? 1 : 0;
		// int N = (next != null) ? 1 : 0;

		boolean P = (previous != null);
		boolean E = ((entry != null) && (entry != previous) && (entry != next));
		boolean N = (next != null);

		if (E && P) {

			if (previous.has("NEXT", this))
				((aConnection) previous.connections.get("NEXT")).target = entry;
			else
				previous.connect("NEXT", entry, this);

			if (entry.has("PREVIOUS", this))
				((aConnection) previous.connections.get("PREVIOUS")).target = entry;
			else
				entry.connect("PREVIOUS", previous, this);
		}
		if (E && N) {
			if (entry.has("NEXT", this))
				((aConnection) entry.connections.get("NEXT")).target = next;
			else
				entry.connect("NEXT", next, this);

			if (next.has("PREVIOUS", this))
				((aConnection) next.connections.get("PREVIOUS")).target = entry;
			else
				next.connect("PREVIOUS", entry, this);
		}

	}

	@Override
	public void set(int at, T to) {
		aNode N = (aNode) this.get(at);
		N.set(to);
	}

	@Override
	public T get(int index) {
		for (T n : this) {
			if (this.indexOf(n) == index)// inefficient
				return n;

		}
		return null;
	}

	@Override
	public int getSize() {
		int c = 0;
		for (T N : this) {
			c++;
		}

		return c;
	}

	@Override
	public int indexOf(Object object) {
		// loop thru till you find the target, return iteration count

		// aNode current = this.first;
		int c = 0;
		for (T n : this) {

			if (n instanceof aNode) {
				aNode N = (aNode) n;
				if (object == N || object == N.get())
					return c;
			}
			c++;

		}

		return -1;
	}

	@Override
	public void remove(int index) {
		for (T n : this) {
			// if(this.indexOf(n)==index)

		}

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(T entry) {
		for (T n : this) {
			if (n == entry || n.equals(entry))
				return true;
			if (n instanceof aNode) {
				aNode N = (aNode) n;
				if (N.get() == entry || N.get().equals(entry))
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return (this.first == null);
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkIterator(this, this.first);
	}

	@Override
	public String toString() {
		String s = "";
		s += this.first + "=>" + this.last;

		return s;
	}

	public String toLog() {
		String log = this.toString();

		return log;
	}

	private class LinkIterator<T> implements iNodeIterator<T> {

		private aLinkedList array;

		private aNode current;
		private aNode next;

		public LinkIterator(aLinkedList<T> array, aNode first) {
			this.array = array;
			this.current = first;

		}

		@Override
		public boolean hasNext() {

			if (this.current.has("NEXT", this.array)) {
				this.next = ((aConnection) this.current.connections.get("NEXT")).target;
				return true;
			}

			return false;
		}

		@Override
		public aNode<T> next() {

			if (this.hasNext()) {

				this.current = this.next;
				this.next = null;
				return current;
			}

			return null;
		}

	}

	// I never understood the purpose of LinkedList.
	// You end up overriding literally everything
	// depending on the use-case. Maybe its just me.

}
