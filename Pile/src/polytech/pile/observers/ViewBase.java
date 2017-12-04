package polytech.pile.observers;

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

	/**
	 * Constructor
	 * 
	 * @param stack
	 */
	public ViewBase(Stack stack) {
		super("Last Five");
		this.stack = stack;

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
		String result = "[";
		for (int i = this.data.size() - 5 < 0 ? 0 : this.data.size() - 5; i < this.data.size(); i++) {
			result += this.data.get(i) + " ";
		}
		result += "]";
		myLabel.setText(result);
	}

	/**
	 * Function for updating the stack
	 */
	@Override
	public void update() {
		int j = 0;
		//需要改一下更改条件
		for (int i = this.stack.getList().size() - 5 < 0 ? 0 : this.stack.getList().size() - 5; i < this.stack.getList()
				.size(); i++) {
			if (this.data.get(j) != this.stack.getList().get(i)) {
				this.data.set(j, this.stack.getList().get(i));
				this.display();
			}
			j++;
		}

	}

}
