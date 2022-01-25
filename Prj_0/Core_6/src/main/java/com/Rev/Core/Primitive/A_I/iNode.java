package com.Rev.Core.Primitive.A_I;

import com.Rev.Core.Primitive.aNode;

public interface iNode<T> {

	public T get();

	public void set(T to);

	public default Class of() {
		if (this.get() != null)
			return this.get().getClass();
		else
			return Object.class;
	}

}
