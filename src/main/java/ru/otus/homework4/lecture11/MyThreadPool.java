package ru.otus.homework4.lecture11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyThreadPool {

    private final int threadCount;
    private final List<Thread> threads;
    private final List<Runnable> tasks;
    private boolean isActive;

    public MyThreadPool(int threadCount) {
        this.isActive = true;
        this.threadCount = threadCount;
        this.threads = new ArrayList<>();
        this.tasks = new LinkedList<>();
        initThreads();
        startThreads();
    }

    private void initThreads() {
        for (int i = 0; i < this.threadCount; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                while (isActive || !tasks.isEmpty()) {
                    if (!tasks.isEmpty()) {
                        tasks.getFirst().run();
                    }
                }
            });
            threads.add(thread);
        }
    }

    private void startThreads() {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public void execute(Runnable r) {
        if (!isActive) {
            throw new IllegalStateException();
        }
        tasks.add(r);
    }

    public void shutdown() {
        System.out.println("Shutting down");
        this.isActive = false;
    }
}
