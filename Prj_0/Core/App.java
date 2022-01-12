package Core;

import static Core.AppUtils.*;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;

import Core._PRIM.aList;

public class App {

	public static App Current;
	public boolean running;
	private long prevTime = System.nanoTime();
	private float deltaTime = 0f;

	aList<Integer> L = new aList<Integer>();

	public App() {
		App.Current = this;

		this.createNewDatabase("RevDB.db");

		L = new aList<Integer>();
		L.add(1);
		L.add(32);
		L.add(64);
		L.add(666);
		L.remove(2);

		this.running = true;
		try {
			this.loop();
		} finally {
			this.dispose();
		}
	}

	public void loop() {
		while (this.running) {
			long time = System.nanoTime();
			float dT = ((time - prevTime) / 1000000f);
			prevTime = time;
			this.deltaTime = dT;
			Log(getDeltaTime());
			Log(L);
			Log("  " + L.get(1));

			for (Integer i : this.L) {
				Log("*" + i);
			}

		}
		this.dispose();
	}

	public void terminate() {
		this.running = false;
		this.dispose();
	}

	public void dispose() {
		Log("D-------------------------------------------------------");
	}

	public float getDeltaTime() {
		return this.deltaTime;
	}

	////////////////

	public static void createNewDatabase(String fileName) {

		String url = "jdbc:sqlite:C:\\Users\\SU\\" + fileName; // <storage path

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
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
}
