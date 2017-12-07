package polytech.pile.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import polytech.pile.observers.ViewBase;
import polytech.pile.observers.ViewSummit;
import polytech.pile.subject.Stack;

/**
 * 
 * @author Peng Hanyuan & Wang Tianxue
 *
 */
public class CommandController {

	Stack stack; // the object Stack
	List<String> log;

	public CommandController() {
		log = new ArrayList<String>();
	}

	/**
	 * Function for creating a stack and adding observers to the stack
	 */
	public void createStack() {
		if (this.stack == null) {
			this.stack = new Stack();
			this.stack.addObservers(new ViewSummit(this.stack));
			this.stack.addObservers(new ViewBase(this.stack));
			System.out.println("Stack Created!");
		} else {
			System.out.println("Stack exists!");
		}
	}

	/**
	 * Function for parsing the input command line
	 * 
	 * @param command
	 *            the input command line
	 */
	public void parserCommand(String command) {
		SimpleDateFormat df = new SimpleDateFormat("dd/M/yyyy HH:mm:ss");
		String date = df.format(new Date(System.currentTimeMillis()));

		Pattern pattern = Pattern.compile("((?i)PUSH\\s)(-?\\d*)");
		Matcher matcher = pattern.matcher(command);

		// if (command.equalsIgnoreCase("CREATE")) {
		// this.createStack();
		// } else
		if (this.stack == null)
			this.createStack();
		if (command.equalsIgnoreCase("POP")) {
			try {
				this.stack.pop();
			} catch (Exception e) {
				System.out.println("Can't do POP. Cause:" + e.getMessage());
			}
		} else if (command.equalsIgnoreCase("CLEAR")) {
			this.stack.clear();
		} else if (matcher.find()) {
			int value = Integer.parseInt(matcher.group(2));
			this.stack.push(value);
		} else if (command.equalsIgnoreCase("QUIT")) {
			log.add(date + " " + command);
			this.outputLog();
			System.exit(0);
		} else {
			System.out.println("Command doesn't exist !");
			help();
		}
		log.add(date + " " + command);
	}

	/**
	 * Function for showing the list of commands
	 */
	public void help() {
		System.out.println("#################################################");
		System.out.println("Commands of the App:");
		System.out.println("\tCREATE : Create a stack");
		System.out.println("\tPUSH X : Add the integer X into stack");
		System.out.println("\tPOP : Delete the summit of the stack");
		System.out.println("\tCLEAR : Delete all the integers in the stack");
		System.out.println("\tQUIT : Quit the App");
		System.out.println("#################################################");
	}

	public void outputLog() {

		File file = new File("Log_Pile.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		OutputStream os;
		try {
			os = new FileOutputStream(file);
			for (String s : log) {
				s += "\n";
				byte b[] = s.getBytes();
				os.write(b, 0, s.length());
			}
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
