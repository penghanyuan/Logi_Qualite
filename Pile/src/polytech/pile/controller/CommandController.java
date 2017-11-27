package polytech.pile.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import polytech.pile.observers.ViewBase;
import polytech.pile.observers.ViewSummit;
import polytech.pile.subject.Stack;

public class CommandController {

	Stack stack;

	public void createStack() {
		this.stack = new Stack();
		this.stack.addObservers(new ViewSummit(this.stack), new ViewBase(this.stack));
	}

	public void parserCommand(String command) {
		Pattern pattern = Pattern.compile("(PUSH\\s)(-?\\d*)");
		Matcher matcher = pattern.matcher(command);

		if (command.equalsIgnoreCase("CREATE")) {
			this.createStack();
			System.out.println("Created!");
		} else if (command.equalsIgnoreCase("POP")) {
			try {
				this.stack.pop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (matcher.find()) {
			int value = Integer.parseInt(matcher.group(2));
			this.stack.push(value);
		} else if (command.equalsIgnoreCase("EXIT")) {
			System.exit(0);
		}
	}
}
