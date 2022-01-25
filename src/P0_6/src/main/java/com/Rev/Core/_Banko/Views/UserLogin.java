package com.Rev.Core._Banko.Views;

import static com.Rev.Core.AppUtils.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Rev.Core._Banko.BankDirector;
import com.Rev.Core._Banko.DBMS._User;
import com.Rev.Core._Banko.Util.StringUtils;
import com.Rev.Core._Console.ConsoleUI;
import com.Rev.Core._Console.UI.ConsoleView;

public class UserLogin extends ConsoleView {

	private String Email = "";
	private String Password = "";

	private boolean dioEM = false;
	private boolean dioPW = false;

	public UserLogin(ConsoleUI manager) {
		super(manager);
	}

	@Override
	public void init() {
		super.init();

		this.options.put("1", "EMAIL");
		this.options.put("2", "PASSWORD");
	}

	@Override
	public void renderFrame() {

		// data
		// input options
		super.renderFrame();
		Log("" + dioPW + "  " + dioEM);
		String apOpA = "";
		String apOpB = "";
		if (this.dioEM)
			apOpA = "*";
		if (this.dioPW)
			apOpB = "*";
		// ^none of this * marking shit works right lol

		Log(this.options.toString());
		Log(apOpA + "EMAIL: " + this.Email);
		Log(apOpB + "PASS: " + this.Password);

		Log("");
		dioEM = false;
		dioPW = false;
	}

	@Override
	public boolean handle(String inp) {

		if (super.handle(inp))
			return true;

		if (dioEM)
			this.Email = inp;
		if (dioPW)
			this.Password = inp;

		if (inp.equals("") || inp.equals(" ") || inp.equals(".") || inp == null) {
			Log("TRY LOGIN>");
			this.tryLogin();
			return true;
		}
		if (inp.equals("1") || inp.equals("EMAIL")) {
			Log("ENTER EMAIL: ");
			this.dioEM = true;
			return dioEM;
		}
		if (inp.equals("2") || inp.equals("PASSWORD")) {
			Log("ENTER PASSWORD: ");
			this.dioPW = true;
			return dioPW;
		}

		this.renderFrame();

		return false;
	}

	@Override
	public void dispose() {
		super.dispose();
		dioEM = false;
		dioPW = false;
		this.Email = "";
		this.Password = "";
	}

	private void tryLogin() {

		String query = "SELECT * FROM users WHERE email=? AND password=?";

		Connection connection = BankDirector.DB_Link;
		try {

			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, Email);
			pst.setString(2, Password);

			ResultSet rs = pst.executeQuery();
			Log(rs.getFetchSize());

			int i = -1;
			while (rs.next()) {
				i++;
				Log("--[" + rs.getInt(1) + "]" + rs.getString("email"));
			}
			if (i == -1) {
				Log("USER NOT FOUND");
				// Log(_User.getUserIndex().toString());
				// Log("------------------");
				// Log(StringUtils.toMoney(8675309.21f));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
