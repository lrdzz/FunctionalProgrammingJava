package org.lrdz.Lambdas.Examples;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ConcurrenceLambda {

    //to iterate in threads, Runnable doesnt return any value. (only executes a process in second stance"
    static Runnable printerSum = () -> {
        long r = 0;
        System.out.println(Thread.currentThread().getName());
        for (int i = 0 ; i< 1000000; i ++){
            r +=1;
        }
        System.out.println("Total: " + r);
    };

    //Similar to Runnable but this return a value.
    static Callable<Long> getSum = () ->{
        long r = 0;
        System.out.println(Thread.currentThread().getName());
        for (int i = 0 ; i< 1000000; i ++){
            r +=1;
        }
        return r;
    };
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName()); // main thread name
        var exec = Executors.newSingleThreadExecutor(); //this create a pool of threads
        exec.submit(printerSum);

        var result = exec.submit(getSum);
        System.out.println("Result " + result.get());

        exec.shutdown();
    }

}
