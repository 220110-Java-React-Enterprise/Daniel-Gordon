package com.Rev.Core._Banko.Views;

import static com.Rev.Core.AppUtils.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.Rev.Core.Console.ConsoleUI;
import com.Rev.Core.Console.UI.aConsoleView;
import com.Rev.Core.Primitive.aMap;
import com.Rev.Core._Banko.BankDirector;
import com.Rev.Core._Banko.Data._Account;

public class AccountView extends aConsoleView {

	// BankDirector.AccountManager.update(index, this); match by account number
	// deposit, withdraw

	private _Account as;

	private float deltaBal = 0f;

	private boolean dioD = false;
	private boolean dioW = false;

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

		// super.init();
		this.options = new aMap<String, String>();
		this.options.put("^", "OUT");
		this.options.put("X", "EXIT");

		this.options.put("1", "DEPOSIT");
		this.options.put("2", "WITHDRAW");
		// this.options.put("2", "CLOSE ACCT"); //call customer service for that lol

	}

	/////////////////

	@Override
	public void render() {
		super.render();

		Log("___________");
		Log(this.options.toString());
		Log("");
	}

	@Override
	public boolean handle(String inp) {

		if (super.handle(inp))
			return true;

		return false;
	}

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
		float current = as.Balance();
		
		
		String query = "SELECT * FROM users WHERE email=? AND password=?";		
		Connection connection = BankDirector.DB_Link;
		


		BankDirector.Accounts.update(as.Index(), as);
	}

}
