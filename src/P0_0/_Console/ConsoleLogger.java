package Core._Console;

import static Core.AppUtils.*;

import Core.App;
import Core._PRIM.aList;

public class ConsoleLogger {

	public boolean active = true;
	public static ConsoleLogger DefaultLogger;
	private static aList<String> pending = new aList<String>();
	private static aList<String> toLog = new aList<String>();

	App owner;

	public ConsoleLogger(App owner) {
		DefaultLogger = this;
		this.owner = owner;

	}

	public static void logOut(String log) {

		Log(log);
	}

	public static void logOut() {
		for (String p : pending) {
			toLog.add(p);
		}
		for (String s : toLog) {
			Log(s);
		}
		toLog.clear();
	}

	public static void toLog(String to) {

		pending.add(to);
		// scan toLog list for Commands

	}

	public static void toLog(Object o) {
		pending.add(o.toString());
	}

	public static void toLog(Object[] os) {
		String res = "";
		for (int i = 0; i < os.length; i++) {
			res += "[" + i + "]: " + os[i].toString() + "\n";
		}
		pending.add(res);
	}

	public static void toLog(aList<String> to) {
		for (String s : to) {
			pending.add(s);
		}
	}

}
