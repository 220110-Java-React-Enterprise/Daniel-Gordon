package com.Rev.Core._PRIM.Data;

import com.Rev.Core._PRIM.aMap;
import com.Rev.Core._PRIM.aSet;

public class aDataEntry extends aDataField<aMap<String, aDataField>> {

	// table row
	public aDataEntry(String label, aDataField.aDataType... fields) {
		super(label, aDataType.OBJ);
	}

	public aDataEntry(String label, aDataType type) {
		super(label, type);
		this.get = new aMap<String, aDataField>();
	}

	public boolean hasField(String label) {
		if (this.get().containsKey(label))
			return true;

		return false;
	}

	public aDataField getField(String label) {
		if (hasField(label))
			return this.get().get(label);
		return null;
	}

	public void putField(aDataField field) {
		this.get().put(field.label, field);
	}

	public aSet<aDataField> getFields() {

		return (aSet<aDataField>) this.get().getValues();
	}

}
