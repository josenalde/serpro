//by Josenalde Oliveira, august 2023

import java.util.Scanner;

public class BinarySearch { //O(log n) improves sequential search
    public static void main(String args[]) {
        int [] v = new int[1000000]; //10, 100, 1000, 10000...
        for (int i = 0; i < v.length; i++) {
            v[i] = i*2;
            //System.out.println(v[i]);
        }
        int n = 1, tests=0; // a number to search for
        //Scanner sc = System.in;
        //n = sc.nextInt();
        boolean f = false;
        int begin = 0;
        int end = v.length-1;
        int middle, idx = 0;
        while (begin <= end) {
            middle = (begin + end) / 2;
            tests++;
            if (v[middle] == n) { // is the middle number what you are looking for?
                f = true;
                idx = middle;
                break;
            } else if (v[middle] < n) { //here the new middle is at right the old one
                begin = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        System.out.println("total tests: " + tests);
        if (f) {
            System.out.println(n + " found in index: " + idx);
        } else {
            System.out.println("Sorry...");
        }

    }
}
