package com.Rev.Core._Banko.Views;

import static com.Rev.Core.AppUtils.Log;

import com.Rev.Core._Banko.DBMS._Account;
import com.Rev.Core._Console.ConsoleUI;
import com.Rev.Core._Console.UI.ConsoleView;
import com.Rev.Core._PRIM.aMultiMap;
import com.Rev.Core._PRIM.aSet;
import com.Rev.Core._PRIM.Data.aDataField;

public class UserViewMain extends ConsoleView {

	// private aMultiMap<Integer, aDataField> accountCache = new aMultiMap<Integer,
	// aDataField>();
	private aSet<_Account> accountCache = new aSet<_Account>();

	public UserViewMain(ConsoleUI manager) {
		super(manager);
		this.cacheAccounts();
	}

	@Override
	public void renderFrame() {
		super.renderFrame();
		// data
		// input options

		Log(this.options.toString());
		Log("");
	}

	private void cacheAccounts() {

	}

	public void alterFunds(float amount) {

	}

}
