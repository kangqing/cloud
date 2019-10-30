package com.yunqing.cloud.hystrixservice;

import java.util.concurrent.*;

public class CallbackTest {



    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue(10));
        int count = 0;

        Callable<String> callable = () -> {

            System.out.println("callback任务");
            Thread.sleep(5000);
            return "200";
        };

        System.out.println("执行任务放进future---");
        Future<String> future = executorService.submit(callable);

        System.out.println("执行其他任务");

        while (!future.isDone()){
            System.out.println("阻塞状态");
            Thread.sleep(200);
            count++;

        }



        System.out.println("获取future的结果");
        if(!future.isCancelled()) {
            String result = future.get(1, TimeUnit.SECONDS);
            System.out.println(result);
        }else {
            System.out.println("任务已取消----");
        }



    }
}
