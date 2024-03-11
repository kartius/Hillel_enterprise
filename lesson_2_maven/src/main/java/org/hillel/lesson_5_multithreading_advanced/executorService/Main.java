package org.hillel.lesson_5_multithreading_advanced.executorService;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {


    public ExecutorService generateExecutor(int threads) {
        return Executors.newFixedThreadPool(threads);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Main main = new Main();
        ExecutorService executorService = main.generateExecutor(10);

        List<String> urlPaths = List.of("path1", "path2", "path3", "path4");

        Queue<Future<String>> futures = new LinkedBlockingQueue<>();


        for (String urlPath : urlPaths) {
            Future<String> future = executorService.submit(() -> makeRequest(urlPath));
            futures.add(future);
        }


        //logic
        //dsfdsfsd


        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        executorService.shutdown();
    }


    private static String makeRequest(String urlPath) {
        System.out.println("request to " + urlPath);
        return urlPath.concat(" - response 200");
    }
}
