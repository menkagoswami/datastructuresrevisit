package cormensort;

import java.util.Arrays;

public class Sort {

	public static <E extends Comparable<? super E>> void insertionSort(E[] arr) {

		for (int j = 0; j < arr.length; j++) {
			E key = arr[j];
			int i = j - 1;
			while (i >= 0 && arr[i].compareTo(key) > 0) {
				arr[i + 1] = arr[i];
				i = i - 1;
				arr[i + 1] = key;

			}

		}
		System.out.println(Arrays.toString(arr));
	}

	public static <E extends Comparable<? super E>> void insertionSort(int[] arr) {

		for (int j = 0; j < arr.length; j++) {
			int key = arr[j];
			int i = j - 1;
			while (i >= 0 && arr[i] > key) {
				arr[i + 1] = arr[i];
				i = i - 1;
				arr[i + 1] = key;

			}

		}
		System.out.println(Arrays.toString(arr));
	}

	public static <E extends Comparable<? super E>> void insertionSort(long[] arr) {

		for (int j = 0; j < arr.length; j++) {
			long key = arr[j];
			int i = j - 1;
			while (i >= 0 && arr[i] > key) {
				arr[i + 1] = arr[i];
				i = i - 1;
				arr[i + 1] = key;

			}

		}
		System.out.println(Arrays.toString(arr));
	}

}
