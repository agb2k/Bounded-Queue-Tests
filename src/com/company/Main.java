package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BoundedQueue bq = new BoundedQueue(10);
        bq.enQueue("Abhinav");
        bq.enQueue("Jude");
        bq.enQueue("Habib");
        bq.deQueue();
        System.out.println(bq);
    }
}
