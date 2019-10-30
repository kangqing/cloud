package com.yunqing.cloud.hystrixservice;

import java.util.Arrays;
import java.util.concurrent.*;

public class InvokeAnyTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        Callable<String> task1 = () -> {
            Thread.sleep(3000);
            return "任务1执行3秒";
        };
        Callable<String> task2 = () -> {
            Thread.sleep(1000);
            return "任务2执行1秒";
        };
        Callable<String> task3 = () -> {
            Thread.sleep(2000);
            return "任务3执行2秒";
        };

        String result = executorService.invokeAny(Arrays.asList(task1, task2, task3));

        System.out.println(result);
    }
}
