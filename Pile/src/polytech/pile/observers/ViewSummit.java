package polytech.pile.observers;

import java.util.List;

import polytech.pile.subject.Stack;

public class ViewSummit implements Observer {
	
	private Stack stack;
	private Integer data;
	
	public ViewSummit(Stack stack) {
		this.stack = stack;
	}

	@Override
	public void display() {
		System.out.println("The summit: " + this.data.toString());

	}

	@Override
	public void update() {
		this.data = this.stack.getSummit();
		this.display();

	}

}
