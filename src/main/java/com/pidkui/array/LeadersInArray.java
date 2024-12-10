package com.pidkui.array;

import java.util.ArrayList;

// native approach: using inner loop
// Time Complexity: O(n^2)
// Space Complexity: O(1)
public class LeadersInArray {

    static ArrayList<Integer> leaders(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j;

            for (j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    break;
                }
            }

            if (j == n) {
                result.add(arr[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        ArrayList<Integer> result = leaders(arr);

        for (int res : result) {
            System.out.println(res);
        }
    }
}
