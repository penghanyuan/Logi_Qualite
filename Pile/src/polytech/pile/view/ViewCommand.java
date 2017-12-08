package polytech.pile.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import polytech.pile.controller.CommandController;
import polytech.pile.observers.ViewBase;
import polytech.pile.observers.ViewSummit;
import polytech.pile.subject.Stack;

/**
 * View of command
 * 
 * @author Peng Hanyuan & Wang Tianxue
 *
 */
public class ViewCommand extends JFrame{

	Stack stack;

	/**
	 * Function for inputting the command line
	 * 
	 */
	public void input() {
		String command;
		Scanner scanner = new Scanner(System.in);
		CommandController cc = new CommandController();
		cc.help();
		while (true) {
			command = scanner.nextLine();
			cc.parserCommand(command);
		}

	}
}
