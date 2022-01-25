package com.Rev.Core.Console.UI;

import static com.Rev.Core.AppUtils.*;

import com.Rev.Core.App;
import com.Rev.Core.Console.ConsoleUI;
import com.Rev.Core.Primitive.aLinkedList;
import com.Rev.Core.Primitive.A_I.iCollection;
import com.Rev.Core._Banko.DBMS._User;

public class aUseSession implements iConsoleListener {

	public aConsoleView Root;

	public aConsoleView Current;
	public aConsoleView Previous;

	aLinkedList<aConsoleView> NaigationPath;// <-ToDo

	private _User loggedAs;

	public String as = "null";

	public aUseSession(ConsoleUI handler, aConsoleView root) {
		this.Root = root;

	}

	@Override
	public boolean input(String inp) {
		// Log(this.getClass().getSimpleName() + ":> " + inp);

		if (this.Current != null)
			return this.Current.input(inp);

		return false;
	}

	public void back() {
		if (this.Previous != null) {
			this.setView(this.Previous);
		}
	}

	public void returnMain() {
		this.Previous = null;
		this.setView(this.Root);
	}

	public void exit() {
		App.AppConsole.input("SHELL:TERMINATE");
	}

	public void setView(aConsoleView view) {
		if (this.Current != null) {
			this.Previous = this.Current;
			this.Current.dispose();
		}
		Log("VIEW> " + view.getClass().getSimpleName());
		this.Current = view;
		this.Current.show();

	}

	@Override
	public iCollection<iConsoleListener> getSubscribers() {
		// TODO Auto-generated method stub
		return null;
	}

}
