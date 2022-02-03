package com.Rev.Core._MonDexApp;

import static com.Rev.Core.AppUtils.*;

import com.Rev.Core.App;
import com.Rev.Core.Console.Console;
import com.Rev.Core.Primitive.Data.DATA_CHEATZ;

public class MonDexApp extends App{

	
	public MonDirector Management;
	
	public MonDexApp()
	{
		super();
	}
	
	
	@Override
	public void init()
	{
		super.init();
		Log("-<>-");
		this.Management = new MonDirector();
		Log(this.getClass().getSimpleName());
		Log(">--<");
		Log(DATA_CHEATZ.buildArgsString(5));
		UI = new MonDexUI();
		
		
	}
}
