package Core._Console.UI;

import static Core.AppUtils.*;
import static Core._Console.ConsoleUI.*;

import Core._Console.ConsoleUI;
import Core._PRIM.aMap;
import Core._PRIM.A_I.iCollection;

public class ConsoleView implements iConsoleListener {

	protected ConsoleUI manager;

	protected aMap<String, String> options;

	public ConsoleView(ConsoleUI manager) {
		this.manager = manager;
		this.options = new aMap<String, String>();

	}

	protected void init() {
		if (ConsoleUI.PreviousView != null)
			this.options.put("<", "BACK");
	}

	public boolean input(String inp) {
		Log(this.getClass().getSimpleName() + ":> " + inp);
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
		if (inp.equals("<") || inp.equals("BACK")) {
			this.manager.back();
			return true;
		}
		return false;
	}

	public void renderFrame() {
		Page();
		Log("[" + this.getClass().getSimpleName() + "]");
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

	}

}
