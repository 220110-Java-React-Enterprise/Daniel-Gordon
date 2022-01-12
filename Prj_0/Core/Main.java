package Core;

import static Core.AppUtils.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import Core._PRIM.aList;

public class Main {

	public aList<Float> flts;
	public boolean running = false;
	public static App Main;

	public static void main(String[] args) {
		Log("---");
		// 
		Main = new App();
		Log("___");
	}



}
