package cormensort;

import java.util.Arrays;

public class CallSort {

	public static void main(String[] args) {
		CallSort sort = new CallSort();
		int arr[];
		arr = new int[] {5,9,0,2,7};
		Integer[] arrInt = 	Arrays.stream(arr).boxed().toArray(Integer[]::new);
		Sort.insertionSort(arr);
	}
}
