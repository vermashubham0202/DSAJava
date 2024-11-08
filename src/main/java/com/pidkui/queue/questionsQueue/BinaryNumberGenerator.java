package com.pidkui.queue.questionsQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryNumberGenerator {

    private static String[] generateBinaryNumbers(int n) {
        String[] result = new String[n];
        Queue<String> queue = new LinkedList<>();

        queue.offer("1");
        for (int i = 0; i < n; i++) {
            result[i] = queue.poll();
            queue.offer(result[i] + "0");
            queue.offer(result[i] + "1");
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("How many binary numbers you want to generate?");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] nums = generateBinaryNumbers(n);

        for (String str : nums) {
            System.out.println(str);
        }
    }
}
