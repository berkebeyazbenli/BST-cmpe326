public class stack<T> {
    private int maxSize;
    private int top;
    private T[] stackArray;

    // Stack constructor
    @SuppressWarnings("unchecked")
    public stack(int size) {
        this.maxSize = size;
        this.top = -1;
        this.stackArray = (T[]) new Object[maxSize];
    }

    // adding element to the stack
    public void push(T element) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push element.");
            return;
        }
        stackArray[++top] = element; // Adding element to the stack and increasing top
    }

    // Removing element from the stack
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop element.");
            return null;
        }
        return stackArray[top--]; // Removing element from the stack and decreasing top
    }

    // Getting the top element of the stack
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek element.");
            return null;
        }
        return stackArray[top]; // Getting the top element of the stack
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Number of eleements
    public int size() {
        return top + 1;
    }
}
