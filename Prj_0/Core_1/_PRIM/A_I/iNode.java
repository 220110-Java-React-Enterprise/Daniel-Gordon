package Core._PRIM.A_I;

public interface iNode<T> {

	public iNode getRoot();

	public iNode getParent();

	public iCollection<iNode> getConnected(String type);

	public T get();
	public void set(T to);

	public default Class of()
	{
		if(this.get()!= null)
		return this.get().getClass();
		else
			return Object.class;
	}

}
