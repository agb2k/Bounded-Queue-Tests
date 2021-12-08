package com.company;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoundedQueueTest {

    @Test
    void enQueue() {
        BoundedQueue bq = new BoundedQueue(6);
        bq.enQueue("Please");
        bq.enQueue("Give");
        bq.enQueue("Me");
        bq.enQueue("A");
        bq.enQueue("First");
        bq.enQueue(":)");
        Assertions.assertEquals("[Please, Give, Me, A, First, :)]", bq.toString());
    }

    @Test
    void deQueue() {
        BoundedQueue bq = new BoundedQueue(2);
        bq.enQueue(1);
        bq.enQueue(2);
        bq.deQueue();
        Assertions.assertEquals("[2]", bq.toString());
    }

    @Test
    void isEmpty() {
        BoundedQueue bq = new BoundedQueue(2);
        Assertions.assertTrue(bq.isEmpty());

        bq.enQueue("Test");
        Assertions.assertFalse(bq.isEmpty());
    }

    @Test
    void isFull() {
        BoundedQueue bq = new BoundedQueue(2);
        bq.enQueue(1);
        bq.enQueue(2);
        Assertions.assertTrue(bq.isFull());

        bq.deQueue();
        Assertions.assertFalse(bq.isFull());
    }

    @Test
    void testToString() {
        BoundedQueue bq = new BoundedQueue(2);
        bq.enQueue("Test");
        bq.enQueue(1);
        Assertions.assertTrue(bq.toString() instanceof String);
        Assertions.assertEquals("[Test, 1]", bq.toString());
    }
}