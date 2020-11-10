package com.xiaoqiang.algs.interview;

public class MatrixRotatePrint {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        rotatePrint1(matrix);
    }

    private static void rotatePrint(int[][] matrix) {
        boolean[][] stateMatrix = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                stateMatrix[i][j] = false;
            }
        }
        int indexH = 0, indexW = 0;
        while (true) {
            if (!stateMatrix[indexH][indexW]) {
                stateMatrix[indexH][indexW] = true;
                System.out.print(matrix[indexH][indexW]);
                System.out.print(" ");
            }
            if (stateMatrix[indexH].length > indexW + 1 && !stateMatrix[indexH][indexW + 1]) {
                indexW++;
                continue;
            }
            if (stateMatrix.length > indexH + 1 && !stateMatrix[indexH + 1][indexW]) {
                indexH++;
                continue;
            }
            if (indexW - 1 >= 0 && !stateMatrix[indexH][indexW - 1]) {
                indexW--;
                continue;
            }
            if (indexH - 1 >= 0 && !stateMatrix[indexH - 1][indexW]) {
                indexH--;
                continue;
            }
            break;
        }
    }

    private static void rotatePrint1(int[][] matrix) {
        int hl = 0, hh = matrix.length - 1;
        int vl = 0, vh = matrix[0].length - 1;
        int indexV = 0, indexH = 0;
        int count = 0;
        boolean isProcessH = true;
        while (count < matrix.length * matrix[0].length) {
            count++;
            System.out.print(matrix[indexV][indexH]);
            System.out.print(" ");
            if (indexH <= hh && indexV == vl && isProcessH) {
                //向下转向
                if (indexH == hh) {
                    indexV++;
                    vl++;
                    isProcessH = false;
                } else {
                    indexH++;
                }
                continue;
            }
            if (indexV <= vh && indexH == hh && !isProcessH) {
                //向左转向
                if (indexV == vh) {
                    indexH--;
                    hh--;
                    isProcessH = true;
                } else {
                    indexV++;
                }
                continue;
            }
            if (indexH >= hl && indexV == vh && isProcessH) {
                //向上转向
                if (indexH == hl) {
                    indexV--;
                    vh--;
                    isProcessH = false;
                } else {
                    indexH--;
                }
                continue;
            }
            if (indexV >= vl && indexH == hl && !isProcessH) {
                //享有转向
                if (indexV == vl) {
                    indexH++;
                    hl++;
                    isProcessH = true;
                } else {
                    indexV--;
                }
            }
        }
    }
}
