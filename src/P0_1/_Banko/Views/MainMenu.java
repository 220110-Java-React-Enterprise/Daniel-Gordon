package Core._Banko.Views;

import static Core.AppUtils.*;
import java.awt.*;

import Core._Console.ConsoleUI;
import Core._Console.UI.ConsoleView;
import Core._Console.UI.iConsoleListener;
import Core._PRIM.aMap;

public class MainMenu extends ConsoleView {

	public MainMenu(ConsoleUI manager) {
		super(manager);

		
	}
	
	@Override
	public void init()
	{
		super.init();
		this.options.put("1", "USER");
		this.options.put("2", "MGMT");
	}

	@Override
	public void renderFrame() {
		super.renderFrame();
		// data
		// input options

		Log(this.options.toString());
		Log("");
	}

	@Override
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

	@Override
	public boolean handle(String inp) {
		if(super.handle(inp))
			return true;
		
		//if (Integer.parseInt(inp) == 1) {
		if(inp.equals("1")) {
			this.manager.setView(new UserLogin(this.manager));
			return true;
		}

		//if (Integer.parseInt(inp) == 2) {
		if(inp.equals("2")) {
			this.manager.setView(new BankLogin(this.manager));
			return true;
		}

		this.renderFrame();
		return false;
	}

}
