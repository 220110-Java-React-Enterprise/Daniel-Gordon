package com.Rev.Core._Banko.Util;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Pattern;

public class StringUtils {

	public static final String emailRegexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	
	public static String toName(String str)
	{
		String s = str.substring(0,1).toUpperCase();
		String tr = str.substring(1);
		return s+tr;
	}
	
	public static String toMoney(float amt)
	{
		Locale locale = new Locale("en", "US");      
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		return(currencyFormatter.format(amt));
	}
	
	public static boolean validEmail(String emailAddress) {
		return patternMatches(emailAddress, emailRegexPattern);
	}

	public static boolean patternMatches(String emailAddress, String regexPattern) {
		return Pattern.compile(regexPattern).matcher(emailAddress).matches();
	}
	
}
