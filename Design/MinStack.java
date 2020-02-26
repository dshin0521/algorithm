package Design;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 * Implement the following methods:
 * class MinStack {
 *     public MinStack() {}
 *
 *     public void push(int x) {}
 *
 *     public void pop() {}
 *
 *     public int top() {}
 *
 *     public int getMin() {}
 * }
 */
public class MinStack {
	int min;
	Stack<Integer> stack;
	public MinStack() {
		this.min  = Integer.MAX_VALUE;
		this.stack = new Stack<>();
	}

	public void push(int x) {
		// only push the old minimum value when the current
		// minimum value changes after pushing the new value x
		if(x <= min){
			stack.push(min);
			min=x;
		}
		stack.push(x);
	}

	public void pop() {
		// if pop operation could result in the changing of the current minimum value,
		// pop twice and change the current minimum value to the last minimum value.
		if(stack.pop() == min) {
			min=stack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(11);
		minStack.push(12);
		minStack.push(13);
		minStack.push(10);
		minStack.push(9);
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());

	}
}
