package Core._PRIM.A_I;

public interface iMap<K,V> {

	
	
	public void put(K key, V val);
	
	public void put(K key, V...val);
	
	public iCollection get(K key);
	
	public boolean contains(K key, V val);
	
	public default boolean containsKey(K key)
	{
		return this.getKeys().contains(key);
	}
	
	public default boolean containsValue(V val)
	{
		return this.getValues().contains(val);
	}
	
	public iCollection getKeys();
	
	public iCollection getValues();
	
}
