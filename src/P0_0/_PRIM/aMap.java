package Core._PRIM;

public class aMap<K, V> {

	// index-linked lists
	private aList<K> keys;
	private aList<V> values;

	public aMap() {
		this.keys = new aList<K>();
		this.values = new aList<V>();
	}

	public void put(K key, V val) {

		if (!this.has(key, val)) {
			this.keys.add(key);
			this.values.add(val);
		}
	}

	// public Entry get
	// public aList<
	public V get(int index) {
		return this.values.get(index);
	}

	public aList<V> get(K key) {
		aList<V> result = new aList<V>();
		for (int i = 0; i < this.getSize(); i++) {
			if (this.keys.get(i) == key || this.keys.get(i).equals(key)) {
				result.add(this.values.get(i));
			}
		}

		return result;
	}

	public boolean has(K key, V val) {
		for (int i = 0; i < this.keys.getSize(); i++) {
			if (this.keys.get(i) == key && this.values.get(i) == val)
				return true;
		}
		return false;
	}

	public void remove(K key) {
		int kI = -1;
		if (this.keys.contains(key))
			kI = this.keys.indexOf(key);

		if (kI >= 0) {
			this.keys.remove(kI);
			this.values.remove(kI);
		}
	}

	public int getSize() {
		return this.keys.getSize();
	}

	public String toString() {
		String log = this.getClass().getSimpleName() + "{" + this.keys.getSize() + "}\n";
		for (int i = 0; i < this.keys.getSize(); i++) {
			log += "[" + i + "]" + this.keys.get(i) + "|" + this.values.get(i) + "\n";
		}

		return log;
	}

	public class Entry<K, V> {

	}

}
