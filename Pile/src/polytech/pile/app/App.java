package polytech.pile.app;

import polytech.pile.view.ViewCommand;
/**
 * 
 * @author Peng Hanyuan & Wang Tianxue
 *
 */
public class App {
	/**
	 * Main function of the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ViewCommand viewCommand = new ViewCommand();
		viewCommand.input();
	}
}
