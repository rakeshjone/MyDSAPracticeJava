package Stack;

public class MyQueue <V>{
    int maxSize;
    int currSize;
    int front;
    int back;
    V[] arr;

    MyQueue(int maxSize) {
        this.maxSize = maxSize;
        currSize = 0;
        front = 0;
        back = -1;
        arr = (V[]) new Object[maxSize];
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrSize() {
        return currSize;
    }

    public boolean isEmpty() {
        return currSize==0;
    }

    public boolean isFull() {
        return currSize == maxSize;
    }

    public V top() {
        return arr[front];
    }

    //add to queue
    public void enQueue(V data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        //keep index in range
        back = (back+1)%maxSize;
        arr[back] = data;
        currSize++;
    }

    public V deQueue() {
        if (isEmpty()){
            return null;
        }
        V temp = arr[front];
        front = (front+1)%maxSize;
        currSize--;

        return temp;
    }
}
