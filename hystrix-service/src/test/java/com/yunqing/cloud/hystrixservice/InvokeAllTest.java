package com.yunqing.cloud.hystrixservice;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        Callable<String> task1 = () -> {
            Thread.sleep(2000);
            return "任务1耗时2秒";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(4000);
            return "任务2耗时4秒";
        };

        Callable<String> task3 = () -> {
            Thread.sleep(6000);
            return "任务3耗时6秒";
        };

        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(task1, task2, task3));

        for (Future<String> future : futures) {

            System.out.println(future.get());
        }


    }
}
