package polytech.pile.observers;

import java.util.List;

import javax.swing.*;

import polytech.pile.subject.Stack;

/**
 * 
 * @author Peng Hanyuan & Wang Tianxue
 *
 */
public class ViewSummit extends JFrame implements Observer {

	private Stack stack; // the object Stack
	private List<Integer> data; // the list of 5 integers
	private JLabel myLabel;
	private JPanel myPane;

	/**
	 * Constructor
	 * 
	 * @param stack
	 */
	public ViewSummit(Stack stack) {
		super("Summit");
		this.stack = stack;

		setSize(400, 200);
		setLocation(100, 300);
		myPane = new JPanel();
		setContentPane(myPane);
		myLabel = new JLabel();
		myPane.add(myLabel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Function for displaying the summit of the stack
	 */
	@Override
	public void display() {
		if (!data.isEmpty()) {
			myLabel.setText("The summit: " + this.data.get(0));
		} else {
			myLabel.setText("An empty stack !");
		}
	}

	/**
	 * Function for updating the stack
	 */
	@Override
	public void update() {
		this.data = this.stack.getList();
		this.display();
	}

}
