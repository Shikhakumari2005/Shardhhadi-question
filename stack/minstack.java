import java.util.*;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    // Constructor
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push element
    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // Pop element
    public void pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is Empty!");
            return;
        }

        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }

        stack.pop();
    }

    // Return top element
    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }
        return stack.peek();
    }

    // Return minimum element
    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }
        return minStack.peek();
    }

    // Display Main Stack
    public void displayStack() {
        System.out.println("Main Stack : " + stack);
    }

    // Display Min Stack
    public void displayMinStack() {
        System.out.println("Min Stack  : " + minStack);
    }

    public static void main(String[] args) {

        MinStack ms = new MinStack();

        System.out.println("Push 5");
        ms.push(5);
        ms.displayStack();
        ms.displayMinStack();
        System.out.println("Minimum = " + ms.getMin());
        System.out.println();

        System.out.println("Push 3");
        ms.push(3);
        ms.displayStack();
        ms.displayMinStack();
        System.out.println("Minimum = " + ms.getMin());
        System.out.println();

        System.out.println("Push 7");
        ms.push(7);
        ms.displayStack();
        ms.displayMinStack();
        System.out.println("Minimum = " + ms.getMin());
        System.out.println();

        System.out.println("Push 2");
        ms.push(2);
        ms.displayStack();
        ms.displayMinStack();
        System.out.println("Minimum = " + ms.getMin());
        System.out.println();

        System.out.println("Top Element = " + ms.top());
        System.out.println();

        System.out.println("Pop");
        ms.pop();
        ms.displayStack();
        ms.displayMinStack();
        System.out.println("Minimum = " + ms.getMin());
        System.out.println();

        System.out.println("Pop");
        ms.pop();
        ms.displayStack();
        ms.displayMinStack();
        System.out.println("Minimum = " + ms.getMin());
    }
}