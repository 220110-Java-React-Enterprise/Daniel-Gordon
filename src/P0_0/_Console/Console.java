package Core._Console;

import static Core.AppUtils.*;

import java.io.IOException;
import java.util.Map;

import Core.App;

public class Console {

	// holds the input thread

	protected App Target;
	public static ConsoleLogger Logger;
	public ConsoleIO IO;

	protected Thread ConsoleInputThread;
	public boolean echo = true;

	public Console(App target) {
		this.Target = target;
		this.IO = new ConsoleIO(target);
		Logger = new ConsoleLogger(target);

		ConsoleInputThread = new Thread("ConsoleThread") {
			@Override
			public void run() {
				if (Target == null && App.Current != null)
					Target = App.Current;
				if (Target.running) {
					try {
						Console.this.consoleLoop();
					} catch (Throwable t) {
						throw new RuntimeException(t);
					}
				}
			}
		};
		ConsoleInputThread.start();
	}

	public void consoleLoop() throws IOException {
		System.out.println("_CONSOLE LOOP START");
		String tmp = ":";
		System.out.flush();
		while (this.Target.running) {// STEP INSTRUCTIONS

			synchronized (IO) {
				tmp = IO.readLine();
				if (tmp.equals("SHELL:TERMINATE")) {
					Log(this.toLog());
					post("SHELL:TERMINATE");
					Target.terminate();
				}

				if (tmp.equals(":LOG") || tmp.equals("")) {
					post(":LOG");
					Log(this.toLog());

				}

				if (tmp.equals("APP:LOG")) {
					Log(App.Current.toLog());
				}

				// post(tmp);

				if (echo)
					System.out.println("$&: [" + tmp + "]");

			}

			System.in.mark(0);
			System.in.reset();

			// System.out.println("Console Loop Executed Successfully");

		}
		System.out.println("Shell Teminated");
	}

	public static void post(String input) {
		if (Logger != null && Logger.active) {
			ConsoleLogger.toLog(input);
			ConsoleLogger.logOut();
		}

	}

	public static void post(Object o) {
		String r = "" + o.toString();
		post(r);
	}

	public String toLog() {

		String log = "";

		log += App.DB_Link;
		log += "\n";
		log += "#ThreadsActive- " + java.lang.Thread.activeCount();
		log += "\n";
		// log += ""+java.lang.Thread.getAllStackTraces();
		Map<Thread, StackTraceElement[]> threads = java.lang.Thread.getAllStackTraces();
		for (Map.Entry<Thread, StackTraceElement[]> t : threads.entrySet()) {

			if (!t.getKey().isDaemon()) {
				log += t.toString();
				log += "\n";
			}

		}
		log += "\n";

		return log;
	}
}
