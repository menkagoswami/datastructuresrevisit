package sortalgos;

import java.util.Arrays;

public class MergeSort {
	
	static int[] a = {5,2,4,3,6,7,1};
	
	public static int[] mergeSort(int[] a, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			int[] left = mergeSort(a, p, q);
			int[] right = mergeSort(a, q + 1, r);
			return merge(left, right);
		} else {
			// We have split the array down to a single element
			int[] res = new int[1];
			res[0] = a[p];
			return res;
		}
	}

	private static int[] merge(int[] left, int[] right) {
		int[] res = new int[left.length + right.length];
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j])
				res[k++] = left[i++];
			else
				res[k++] = right[j++];
		}
		// Copy the remaining elements
		while (i < left.length)
			res[k++] = left[i++];
		while (j < right.length)
			res[k++] = right[j++];
		return res;
	}

	public static void main(String[] args) {
		int[] res = MergeSort.mergeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(res));
	}

}
