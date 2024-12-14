package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestQueueTees {
    private QueueTees<Cutie> queue;
    private Puppy puppy;
    private Kitty kitty;
    private Chinchilla chilla;

    @BeforeEach
    void setUp() {
        queue = new QueueTees<>();
        puppy = new Puppy();
        kitty = new Kitty();
        chilla = new Chinchilla();
    }

    @Test
    void testQueueSize() {
        assertEquals(0, queue.size(), "Queue should be empty initially");
    }

    @Test
    void testEnqueue() {
        queue.enqueue(puppy);
        assertEquals(1, queue.size(), "Queue size should be 1 after enqueueing one cutie");

        queue.enqueue(kitty);
        assertEquals(2, queue.size(), "Queue size should be 2 after enqueueing two cuties");

        queue.enqueue(chilla);
        assertEquals(3, queue.size(), "Queue size should be 3 after enqueueing three cuties");
    }

    @Test
    void testEnqueueFull() {
        queue.enqueue(puppy);
        queue.enqueue(kitty);
        queue.enqueue(chilla);
        queue.enqueue(puppy); 
        assertEquals(3, queue.size(), "Queue size should remain 3 when already full and trying to enqueue");
    }

    @Test
    void testDequeueEmpty() {
        Cutie dequeuedCutie = queue.dequeue();
        assertNull(dequeuedCutie, "Dequeueing from an empty queue should return null");
    }

    @Test
    void testQueueEmpty() {
        assertTrue(queue.isEmpty(), "Queue should be empty initially");

        queue.enqueue(puppy);
        assertFalse(queue.isEmpty(), "Queue should not be empty after enqueuing a cutie");

        queue.dequeue();
        assertTrue(queue.isEmpty(), "Queue should be empty after dequeuing all cuties");
    }
}
