package com.xiaoqiang.algorithms;

import java.util.ArrayList;
import java.util.Iterator;

public class Stack<T> extends ArrayList<T> {

    public boolean push(T t) {
        return add(t);
    }

    public T pop() {
        if (size() == 0) {
            throw new RuntimeException("stack is empty!");
        }

        return remove(size() - 1);
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
