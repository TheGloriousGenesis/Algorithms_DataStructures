package DequesAndRandomizedQueues;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] queue;
    private int size = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {
        this.queue = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return this.size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return this.size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (this.size == this.queue.length) {
            resize(2 * this.queue.length);
        }
        queue[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        // switch element in random position with last element. Then remove and return.
        int randIndex = StdRandom.uniform(size);
        Item item = this.queue[randIndex];
        this.queue[randIndex] = this.queue[--size];
        this.queue[size] = null;
        if (this.size > 0 && this.size == this.queue.length/4) {
            resize(this.queue.length/2);
        }
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.queue[StdRandom.uniform(size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < this.size; i++) {
            copy[i] = this.queue[i];
        }
        this.queue = copy;
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private final Item[] shuffledArray;

        private int arraySize = size;

        public RandomizedQueueIterator() {
            this.shuffledArray = queue.clone();
            shuffle(this.shuffledArray);
        }

        @Override
        public boolean hasNext() {
            return arraySize > 0;
        }

        @Override
        public Item next() {
            if (arraySize == 0) {
                throw new NoSuchElementException();
            }
            return queue[--arraySize];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public void shuffle(Item[] array) {
            int n = array.length;
            for (int i = 0; i < n; i++) {
                int r = i + (int) (Math.random() * (n - i));
                Item swap = array[r];
                array[r] = array[i];
                array[i] = swap;
            }
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> test = new RandomizedQueue<>();
        test.enqueue("Hello");
        test.enqueue("My");
        test.enqueue("Name");
        System.out.println(test.sample());
        // Random assortment of elements
        test.iterator().forEachRemaining(System.out::println);
        test.iterator().forEachRemaining(System.out::println);
        test.dequeue();
        test.dequeue();
        // 1
        System.out.println(test.size());
        test.dequeue();
        // true
        System.out.println(test.isEmpty());
    }

}
