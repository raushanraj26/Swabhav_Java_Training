package com.monocept.ArrayReverse.model;

public class ArrayUtility {
	public static int[] reverseArray(int[] arr) {
		  // 1. Handle null
        if (arr == null) {
            return null;
        }

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }

        return result;
		
	}

}
