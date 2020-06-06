package DequesAndRandomizedQueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Node next;
        Node prev;
        Item item;
        public Node(Item item) {
            this.next = null;
            this.item = item;
            this.prev = null;
        }
    }
    // construct an empty deque
    public Deque() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return this.head == null || this.tail == null;
    }

    // return the number of items on the deque
    public int size() {
        return this.size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (this.head == null) {
            this.head = new Node(item);
            this.tail = head;
            size++;
            return;
        }
        Node oldFirst = this.head;
        Node newFirst = new Node(item);
        newFirst.next = oldFirst;
        oldFirst.prev = newFirst;
        this.head = newFirst;
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (this.tail == null) {
            this.tail = new Node(item);
            this.head = tail;
            size++;
            return;
        }
        Node oldLast = this.tail;
        Node newLast = new Node(item);
        newLast.prev = oldLast;
        oldLast.next = newLast;
        this.tail = newLast;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        Item firstItem = this.head.item;
        this.head = this.head.next;
        if (this.head != null) {
            this.head.prev = null;
        }
        size--;
        return firstItem;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Item lastItem = this.tail.item;
        this.tail = this.tail.prev;
        if (this.tail != null) {
            this.tail.next = null;
        }
        size--;
        return lastItem;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (size == 0) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        // true
        System.out.println(deque.isEmpty());
        deque.addLast("TEST");
        // TEST
        deque.iterator().forEachRemaining(System.out::println);
        deque.removeFirst();
        //
        deque.iterator().forEachRemaining(System.out::println);
        // true
        System.out.println(deque.isEmpty());
        deque.addFirst("Name");
        deque.addFirst("My");
        deque.addFirst("Hello");
        deque.addLast("Is");
        deque.addLast("Ana");
        // Hello My Name is Anna
        deque.iterator().forEachRemaining(System.out::println);
        deque.removeFirst();
        deque.removeLast();
        // My Name Is
        deque.iterator().forEachRemaining(System.out::println);
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        // true
        System.out.println(deque.isEmpty());

    }
}


