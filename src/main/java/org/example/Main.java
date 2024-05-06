package org.example;


import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Integer, Long> fibMemory = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("iterativeFib = " + iterativeFib(6));
        System.out.println("recursiveFib = " + recursiveFib(6));
        System.out.println("dynamicFib = " + dynamicFib(6));
    }

    /**
     * Просторова складність: O(1)
     * Часова складність: O(n)
     */
    public static long iterativeFib(int n) {
        if (n <= 1) {
            return n;
        }
        long fib = 1;
        long prevFib = 1;

        for (int i = 2; i < n; i++) {
            long temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;
    }

    /**
     * Просторова складність: O(n)
     * Часова складність:  O(2^n)
     */
    public static long recursiveFib(int n) {
        if (n <= 1) {
            return n;
        }
        return recursiveFib(n - 1) + recursiveFib(n - 2);
    }

    /**
     * Просторова складність: O(n)
     * Часова складність: O(n)
     */
    public static long dynamicFib(int n) {
        if (n <= 1) {
            return n;
        }
        if (fibMemory.containsKey(n)) {
            return fibMemory.get(n);
        }
        long fib = dynamicFib(n - 1) + dynamicFib(n - 2);
        fibMemory.put(n, fib);
        return fib;
    }

}