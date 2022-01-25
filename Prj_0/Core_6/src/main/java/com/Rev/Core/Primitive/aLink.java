package com.Rev.Core.Primitive;



public class aLink extends aSet<aNode>{

	public String label = "";
	protected Object context;
	public aNode target;

	protected String inSymbol = "*<";
	public String outSymbol = ">*";

	public int max = -1; // -1 means unlimited

	public aLink(String label, aNode to) {
		super();
		this.label = label;
		this.target = to;
		this.append(to);

	}

	public aLink(String label, aNode to, int max) {
		this(label, to);
		this.max = max;
	}

	public aLink(String label, aNode to, Object context) {
		this(label, to);
		this.context = context;

	}

	public aLink(String label, aNode to, int max, Object context) {
		this(label, to, max);
		this.context = context;
	}

	public Object get() {

		if (this.max == 1)
			return this.get(0);

		return this;
	}

	@Override
	public String toString() {
		return this.inSymbol + this.label + this.outSymbol;
	}

	private String sizeString() {
		if (this.max > 1)
			return "[" + this.getSize() + "/" + this.max + "]";
		else
			return "[" + this.getSize() + "]";
	}

	public String getConnection() {
		String contextStr = "<{[(" + this.context.getClass().getSimpleName() + "@"
				+ Integer.toHexString(this.context.hashCode()) + ")]}>";
		return this.toString() + this.sizeString() + " : " + this.target + " % " + contextStr;
	}

	@Override
	public String toLog() {
		String log = this.toString() + "[" + this.getSize() + "]";
		for (int i = 0; i < this.getSize(); i++) {
			log += "*_ ";
			log += this.data[i].toString();
		}
		return log;
	}
}
