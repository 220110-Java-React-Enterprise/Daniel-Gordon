package Core;

import static Core.AppUtils.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {

	public static void main(String[] args) {
		Log("---");
		createNewDatabase("RevDB.db");
		Log("___");
	}

	public static void createNewDatabase(String fileName) {


		String url = "jdbc:sqlite:C:\\Users\\SU\\" + fileName;

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

}
