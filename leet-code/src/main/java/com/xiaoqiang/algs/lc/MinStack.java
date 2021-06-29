package com.xiaoqiang.algs.lc;

public class MinStack {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();

        System.out.println(stack.getMin());
        stack.pop();

        System.out.println(stack.getMin());

    }

    private int[] xStack;
    private int[] minStack;
    private int size;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        xStack = new int[10];
        minStack = new int[11];
        size = 0;
        minStack[0] = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (size == xStack.length) {
            resize();
        }
        xStack[size++] = val;
        minStack[size] = Math.min(minStack[size - 1], val);
    }

    private void resize() {
        int[] oldStack = this.xStack;
        int[] oldMinStack = this.minStack;
        this.xStack = new int[oldStack.length * 2];
        this.minStack = new int[xStack.length + 1];
        System.arraycopy(oldStack, 0, this.xStack, 0, oldStack.length);
        System.arraycopy(oldMinStack, 0, this.minStack, 0, oldMinStack.length);
    }

    public void pop() {
        if (size != 0) {
            size--;
        }
    }

    public int top() {
        return xStack[size - 1];
    }


    public int getMin() {
        return minStack[size];
    }
}
