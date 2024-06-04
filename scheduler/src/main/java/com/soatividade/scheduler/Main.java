package com.soatividade.scheduler;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scheduler scheduler = new Scheduler();
        Task task = new TaskExcute() {
        };

        scheduler.start(task, 0, 2, TimeUnit.SECONDS);

        Thread.sleep(10000);
        scheduler.stop();
    }
}
