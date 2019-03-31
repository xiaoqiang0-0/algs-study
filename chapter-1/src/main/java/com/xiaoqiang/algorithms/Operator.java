package com.xiaoqiang.algorithms;

public enum Operator {
    ADD() {
        @Override
        public int calc(int a, int b) {

            return a + b;
        }

        @Override
        public char value() {
            return '+';
        }
    },
    SUB() {
        @Override
        public int calc(int a, int b) {
            return a - b;
        }

        @Override
        public char value() {
            return '-';
        }
    },
    MULTI() {
        @Override
        public int calc(int a, int b) {
            return a * b;
        }

        @Override
        public char value() {
            return '*';
        }
    },
    DIV() {
        @Override
        public int calc(int a, int b) {
            return a / b;
        }

        @Override
        public char value() {
            return '/';
        }
    };

    public int calc(int a, int b) {
        return -1;
    }

    public char value() {
        throw new UnsupportedOperationException();
    }

    public static Operator valueOfChar(char c) {
        for (Operator operator : values()) {
            if (c == operator.value()) {
                return operator;
            }
        }
        throw new UnsupportedOperationException();
    }
}
