package com.ds.algo.concepts.ask_questions.java_multithread;

public class PrintNumberInSequenceUsingNThreads {
    private static final Object LOCK = new Object(); // Shared lock for synchronization
    private static int counter = 1; // Start sequence at 1
    private final int maxNumber;
    private final int totalThreads;

    public PrintNumberInSequenceUsingNThreads(int maxNumber, int totalThreads) {
        this.maxNumber = maxNumber;
        this.totalThreads = totalThreads;
    }

    public static void main(String[] args) {
        int n = 15;          // Print numbers from 1 to N
        int numThreads = 5;  // Change this to any number of threads

        PrintNumberInSequenceUsingNThreads printer = new PrintNumberInSequenceUsingNThreads(n, numThreads);

        // Create N threads dynamically, each assigned a unique remainder (0 to numThreads-1)
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            // Thread-1 gets remainder 1, Thread-2 gets remainder 2, ..., Thread-N gets remainder 0
            int remainder = (i + 1) % numThreads;
            threads[i] = new Thread(printer.new NumberRunnable(remainder), "Thread-" + (i + 1));
        }

        for (Thread t : threads) {
            t.start();
        }
    }

    class NumberRunnable implements Runnable {
        private final int remainder;

        public NumberRunnable(int remainder) {
            this.remainder = remainder;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (LOCK) {
                    // Stop executing if counter exceeds N
                    if (counter > maxNumber) {
                        break;
                    }

                    // Wait until it is this thread's turn
                    while (counter % totalThreads != remainder) {
                        try {
                            LOCK.wait();
                            // Re-check termination condition after waking up
                            if (counter > maxNumber) {
                                return;
                            }
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    // Print and advance counter
                    System.out.println(Thread.currentThread().getName() + " : " + counter);
                    counter++;

                    // Wake up all other threads to evaluate the updated counter
                    LOCK.notifyAll();
                }
            }
        }
    }
}
