package com.csc;

public class QueueTees<T> {
    private static final int MAX_SIZE = 3;
    private final T[] queue;
    private int head;
    private int tail;
    private int size;

    @SuppressWarnings("unchecked")
    public QueueTees() {
        queue = (T[]) new Object[MAX_SIZE];
        head = 0;
        tail = -1;
        size = 0;
    }

    public void enqueue(T item) {
        if (size == MAX_SIZE) {
            System.out.println("Queue is full! Cannot add more items.");
        } else {
            tail = (tail + 1) % MAX_SIZE;
            queue[tail] = item;
            size++;
        }
    }

    public T dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return null;
        } else {
            T dequeuedItem = queue[head];
            head = (head + 1) % MAX_SIZE;
            size--;
            return dequeuedItem;
        }
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Puppy puppy = new Puppy();
        Kitty kitty = new Kitty();
        Chinchilla chilla = new Chinchilla();

        QueueTees<Cutie> queue = new QueueTees<>();
        System.out.println("Queue size: " + queue.size());

        queue.enqueue(puppy);
        queue.enqueue(kitty);
        queue.enqueue(chilla);
        System.out.println("Queue size: " + queue.size());

        Puppy anotherPuppy = new Puppy();
        queue.enqueue(anotherPuppy);

        Cutie firstOut = queue.dequeue();
        System.out.println("Dequeued: " + firstOut.description());

        Cutie secondOut = queue.dequeue();
        System.out.println("Dequeued: " + secondOut.description());

        Cutie thirdOut = queue.dequeue();
        System.out.println("Dequeued: " + thirdOut.description());
        queue.dequeue();
    }
} 