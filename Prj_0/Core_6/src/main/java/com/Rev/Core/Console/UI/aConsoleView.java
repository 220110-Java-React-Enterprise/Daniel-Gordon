package com.Rev.Core.Console.UI;

import static com.Rev.Core.AppUtils.*;
import static com.Rev.Core.Console.ConsoleUI.*;

import com.Rev.Core.App;
import com.Rev.Core.Console.ConsoleUI;
import com.Rev.Core.Primitive.aMap;
import com.Rev.Core.Primitive.aNode;
import com.Rev.Core.Primitive.A_I.iCollection;
import com.Rev.Core.Primitive.A_I.iDisposable;

public class aConsoleView extends aNode<aConsoleView> implements iConsoleListener, iDisposable {

	protected ConsoleUI manager;
	protected aMap<String, String> options;// temporary

	public aConsoleView(ConsoleUI manager) {
		super();
		this.manager = manager;
		this.options = new aMap<String, String>();

	}

	public void init() {
		if (manager.Session.Previous != null)
			this.options.put("<", "BACK");
		
		this.options = new aMap<String, String>();
		this.options.put("^", "OUT");
		this.options.put("X", "EXIT");
	}

	public boolean input(String inp) {
		// Log(this.getClass().getSimpleName() + ":> " + inp);
		if (this.handle(inp)) {
			return true;
		}
		this.renderFrame();
		if (this.getSubscribers() != null)
			for (iConsoleListener s : this.getSubscribers()) {
				if (s.input(inp))
					return true;

			}
		return false;
	}

	protected boolean handle(String inp) {
		if (inp.toUpperCase().equals("X") || inp.toUpperCase().equals("EXIT")) {
			App.AppConsole.input("SHELL:TERMINATE");
			return true;
		}

		if (inp.equals("^") || inp.toUpperCase().equals("OUT")) {
			this.manager.Session.returnMain();
			return true;
		}

		if (inp.equals("<") || inp.toUpperCase().equals("BACK")) {
			this.manager.Session.back();
			return true;
		}

		return false;
	}

	public void renderFrame() {
		Page();
		// Log(this.options.toString());
		// Log("[" + this.getClass().getSimpleName() + "]");
	}

	@Override
	public iCollection<iConsoleListener> getSubscribers() {
		// bubbles through members
		// SceneGraph
		return null;
	}

	public void show() {
		this.init();
		Page();
		this.renderFrame();
	}

	public void dispose() {
		this.options.clear();
	}

}