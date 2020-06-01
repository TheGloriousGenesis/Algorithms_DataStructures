import java.util.Stack;

public class QueueWithTwoStacks {
    public Stack<Integer> temp = new Stack<>();
    public Stack<Integer> mockQueue = new Stack<>();

    public void enqueue(final Integer value) {
        for (int i=1; i <= mockQueue.size(); i++) {
            temp.add(mockQueue.pop());
        }
        temp.add(value);

    }

    public Integer dequeue() {
        for (int i=1; i <= temp.size(); i++) {
            mockQueue.add(temp.pop());
        }
        return mockQueue.pop();
    }
}

