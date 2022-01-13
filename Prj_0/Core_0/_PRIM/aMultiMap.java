package Core._PRIM;

import Core._PRIM.A_I.iCollection;
import Core._PRIM.A_I.iMap;

public class aMultiMap<K, V> implements iMap<K, iCollection<V>> {

	// private aSet<K> keys;
	// private aList<aSet<V>> values;

	private aMap<K, aList<V>> data;

	public aMultiMap() {
		this.data = new aMap<K, aList<V>>();
	}

	@Override
	public void put(K key, Object val) {

	}

	@Override
	public void put(K key, Object... val) {

	}

	@Override
	public iCollection pull(K key) {
		return null;
	}

	@Override
	public boolean contains(K key, Object val) {
		
		if(this.data.containsKey(key))
		{
			//if(this.pu)
		}	
		
		return false;
	}

	@Override
	public iCollection<K> getKeys() {
		return this.data.getKeys();
	}

	@Override
	public iCollection<V> getValues() {
		return this.data.getValues();
	}

}
