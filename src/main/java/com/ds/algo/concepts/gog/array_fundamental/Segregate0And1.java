package com.ds.algo.concepts.gog.array_fundamental;

import java.util.Arrays;

public class Segregate0And1 {
    public static void main(String[] args) {
        segregate0and1ToSameArray(new int[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 0});
    }

    static void segregate0and1ToSameArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && arr[left] == 0) {
                left++;
            }
            while (left < right && arr[right] == 1) {
                right--;
            }
            if (left < right) {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
        //System.out.println(Arrays.toString(arr));
        for(int n: arr){
            System.out.print(n+" ");
        }
    }

    static void segregate0and1(int[] arr) {
        int[] newArray = new int[arr.length];
        int end = arr.length - 1;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                newArray[end--] = arr[i];
            } else {
                newArray[start++] = arr[i];
            }
        }
        System.out.println(Arrays.toString(newArray));
    }
}
