package Core;

import static Core.AppUtils.*;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import Core._Banko.MGMT.AccountManager;
import Core._Console.Console;
import Core._PRIM.aSet;
import Core._PRIM.aMap;
import Core._PRIM.aList;

public class App {

	public static App Current;
	public boolean running;
	private long prevTime = System.nanoTime();
	private float deltaTime = 0f;

	public static Console AppConsole;
	public static Connection DB_Link;

	public AccountManager Accounts;

	aList<Integer> S = new aList<Integer>();
	aSet<Integer> L = new aSet<Integer>();
	aMap<String, String> M = new aMap<String, String>();

	public App() {
		App.Current = this;
		this.running = true;
		AppConsole = new Console(Current);
		this.createNewDatabase("RevDB.db");
		this.Accounts = new AccountManager();

		genTestList();
		genTestMap();

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
			logTestList();
			logTestMap();
			Log(this.toLog());
		}

	}

	public void terminate() {
		this.running = false;
		this.dispose();
		System.exit(0);
	}

	public void dispose() {
		Log("D-------------------------------------------------------G");

	}

	public String toLog() {
		String log = "\n";
		log += this.Accounts + "\n";
		log += this.DB_Link + "\n";
		return log;
	}

	////////////////

	public static void createNewDatabase(String fileName) {

		String url = "jdbc:sqlite:C:\\Users\\SU\\" + fileName; // <storage path

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DB_Link = conn;
				DatabaseMetaData meta = conn.getMetaData();
				Log("The driver name is " + meta.getDriverName());
				Log("A new database has been created.");
			}

		} catch (SQLException e) {
			Log(e.getMessage());
		}

	}

	private static class ShutDownHook extends Thread {
		public void run() {
			Current.terminate();
		}
	}

	private void SEC0_TESTING() {
	}

	public void genTestList() {
		L = new aSet<Integer>();
		L.add(1);
		L.add(1);
		L.add(32);
		L.add(64);
		L.add(666);
		L.remove(2);
	}

	public void logTestList() {
		Log();
		Log("for{");
		Log(L);
		Log("forEach{");
		for (Integer i : this.L) {
			Log("*[" + L.indexOf(i) + "]" + i);
		}
	}

	public void genTestMap() {
		M = new aMap<String, String>();
		M.put("A", "1");
		M.put("A", "2");
		M.put("A", "1");
		M.put("B", "1");
		M.put("B", "2");
	}

	public void logTestMap() {
		Log();
		Log(M);
	}
}
