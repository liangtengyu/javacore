package io.github.dunwu.javase.concurrent.tool;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 示例
 * <p>
 * 作用：允许一个或多个线程等待，直到在其他线程中执行的一组操作完成。
 * <p>
 * 原理：CountDownLatch 维护一个计数器 count。每次调用 countDown 方法会让 count 的值减 1，减到 0 的时候，那些因为调用 await
 * 方法而在等待的线程就会被唤醒。
 * @author Zhang Peng
 * @date 2018/5/10
 * @see java.util.concurrent.CountDownLatch
 */
@SuppressWarnings("all")
public class CountDownLatchDemo {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
