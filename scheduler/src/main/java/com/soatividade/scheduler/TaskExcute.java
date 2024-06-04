package com.soatividade.scheduler;

public class TaskExcute implements Task {

    @Override
    public void execute() {
        System.out.println("Executing task at " + System.currentTimeMillis());
    }
}
