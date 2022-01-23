package com.Rev.Core._Banko.Views;

import static com.Rev.Core.AppUtils.Log;

import java.util.regex.Pattern;

import com.Rev.Core._Console.ConsoleUI;
import com.Rev.Core._Console.UI.ConsoleView;

public class NewUserForm extends ConsoleView {

	// regex is voodoo sorcery lol
	private final String emailRegexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

	private String FirstName = "";
	private boolean dioFN = false;
	private String LastName = "";
	private boolean dioLN = false;
	private String Username = "";
	private boolean dioUN = false;
	private String Email = "";
	private boolean dioEM = false;

	public NewUserForm(ConsoleUI manager) {
		super(manager);

	}

	@Override
	public void init() {
		super.init();

		this.options.put("1", "FIRST_NAME");
		this.options.put("2", "LAST_NAME");
		this.options.put("3", "USERNAME");
		this.options.put("4", "EMAIL");
		this.options.put("C", "-CLEAR-");
		this.options.put(".", "-SUBMIT-");
	}

	@Override
	public void renderFrame() {

		super.renderFrame();

		Log(this.options.toString());
		Log("FIRST_NAME: " + this.FirstName);
		Log("LAST_NAME: " + this.LastName);
		Log("USERNAME: " + this.Username);
		Log("E-MAIL:" + this.Email);

		Log("");
		dioFN = false;
		dioLN = false;
		dioUN = false;
		dioEM = false;
	}

	@Override
	public boolean handle(String inp) {

		if (super.handle(inp))
			return true;

		if (dioFN)
			this.FirstName = inp;
		if (dioLN)
			this.LastName = inp;
		if (dioUN)
			this.Username = inp;
		if (dioEM && validEmail(inp))
			this.Email = inp;

		if (inp.equals(".") || inp.equals("") || inp.equals(" ") || inp == null) {
			Log("TRY SUBMIT>");
			this.submit();
			return true;
		}
		if (inp.equals("1")) {
			Log("ENTER FIRST_NAME: ");
			this.dioFN = true;
			return dioFN;
		}
		if (inp.equals("2")) {
			Log("ENTER LAST_NAME: ");
			this.dioLN = true;
			return dioLN;
		}
		if (inp.equals("3")) {
			Log("ENTER USERNAME: ");
			this.dioUN = true;
			return dioUN;
		}
		if (inp.equals("4")) {
			Log("ENTER EMAIL: ");
			this.dioEM = true;
			return dioEM;
		}

		if (inp.equals("C")) {
			this.clear();
		}

		this.renderFrame();

		return false;
	}

	public void clear() {
		this.FirstName = "";
		this.LastName = "";
		this.Username = "";
		this.Email = "";
	}

	@Override
	public void dispose() {
		super.dispose();
		this.FirstName = "";
		this.LastName = "";
		this.Username = "";
		this.Email = "";
	}

	/////////////////////////////////

	private void submit() {
		// String SQL = "INSERT INTO actor(first_name,last_name) "
		// + "VALUES(?,?)";
		if (this.FirstName.equals("") || this.LastName.equals("") || this.Username.equals("")
				|| this.Email.equals("")) {
			Log("MISSING INFO");
			return;
		}
		Log("INSERT INTO users(FirstName, LastName, Username, Email) VALUES(?,?,?,?)");
	}

	private boolean validEmail(String emailAddress) {
		return patternMatches(emailAddress, emailRegexPattern);
	}

	/////////////////////////////////
	public static boolean patternMatches(String emailAddress, String regexPattern) {
		return Pattern.compile(regexPattern).matcher(emailAddress).matches();
	}

	public void testUsingStrictRegex() {
		String emailAddress = "username@domain.com";

		// Pattern pat = Pattern.compile(regexPattern);
		// boolean rtn = pat.matcher(email).matches();

		boolean rtn = patternMatches(emailAddress, emailRegexPattern);
	}

}
