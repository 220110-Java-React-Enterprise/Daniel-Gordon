package com.Rev.Core._Banko.MGMT;

import static com.Rev.Core.AppUtils.*;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.Rev.Core._Banko._Account;
import com.Rev.Core._Banko._UserProfile;
import com.Rev.Core._PRIM.aList;
import com.Rev.Core._PRIM.aSet;

public class AccountManager {

	public static Connection DB_Link; // find/create

	private aSet<_Account> AccountCache;
	private aList<_UserProfile> UserCache;

	public AccountManager() {

		// get or create
		// this.createNewDatabase("RevDB.db");
		DB_Link = getOrCreate();

	}

	public void update(float deltaTime) {

	}

	public static Connection getOrCreate() {
		Connection connection = null;
		// get

		if (connection == null) {
			connection = createNewDatabase("RevDB.db");
			// fill
			_fillAccounts(connection);
			_fillUsers(connection);
			return connection;
		}
		return null;
	}

	public static Connection createNewDatabase(String fileName) {

		String url = "jdbc:sqlite:C:\\Users\\Public\\REV\\" + fileName; // <storage path

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DB_Link = conn;
				DatabaseMetaData meta = conn.getMetaData();
				Log("The driver name is " + meta.getDriverName());
				Log("A new database has been created.");
				return conn;
			}

		} catch (SQLException e) {
			Log(e.getMessage());
		}

		// build schema
		return null;
	}

	private static void _fillAccounts(Connection connection) {

	}

	private static void _fillUsers(Connection connection) {

	}

}
