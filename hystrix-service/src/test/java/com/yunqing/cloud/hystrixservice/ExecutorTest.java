package com.yunqing.cloud.hystrixservice;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {

    /*public static void main(String[] args) {
        System.out.println("name = " + Thread.currentThread().getName());

        System.out.println("创建单线程线程池");
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        System.out.println("创建一个Runnable");
        Runnable runnable = () -> {
            System.out.println("name = " + Thread.currentThread().getName());
        };

        System.out.println("提交工作线程中的任务");
        executorService.submit(runnable);
    }*/



    /*public static void main(String[] args) {
        System.out.println("当前线程name = " + Thread.currentThread().getName());

        System.out.println("创建定长线程池----");
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable task1 = () -> {

            System.out.println("当前task1线程name = " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                throw new IllegalStateException();
            }
        };

        Runnable task2 = () -> {

            System.out.println("当前task2线程name = " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new IllegalStateException();
            }
        };


        Runnable task3 = () -> {

            System.out.println("当前task3线程name = " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new IllegalStateException();
            }
        };

        System.out.println("提交任务---");
        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);

        executorService.shutdown();
    }*/

    public static void main(String[] args) {

        System.out.println("当前线程name = " + Thread.currentThread().getName());

        System.out.println("创建一个定时线程池");
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            System.out.println("开始执行任务，当前线程name = " + Thread.currentThread().getName() + "，当前时间是 = " + LocalDateTime.now());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        System.out.println("定时5秒后通过线程池执行任务，当前时间是 = " + LocalDateTime.now());
        //scheduledExecutorService.schedule(task,5, TimeUnit.SECONDS);
        //scheduledExecutorService.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(task, 0, 3, TimeUnit.SECONDS);


    }



}
