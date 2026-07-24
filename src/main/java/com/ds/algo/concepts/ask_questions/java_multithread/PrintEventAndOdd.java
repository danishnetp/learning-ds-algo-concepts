package com.ds.algo.concepts.ask_questions.java_multithread;

import static com.ds.algo.concepts.take_u_forward.basic.math.programs.CheckPrime.isPrime;

public class PrintEventAndOdd {
    public static void main(String[] args) {
        PrintPrimeAndOddResource primeAndOddResource = new PrintPrimeAndOddResource(10);
        Thread oddThread = new Thread(primeAndOddResource::printOdd, "Odd Thread");
        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                primeAndOddResource.printEven();
            }
        }, "Even Thread");

        oddThread.start();
        evenThread.start();
    }

}

class PrintPrimeAndOddResource {
    volatile int counter = 1;
    int limit;

    PrintPrimeAndOddResource(int limit) {
        this.limit = limit;
    }

    synchronized void printOdd() {
        while (counter <= limit) {
            if (counter % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + " : " + counter);
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException ignored) {
                }
            }
        }
    }

    synchronized void printEven() {
        while (counter <= limit) {
            if (counter % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " : " + counter);
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException ignored) {
                }
            }
        }
    }
}
