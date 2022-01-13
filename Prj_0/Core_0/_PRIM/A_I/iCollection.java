package Core._PRIM.A_I;

public interface iCollection<E>{

	public int getSize();
	public void add(E entry);
	public void add(E... entries);
	public void insert(E entry, int atIndex);
	public E get(int index);
	public void remove(int index);	
	public void clear();
	public boolean contains(E entry);
	public boolean isEmpty();
	
}
