package com.Rev.Core._Banko.Views;

import com.Rev.Core.Console.ConsoleUI;
import com.Rev.Core.Console.UI.aConsoleView;
import com.Rev.Core.Primitive.aMap;
import com.Rev.Core._Banko.Data._Account;

public class AccountView extends aConsoleView {

	// BankDirector.AccountManager.update(index, this); match by account number
	// deposit, withdraw

	private _Account as;

	private float deltaBal = 0f;

	public AccountView(ConsoleUI manager, _Account as) {
		super(manager);
		this.as = as;
	}

	@Override
	public void init() {
		super.init();

		// this.options = new aMap<String, String>();
		// this.options.put("^", "OUT");
		// this.options.put("X", "EXIT");

		this.options.put("1", "VIEW ACCT");
		this.options.put("2", "OPEN NEW ACCT");

	}

	/////////////////

	public void deposit(float amt) {
		this.crebit(Math.abs(amt));
	}

	public void withdraw(float amt) {
		this.crebit(-Math.abs(amt));
	}

	private void crebit(float amt) {
		// submit lol
		// refresh & comit

		this.deltaBal += amt;
	}

	

}
