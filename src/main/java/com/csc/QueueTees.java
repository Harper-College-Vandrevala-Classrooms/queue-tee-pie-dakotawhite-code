package com.csc;

public class QueueTees {
    private static final int MAX_SIZE = 3;
    private final Cutie[] queue;
    private int head;
    private int tail;
    private int size;

    public QueueTees() {
        queue = new Cutie[MAX_SIZE];
        head = 0;
        tail = -1;
        size = 0;
    }

    public void enqueue(Cutie cutie) {
        if (size == MAX_SIZE) {
            System.out.println("Queue is full! Cannot add more cuties.");
        } else {
            tail = (tail + 1) % MAX_SIZE;
            queue[tail] = cutie;
            size++;
        }
    }

    public Cutie dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return null;
        } else {
            Cutie dequeuedcutie = queue[head];
            head = (head + 1) % MAX_SIZE;
            size--;
            return dequeuedcutie;
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
      
      QueueTees queue = new QueueTees();
      queue.size();
      System.out.println("Queue size: " + queue.size());

      queue.enqueue(puppy);
      queue.enqueue(kitty);
      queue.enqueue(chilla);

      System.out.println("Queue size: " + queue.size());

      queue.enqueue(puppy);

      Cutie firstOut = queue.dequeue();
      System.out.println("Dequeued: " + firstOut.description());

      Cutie secondOut = queue.dequeue();
      System.out.println("Dequeued: " + secondOut.description());

      Cutie thirdOut = queue.dequeue();
      System.out.println("Dequeued: " + thirdOut.description());
      queue.dequeue();
    }
}