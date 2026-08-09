package com.ds.algo.concepts.gog.array_fundamental;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertElementAtCorrectIndex {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original List: " + list);
        int index = 2;
        int val = 99;
        insertAtIndexForArrayNative(list, index, val);
        System.out.println("List after inserting " + val + " at index " + index + ": " + list);
    }

    static void insertAtIndexForList(List<Integer> list, int index, int val) {
        list.add(index, val);
    }

    static void insertAtIndexForArrayNative(List<Integer> list, int index, int val) {
        if (index < 0 || index > list.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + list.size());
        }

        // Convert the entire list to an array first (O(N))
        int[] temp = list.stream().mapToInt(Integer::intValue).toArray();
        int[] arr = new int[temp.length + 1];

        // Native high-speed memory copies
        System.arraycopy(temp, 0, arr, 0, index);          // Copy front
        arr[index] = val;                                   // Insert element
        System.arraycopy(temp, index, arr, index + 1, temp.length - index); // Copy back

        System.out.println("Array after inserting " + val + " at index " + index + ": ");
        System.out.println(Arrays.toString(arr));
    }


    static void insertAtIndexForArray1(List<Integer> list, int index, int val) {
        // 1. Boundary validation
        if (index < 0 || index > list.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + list.size());
        }

        int[] arr = new int[list.size() + 1];

        // 2. Copy elements before the insertion index
        for (int i = 0; i < index; i++) {
            arr[i] = list.get(i);
        }

        // 3. Insert the new value
        arr[index] = val;

        // 4. Copy elements after the insertion index
        for (int i = index; i < list.size(); i++) {
            arr[i + 1] = list.get(i);
        }

        // 5. Print the array efficiently
        System.out.println("Array after inserting " + val + " at index " + index + ": ");
        System.out.println(Arrays.toString(arr));
    }

    static void insertAtIndexForArray(List<Integer> list, int index, int val) {
        int[] arr = new int[list.size() + 1];
        for (int i = 0; i < arr.length - 2; i++) {
            arr[i] = list.get(i);
            if (i == index) {
                for (int j = arr.length - 1; j >= i; j--) {
                    arr[j] = list.get(j - 1);
                }
                arr[index] = val;
                break;
            }
        }
        // print arr
        System.out.println("Array after inserting " + val + " at index " + index + ": ");
        for (int n : arr) {
            System.out.print(", " + n);
        }
        System.out.println();
    }
}
