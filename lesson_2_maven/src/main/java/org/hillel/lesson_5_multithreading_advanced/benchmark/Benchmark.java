package org.hillel.lesson_5_multithreading_advanced.benchmark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class Benchmark {

    private final CompletionService<Integer> completionService;

    private final Container container;

    private final Collection<Object> collection;

    public Benchmark(CompletionService<Integer> completionService, Container container, Collection<Object> collection) {
        this.completionService = completionService;
        this.container = container;
        this.collection = collection;
    }


    public void run() throws InterruptedException, ExecutionException {
        long start = System.nanoTime();
        container.getObjectList().forEach(o -> completionService.submit(() -> generationTask(o)));

        for (int i = 0; i < container.getObjectList().size(); i++) {
            completionService.take().get();

        }

        long finish = System.nanoTime();
        long result = finish - start;

        System.out.println("Time is " + result / 1000000 + "ms");
    }

    private Integer generationTask(Object o) {
        collection.add(o);
        return collection.size();
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Object> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(new Object());
        }

        Container container1 = new Container(list);


        System.out.println("------ConcurrentLinkedQueue--------");
        Benchmark benchmark1 = new Benchmark(new ExecutorCompletionService<>(executorService), container1, new ConcurrentLinkedQueue<>());
        benchmark1.run();


        System.out.println("------CopyOnWriteArrayList--------");
        Benchmark benchmark2 = new Benchmark(new ExecutorCompletionService<>(executorService), container1, new CopyOnWriteArrayList<>());
        benchmark2.run();


        System.out.println("------LinkedBlockingDeque--------");
        Benchmark benchmark3 = new Benchmark(new ExecutorCompletionService<>(executorService), container1, new LinkedBlockingDeque<>());
        benchmark3.run();

    }
}
