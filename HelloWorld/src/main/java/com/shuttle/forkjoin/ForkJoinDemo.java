package com.shuttle.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MyForkJoinTask forkJoinTask = new MyForkJoinTask(1, 100);
        ForkJoinTask<Integer> result = forkJoinPool.submit(forkJoinTask);
        System.out.println(result.get());
    }
}

class MyForkJoinTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;
    private final int start;
    private final int end;

    public MyForkJoinTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        int sum = 0;
        boolean isOverThreshold = (end - start) > THRESHOLD;
        if (isOverThreshold) {
            int mid = (start + end) / 2;
            MyForkJoinTask leftTask = new MyForkJoinTask(start, mid);
            MyForkJoinTask rightTask = new MyForkJoinTask(mid + 1, end);
            leftTask.fork();
            rightTask.fork();
            Integer leftResult = leftTask.join();
            Integer rightResult = rightTask.join();
            sum = leftResult + rightResult;
        } else {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        }

        return sum;
    }

}
