package codefile;

import java.lang.Integer;

public class Solution1356 {
	public int[] sortByBits(int[] arr) {
        
        for (int i = 0; i < arr.length; i++) {
        	for (int j = arr.length - 1; j > i; j--) {
        		if (Integer.bitCount(arr[j]) < Integer.bitCount(arr[j-1])) {
        			swap(arr, j, j-1);
        		}
        		if (Integer.bitCount(arr[j]) == Integer.bitCount(arr[j-1])) {
        			if (arr[j] < arr[j-1]) {
        				swap(arr, j, j-1);
        			}
        		}
        	}
        }
        
        return arr;
    }
	
	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
