package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoundedQueueTest {

    @Test
    void boundedQueue() {
//        BoundedQueue can't accept any integer less than 0 as an argument
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BoundedQueue bq = new BoundedQueue(-1);
        });
    }

    @Test
    void testEnQueue() {
//        Enqueue function should function sequentially
        BoundedQueue bq = new BoundedQueue(6);
        bq.enQueue("Please");
        bq.enQueue("Give");
        bq.enQueue("Me");
        bq.enQueue("A");
        bq.enQueue("First");
        bq.enQueue(":)");
        Assertions.assertEquals("[Please, Give, Me, A, First, :)]", bq.toString());

//        Null should not be an argument for the BoundedQueue
        Assertions.assertThrows(NullPointerException.class, () -> bq.enQueue(null));

//        BoundedQueue should only be able to store as much as its capacity
        Assertions.assertThrows(IllegalStateException.class, () -> bq.enQueue("!"));
    }

    @Test
    void testDeQueue() {
//        Dequeue function should function sequentially. The opposite of enqueue
        BoundedQueue bq = new BoundedQueue(2);
        bq.enQueue(1);
        bq.enQueue(2);
        bq.deQueue();
        Assertions.assertEquals("[2]", bq.toString());

//        Dequeue should not take place if queue has no objects within it
        bq.deQueue();
        Assertions.assertThrows(IllegalStateException.class, bq::deQueue);
    }

    @Test
    void testIsEmpty() {
//        isEmpty should return True when no contents in the BoundedQueue
        BoundedQueue bq = new BoundedQueue(2);
        Assertions.assertTrue(bq.isEmpty());

//        isEmpty should return False when there are items in the BoundedQueue
        bq.enQueue("Test");
        Assertions.assertFalse(bq.isEmpty());
    }

    @Test
    void testIsFull() {
//        isFull should return True when BoundedQueue is full
        BoundedQueue bq = new BoundedQueue(2);
        bq.enQueue(1);
        bq.enQueue(2);
        Assertions.assertTrue(bq.isFull());

//        isEmpty should return False when BoundedQueue is anything less than full
        bq.deQueue();
        Assertions.assertFalse(bq.isFull());
    }

    @Test
    void testToString() {
//        bq.toString should be of the type String
        BoundedQueue bq = new BoundedQueue(2);
        bq.enQueue("Test");
        bq.enQueue(1);
        Assertions.assertTrue(bq.toString() instanceof String);

//        bq.toString should give results in the expected order
        Assertions.assertEquals("[Test, 1]", bq.toString());
    }
}