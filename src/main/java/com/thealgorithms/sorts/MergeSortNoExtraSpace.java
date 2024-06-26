package com.thealgorithms.sorts;

import java.util.Arrays;
import java.util.Scanner;

/*This code implements the mergeSort algorithm without extra space
For understanding about mergesort visit :https://www.geeksforgeeks.org/merge-sort/
 */
public final class MergeSortNoExtraSpace {
    private MergeSortNoExtraSpace() {
    }

    public static void callMergeSort(int[] a, int n) {
        int maxele = Arrays.stream(a).max().getAsInt() + 1;
        mergeSort(a, 0, n - 1, maxele);
    }

    public static void mergeSort(int[] a, int start, int end, int maxele) { // this function divides the array into 2 halves
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(a, start, mid, maxele);
            mergeSort(a, mid + 1, end, maxele);
            implementMergeSort(a, start, mid, end, maxele);
        }
    }

    public static void implementMergeSort(int[] a, int start, int mid, int end,
        int maxele) { // implementation of mergesort
        int i = start;
        int j = mid + 1;
        int k = start;
        while (i <= mid && j <= end) {
            if (a[i] % maxele <= a[j] % maxele) {
                a[k] = a[k] + (a[i] % maxele) * maxele;
                k++;
                i++;
            } else {
                a[k] = a[k] + (a[j] % maxele) * maxele;
                k++;
                j++;
            }
        }
        while (i <= mid) {
            a[k] = a[k] + (a[i] % maxele) * maxele;
            k++;
            i++;
        }
        while (j <= end) {
            a[k] = a[k] + (a[j] % maxele) * maxele;
            k++;
            j++;
        }
        for (i = start; i <= end; i++) {
            a[i] = a[i] / maxele;
        }
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter array size");
        int n = inp.nextInt();
        int[] a = new int[n];
        System.out.println("Enter array elements");
        for (int i = 0; i < n; i++) {
            a[i] = inp.nextInt();
        }
        callMergeSort(a, n);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        inp.close();
    }
}
