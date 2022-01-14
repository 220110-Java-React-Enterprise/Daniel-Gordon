package Core._PRIM;

import Core._PRIM.A_I.iCollection;
import Core._PRIM.A_I.iNode;

public class aNode<T> implements iNode<T> {

	private T get;
	public aNode parent;
	public aMultiMap<String, aNode> connections = new aMultiMap<String, aNode>();

	public aNode() {

	}

	@Override
	public iNode getRoot() {

		if (this.getParent() != null)
			return this.parent.getRoot();
		else
			return this;
	}

	@Override
	public iNode getParent() {

		return this.parent;
	}

	@Override
	public void setParent(aNode parent) {
		if (this.parent != null)
			this.removeParent();

		this.parent = (aNode) parent;
		this.parent.connections.put("Children", this);
	}

	public void removeParent() {
		if (this.parent != null) {
			aList children = (aList) this.parent.getConnected("Children");
			children.remove(children.indexOf(this));
		}
	}

	@Override
	public iCollection<iNode> getConnected(String type) {
		return this.connections.pull(type);
	}

	@Override
	public T get() {
		return this.get;
	}

	@Override
	public void set(T to) {
		this.get = to;

	}

}
