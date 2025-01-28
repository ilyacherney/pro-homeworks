package ru.otus.homework4.lecture11;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(2);
        pool.execute(() -> {
            for (int i = 0; i < 5; i++) {

                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread.sleep(5000);
        pool.shutdown();
        Thread.sleep(5000);
        pool.execute(() -> {
            for (int i = 0; i < 5; i++) {

                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}