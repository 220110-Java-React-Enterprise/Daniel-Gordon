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

		if (!this.keys.contains(key)) {
			this.keys.add(key);
			this.values.add(val);
		}
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
	

	public String toLog()
	{
		String log = "";
		for(int i =0; i < this.keys.getSize()-1; i++)
		{
			log += keys.get(i) + " " + values.get(i) +"\n";
		}
		
		return log;
	}
	
	

}
