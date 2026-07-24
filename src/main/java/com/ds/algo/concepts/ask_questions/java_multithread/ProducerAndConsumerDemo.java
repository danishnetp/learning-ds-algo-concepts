package com.ds.algo.concepts.ask_questions.java_multithread;

import java.util.LinkedList;
import java.util.List;

public class ProducerAndConsumerDemo {
    public static void main(String[] args) throws InterruptedException {
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();

        Thread producerThread = new Thread(() -> {
            try {
                producerAndConsumer.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerAndConsumer.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerThread.setName("Producer");
        consumerThread.setName("Consumer");

        producerThread.start();
        consumerThread.start();
    }
}

class ProducerAndConsumer {
    List<Integer> list = new LinkedList<>();
    int capacity = 2;

    void producer() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                if (list.size() == capacity) {
                    System.out.println("List is full, producer is waiting..");
                    notify();
                    wait();
                }
                list.add(value++);
                System.out.println("Producer produced : " + value);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    void consumer() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (list.isEmpty()) {
                    System.out.println("List is empty, consumer is waiting..");
                    notify();
                    wait();
                }
                int value = list.remove(0);
                System.out.println("Consumer consumed : " + value);
                notify();
                Thread.sleep(1000);
            }
        }
    }
}