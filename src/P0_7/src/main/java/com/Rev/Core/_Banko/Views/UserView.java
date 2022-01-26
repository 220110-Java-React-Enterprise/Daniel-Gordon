package com.Rev.Core._Banko.Views;

import static com.Rev.Core.AppUtils.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Rev.Core.Console.ConsoleUI;
import com.Rev.Core.Console.UI.aConsoleView;
import com.Rev.Core.Primitive.aMap;
import com.Rev.Core.Primitive.aMultiMap;
import com.Rev.Core.Primitive.aSet;
import com.Rev.Core.Primitive.Data.aDataField;
import com.Rev.Core._Banko.BankDirector;
import com.Rev.Core._Banko.Data._Account;

public class UserView extends aConsoleView {

	// private aMultiMap<Integer, aDataField> accountCache = new aMultiMap<Integer,
	// aDataField>();
	private aSet<_Account> accountCache = new aSet<_Account>();
	private aSet<_Account> accountPage = new aSet<_Account>();
	private int page = 0;
	
	
	public UserView(ConsoleUI manager) {
		super(manager);

	}

	// show 4 accounts per page

	@Override
	public void init() {
		// super.init();
		this.cacheAccounts();
		this.options = new aMap<String, String>();
		this.options.put("^", "OUT");
		this.options.put("X", "EXIT");

		if (accountCache.getSize() > 4) {
			this.options.put("<", "PREV");
			this.options.put(">", "NEXT");
		}

		this.options.put("1", "VIEW ACCT");
		this.options.put("1", "OPEN ACCT");
		
	}

	@Override
	public void render() {
		super.render();
		// data
		// input options
		//int startInd = page*4;
		//int pg = Math.min(4, accountPage.getSize()-startInd);
		Log("Accounts: ");
		for (int i = 0; i < accountCache.getSize(); i++) {
			Log(accountCache.get(i));
		}
		Log("___________");
		Log(this.options.toString());
		Log("");
	}

	@Override
	public boolean handle(String inp) {

		if (super.handle(inp))
			return true;

		if(inp.equals("<"))
			Log("[<]placeholder");
		if(inp.equals(">"))
			Log("[>]placeholder");
		
		if (inp.equals("1")) {
			this.manager.Session.setView(new NewAccountForm(this.manager));
			return true;
		}

		return false;
	}

	private void cacheAccounts() {
		// get all accounts belonging to this user via junction table
		// get account_ids belonging to this user_id
		// get accounts by those ids
		Connection connection = BankDirector.DB_Link;
		String query = "SELECT * FROM accounts WHERE owner_ID=?";
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, this.manager.Session.loggedAs.Index());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				//Log("--------"); // so account gets properly, now append them all
				int u_id = rs.getInt("owner_id");
				int type = rs.getInt("type");
				float bal = rs.getFloat("balance");
				int actnum = rs.getInt("account_num");
				_Account acct = new _Account(u_id,type,bal,actnum);
				this.accountCache.append(acct);
				//Log("--------" + acct);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterFunds(float amount) {
		// CRUD update
		// if field not null && not " ";
	}



}
