package Stack;

public class MyStack <V>{
    V[] arr;
    int maxSize;
    int top;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        arr = (V[]) new Object[maxSize];
        top = -1;
    }

    public int getCapacity() {
        return maxSize;
    }

    public boolean isEmpty() {
        return top==-1;
    }

    public boolean isFull() {
        return top==maxSize-1;
    }

    public V top() {
        if (isEmpty()) {
            return null;
        } else {
            return arr[top];
        }
    }

    public void push(V data) {
        if (isFull()) {
            System.out.println("stack is full");
            return;
        }
        arr[++top] = data;
    }

    public V pop() {
        if (isEmpty()) {
            System.out.println("Empty stack");
            return null;
        }
        return arr[top--];
    }

}
