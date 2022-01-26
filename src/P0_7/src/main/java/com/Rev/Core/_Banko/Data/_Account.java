package com.Rev.Core._Banko.Data;

import static com.Rev.Core.Primitive.Data.aDataField.*;

import com.Rev.Core.Primitive.Data.aDataEntry;
import com.Rev.Core._Banko.Util.StringUtils;

public class _Account extends aDataEntry {

	protected int ownerIndex;
	protected int type;

	protected float balance = 0f;
	protected int AcctNum;

	private boolean debug = true;
	protected int dbIndex; // index of this account in DB_Table

	public _Account(int ownerID, int type) {
		super("Account", aDataType.OBJ);
		this.ownerIndex = ownerID;
		this.type = type;
		this.balance = 0f;
	}

	public _Account(int ownerID, int type, float balance, int acctnum) {
		super("Account", aDataType.OBJ);
		this.ownerIndex = ownerID;
		this.type = type;
		this.balance = balance;
		this.AcctNum = acctnum;
	}

	public int Owner() {
		return this.ownerIndex;
	}

	public int Type() {
		return this.type;
	}

	public float Balance() {
		return this.balance;
	}

	@Override
	public String toString() {

		String typeName = "";
		if (type == 0)
			typeName += "Checking";
		else
			typeName += "Savings";

		String s = "[" + typeName + " #" + this.AcctNum + " | " + StringUtils.toMoney(balance) + "]";
		return s;
	}

	public void deposit(float amt) {
		this.crebit(Math.abs(amt));
	}

	public void withdraw(float amt) {
		float transactionFee = 4f;
		this.crebit(-Math.abs(amt));
	}

	protected void crebit(float amt) {
		this.balance += amt;
	}

}
