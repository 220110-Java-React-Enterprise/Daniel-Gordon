package Core._Console;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import Core.App;



public class ConsoleInputAdapter {

	

	protected BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	protected BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	protected App shell;

	public ConsoleInputAdapter(App shell) {
		this.shell = shell;

	}

	public int read() throws IOException {

		return reader.read();
	}

	public String readLine() throws IOException {

		return reader.readLine();
		
	}

	public void write(String str) throws IOException {
		this.writer.write(str);
	}

	public void writeLine(String str) throws IOException {

		this.write(str);
	}

	
}
