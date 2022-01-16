package Core;

import static Core.AppUtils.*;

import Core._Banko.MGMT.AccountManager;
import Core._Console.Console;
import Core._Console.ConsoleUI;
import Core._Console.UI.iConsoleListener;
import Core._Math.Maths;
import Core._Math.aVector;
import Core._PRIM.aSet;
import Core._PRIM.A_I.iCollection;
import Core._PRIM.aMap;
import Core._PRIM.aMultiMap;
import Core._PRIM.aNode;
import Core._PRIM.aConnection;
import Core._PRIM.aLinkedList;
import Core._PRIM.aList;

public class App implements iConsoleListener {

	public static App Current;
	public boolean running;
	private long prevTime = System.nanoTime();
	private float deltaTime = 0f;

	public static Console AppConsole;
	public static ConsoleUI UI;

	public AccountManager Accounts;

	aSet<Integer> S = new aSet<Integer>();
	aList<Integer> L = new aList<Integer>();
	aLinkedList<Integer> LL = new aLinkedList<Integer>();
	aMap<String, String> M = new aMap<String, String>();
	aMultiMap<String, String> MM = new aMultiMap<String, String>();

	aNode N1;
	aNode N2;
	aNode N3;

	public App() {
		System.setProperty("java.awt.headless", "true");
		App.Current = this;
		this.running = true;
		this.Accounts = new AccountManager();

		AppConsole = new Console(Current);
		UI = new ConsoleUI();
		AppConsole.getSubscribers().append(this);

		genTestSet();
		genTestList();
		genTestLinkedList();
		genTestMap();
		genTestMultiMap();
		genTestNodes();
		try {
			this.loop();
		} finally {
			this.dispose();
		}
	}

	public float getDeltaTime() {
		return this.deltaTime;
	}

	public void loop() {
		while (this.running) {
			long time = System.nanoTime();
			float dT = ((time - prevTime) / 1000000f);
			prevTime = time;
			this.deltaTime = dT;
			// Log(getDeltaTime());
			// logTestSet();
			// logTestList();
			// logTestLinkedList();
			// logTestMap();
			// logTestMultiMap();
			// Log(this.toLog());
			// logTestNodes();

			// aTransaction.Type T = aTransaction.Type.Deposit;
			// Log(T.getDirection() + " " + T.signum());
			// T = aTransaction.Type.Withdrawal;
			// Log(T.getDirection() + " " + T.signum());

			// aVector V = new aVector(1, 5, 7, 9);
			// V.append(3.1f);
			// Log(V);
			// Log("" + Maths.round(5.55f, 2));
		}

	}

	public void terminate() {
		this.running = false;
		this.dispose();
		System.exit(0);
	}

	public void dispose() {
		AppConsole.IO.dispose();
		Log("D-------------------------------------------------------G");

	}

	@Override
	public boolean input(String inp) {
		Log(this.getClass().getSimpleName() + ":" + inp);
		UI.input(inp);

		return false;
	}

	@Override
	public iCollection<iConsoleListener> getSubscribers() {

		return UI.getSubscribers();
	}

	public String toLog() {
		String log = "\n";
		log += this.Accounts + "\n";
		log += this.Accounts.DB_Link + "\n";
		log += UI.CurrentView + "\n";
		log += "o<[" + UI.CurrentView.getClass().getSimpleName() + "]\n";
		if (UI.PreviousView != null)
			log += "o<  [" + UI.PreviousView.getClass().getSimpleName() + "]\n";
		return log;
	}

	////////////////

	private static class ShutDownHook extends Thread {
		public void run() {
			Current.terminate();
		}
	}

	private void SEC0_TESTING() {
	}

	public void genTestSet() {
		S = new aSet<Integer>();
		S.append(1, 1);
		S.append(1);
		S.append(32);
		S.append(64);
		S.append(666);

	}

	public void genTestList() {
		L = new aList<Integer>();
		L.append(1, 1);
		L.append(1);
		L.append(32);
		L.append(64);
		L.append(666);

		L.insert(42, 1);
		L.remove(0);
		L.set(0, 100);

		// L.clear();
	}

	public void genTestLinkedList() {
		LL = new aLinkedList<Integer>();
		LL.append(1, 1);
		LL.append(1);
		LL.append(32);
		LL.append(64);
		LL.append(666);

		// L.clear();
		logTestLinkedList();
		Log(">> " + LL.get(4));
		LL.set(4, 777);
		Log(">> " + LL.get(4));
		Log(LL.contains(404) + " / " + LL.contains(777));

	}

	public void genTestMap() {
		M = new aMap<String, String>();
		M.put("A", "1");
		M.put("A", "2");
		M.put("A", "1");
		M.put("B", "1");
		M.put("B", "2");
		M.put("A", "5");
		M.put("A", "5");
		M.put("A", "1");

	}

	public void genTestMultiMap() {
		MM = new aMultiMap<String, String>();
		MM.put("A", "1");
		MM.put("A", "2");
		MM.put("A", "1");
		MM.put("B", "1");
		MM.put("B", "2");
		MM.put("A", "5");
		MM.put("A", "5");
		MM.put("A", "1");

	}

	public void genTestNodes() {
		this.N1 = new aNode("Node1");
		this.N2 = new aNode(42);
		this.N3 = new aNode(new aList<Float>(1f, 2f, 3f));
	}

	public void logTestSet() {
		Log("aSet>>");
		Log("for{");
		Log(S);
		Log("forEach{");
		for (Integer i : this.S) {
			Log("*[" + S.indexOf(i) + "]" + i);
		}
		Log("----");
	}

	public void logTestList() {
		Log("aList>>");
		Log("for{");
		Log(L);
		Log("forEach{");
		for (Integer i : this.L) {
			Log("*[" + L.indexOf(i) + "]" + i);
		}
		Log("     -0 " + L.getLast());
		Log("----");
	}

	public void logTestLinkedList() {
		Log("aLinkedList>>");
		Log("for{");
		Log(LL);
		Log("forEach[" + LL.getSize() + "]{");

		for (Object o : this.LL) {

			// Log("*" + o);
			aNode n = (aNode) o;
			Log("*[" + LL.indexOf(n) + "]" + o);
			if (n.has("NEXT")) {
				aNode next = ((aConnection) n.connections.get("NEXT")).target;
				Log("    <NEXT>=> [" + LL.indexOf(next) + "]" + next);
			}

		}

		// Log(" -0 "+LL.getLast());
		Log("----");
		Log(LL.first.toLog());

		Log("________");
	}

	public void logTestMap() {
		// needs to sort lol
		Log("aMap>>");
		Log(M);
		Log("All: A");
		aList r = M.pull("A");
		Log(r);
		Log("----");

	}

	public void logTestMultiMap() {
		// needs to sort lol
		Log("aMultiMap");
		Log(MM);
		Log("All: A");
		// aList r = (aList) MM.pull("A");
		Log(MM.pull("A"));
		// Log(MM.pull("A").get(2));
		Log(">" + MM.get("A", 2));
		Log("----");
		// MM.clear();
		// Log(MM);

	}

	public void logTestNodes() {
		// Log(N1 + " " + N1.get().toString());
		// Log(N2 + " " + N2.get().toString());
		// Log(N3 + " " + N3.get().toString());
		Log(N1.toLog());
		Log(N2.toLog());
		Log(N3.toLog());
		Log();
	}

}
