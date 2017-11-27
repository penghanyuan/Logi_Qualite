package polytech.pile.observers;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import polytech.pile.subject.Stack;

public class ViewBase extends JFrame implements Observer {

	private Stack stack;
	private List<Integer> data;
	private JLabel jl;
	private JPanel myPane;

	public ViewBase(Stack stack) {
		super();
		this.stack = stack;

		setSize(400, 450);
		setLocationRelativeTo(null);
		myPane = new JPanel();
		setContentPane(myPane);
		jl = new JLabel();
		myPane.add(jl);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void display() {
		String result = "[";
		System.out.print("Last five: [");
		for (int i : this.data) {
			System.out.print(i + " ");
			result += i + " ";
		}
		result += "]";
		System.out.println("]");
		jl.setText(result);
	}

	@Override
	public void update() {
		this.data = this.stack.getLastFive();
		this.display();
	}

}
