package polytech.pile.observers;

import java.util.List;

import polytech.pile.subject.Stack;

public class ViewBase implements Observer {

	private Stack stack;
	private List<Integer> data;

	public ViewBase(Stack stack) {
		this.stack = stack;
	}

	@Override
	public void display() {
		System.out.print("Last five: [");
		for(int i: this.data){
			System.out.print(i+" ");
		}
		System.out.println("]");
	}

	@Override
	public void update() {
		this.data = this.stack.getLastFive();
		this.display();
	}

}
