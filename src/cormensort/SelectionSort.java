package cormensort;

import java.util.Arrays;

public class SelectionSort {

	public void selectionSort() {
		int a[] = { 5, 2, 4, 3, 6, 1, 9, 0 ,3 ,8 };
		int smallest , temp , index ;
		
		for (int i = 0; i < a.length; i++) {
			 smallest = a[i];
			 temp = a[i];
			 index = -1;
			for (int j = i; j < a.length; j++) {
				if (smallest >= a[j]) {
					smallest = a[j];
					index = j;
				}
			}
			a[i] = a[index];
			a[index] = temp;

		}
		System.out.println(Arrays.toString(a));
	}

	public static void main(String[] args) {
		SelectionSort sort = new SelectionSort();
		sort.selectionSort();
	}
}
