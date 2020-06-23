package com.jmsoftware.datastructuresandalgorithms.java;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * <h1>JavaTest</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 6/11/20 2:32 PM
 **/
@Slf4j
public class JavaTest {
    @Test
    @SneakyThrows
    public void thread() {
        val executorService = Executors.newFixedThreadPool(2);
        val countDownLatch = new CountDownLatch(20);
        val futureTaskList = new LinkedList<FutureTask<String>>();
        for (var index = 0; index < 20; index++) {
            final var futureTask = new FutureTask<>(() -> {
                countDownLatch.countDown();
                log.info("2 Current thread {} {}", Thread.currentThread().getName(),
                         Thread.currentThread().getState().name());
                val duration = Double.valueOf(Math.ceil(Math.random() * 1000)).intValue();
                Thread.sleep(1000L);
                return String.format("Slept %d ms", duration);
            });
            executorService.submit(futureTask);
            futureTaskList.add(futureTask);
        }
        countDownLatch.await();
        for (FutureTask<String> task : futureTaskList) {
            log.info("Task is done: {}", task.isDone());
            log.info("Task result: {}", task.get());
        }
    }
}
