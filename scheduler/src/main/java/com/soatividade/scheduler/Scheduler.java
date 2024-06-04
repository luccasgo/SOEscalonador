package com.soatividade.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void start(Task task, long initialDelay, long period, TimeUnit unit) {
        scheduler.scheduleAtFixedRate(task::execute, initialDelay, period, unit);
    }

    public void stop() {
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(60, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
                if (!scheduler.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Scheduler did not terminate");
            }
        } catch (InterruptedException ie) {
            scheduler.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
