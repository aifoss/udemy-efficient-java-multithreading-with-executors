package com.efficient_java_multithreading_with_executors.common;

/**
 * Created by sofia on 8/18/18.
 */
public interface ResultListener<T> {

    void notifyResult(T result);

}
