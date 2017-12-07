package polytech.pile.observers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import polytech.pile.subject.Stack;

/**
 * View of the last five integers in the stack
 * 
 * @author Peng Hanyuan & Wang Tianxue
 *
 */
public class ViewBase extends JFrame implements Observer {

	private Stack stack; // the object Stack
	private List<Integer> data; // the list of 5 integers
	private JLabel myLabel;
	private JPanel myPane;
	int j = 0;

	/**
	 * Constructor
	 * 
	 * @param stack
	 */
	public ViewBase(Stack stack) {
		super("Last Five");
		this.stack = stack;
		this.data = new ArrayList<Integer>();

		setSize(400, 200);
		setLocation(100, 100);
		myPane = new JPanel();
		setContentPane(myPane);
		myLabel = new JLabel();
		myPane.add(myLabel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Function for displaying the last five integers in the stack
	 */
	@Override
	public void display() {

		String result = "The last five: [";
		for (int i = 0; i < this.data.size(); i++) {

			result += this.data.get(i) + " ";
		}
		result += "] ";
		myLabel.setText(result);
	}

	/**
	 * Function for updating the stack
	 */
	@Override
	public void update() {
		if (lastFiveChange()) {
			List<Integer> lastFive = new ArrayList<Integer>();
			for (int i = this.stack.getList().size() - 5 < 0 ? 0 : this.stack.getList().size() - 5; i < this.stack
					.getList().size(); i++) {
				lastFive.add(this.stack.getList().get(i));
			}
			this.data = lastFive;
			this.display();
		}

	}

	private boolean lastFiveChange() {
		List<Integer> lastFive = new ArrayList<Integer>();
		for (int i = this.stack.getList().size() - 5 < 0 ? 0 : this.stack.getList().size() - 5; i < this.stack.getList()
				.size(); i++) {
			lastFive.add(this.stack.getList().get(i));
		}
		System.out.println(lastFive);
		if (lastFive.isEmpty()) {
			return true;
		}
		for (int i = 0; i < lastFive.size(); i++) {
			if (this.data.isEmpty() || lastFive.get(i) != this.data.get(i)) {
				return true;
			}
		}
		return false;

	}

}
