package polytech.pile.observers;

import java.util.List;

import javax.swing.*;

import polytech.pile.subject.Stack;

public class ViewSummit extends JFrame implements Observer {

	private Stack stack;
	private Integer data;
	private JLabel jl;
	private JPanel myPane;

	public ViewSummit(Stack stack) {
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
		System.out.println("The summit: " + this.data.toString());
		jl.setText("The summit: " + this.data.toString());
	}

	@Override
	public void update() {
		try {
			this.data = this.stack.getSummit();
			this.display();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
