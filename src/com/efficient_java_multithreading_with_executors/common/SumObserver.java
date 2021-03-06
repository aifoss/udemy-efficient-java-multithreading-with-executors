package com.efficient_java_multithreading_with_executors.common;

/**
 * Created by sofia on 8/18/18.
 */
public class SumObserver implements ResultListener<Integer> {

    private String taskId;

    public SumObserver(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public void notifyResult(Integer result) {
        System.out.println("Result for " + taskId + " = " + result);
    }

}
