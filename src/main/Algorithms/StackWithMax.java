public class StackWithMax {
    private Node head;
    private int maximum = 0;
    private int pointer = 0;

    public StackWithMax() {
    }

    public void push(final Integer value) {
        if (value >= maximum) {
            maximum = value;
        }
        if (head == null) {
            head = new Node(value);
        } else {
            Node newHead = new Node(value);
            newHead.next = head;
            head = newHead;
        }
        pointer++;
    }

    public int pop() {
        int removedData;
        if (pointer == 0) {
            removedData = Integer.MIN_VALUE;
        } else if (pointer == 1) {
            removedData = head.data;
            head = null;
        } else {
            removedData = head.data;
            head = head.next;
        }
        pointer--;
        if (maximum == removedData) {
            maximum = Integer.MIN_VALUE;
        }
        findMax();
        return removedData;
    }

    private void findMax() {
        Node current = head;
        while (current != null) {
            if (current.data > maximum) {
                maximum = current.data;
            }
            current = current.next;
        }
    }

    private class Node {
        private int data;
        private Node next;
        public Node(final int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        StackWithMax test = new StackWithMax();
        test.push(1);
        test.push(0);
        test.push(2);
        test.push(20);
        test.pop();
        test.pop();
        System.out.println(test.maximum);
    }
}

