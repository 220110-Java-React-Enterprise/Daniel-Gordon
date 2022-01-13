package Core._Banko;

import java.util.Date;

import Core._PRIM.aList;

public class _CustomerProfile {

	public String name;
	public String email;
	public aList<_Account> accounts;
	
	public Date customerFrom;

	public _CustomerProfile(String name, String email) {
		this.name = name;
		this.email = email;
		this.accounts = new aList<_Account>();
	}
	
	
}
