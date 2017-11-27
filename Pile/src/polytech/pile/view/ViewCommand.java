package polytech.pile.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import polytech.pile.controller.CommandController;
import polytech.pile.observers.ViewBase;
import polytech.pile.observers.ViewSummit;
import polytech.pile.subject.Stack;

public class ViewCommand {

	Stack stack;

	public void input() {
		String command;
		Scanner scanner = new Scanner(System.in);
		CommandController cc = new CommandController();
		while (true) {
			command = scanner.nextLine();
			cc.parserCommand(command);
		}

	}
}
