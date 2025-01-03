package com.pidkui.matrix;

/*
Searching for an element in Row and Column wise sorted matrix.
 */

public class MatrixSearch {
    private static boolean isSearchKeyPresent(int[][] matrix, int n, int key) {
        int i = 0;
        int j = n - 1;

        while (i < n && j >= 0) {
            if (matrix[i][j] == key) {
                return true;
            }

            if (matrix[i][j] > key) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 51}
        };

        int matrixSize = 4;

        int searchKey1 = 32;
        System.out.println("Is search key " + searchKey1 + " present in matrix?: " + isSearchKeyPresent(matrix, matrixSize, searchKey1));

        int searchKey2 = 34;
        System.out.println("Is search key " + searchKey2 + " present in matrix?: " + isSearchKeyPresent(matrix, matrixSize, searchKey2));
    }
}
