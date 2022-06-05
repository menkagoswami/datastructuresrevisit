package cormensort;

import java.util.Arrays;

public class Insertionsort {
	
	public static void main(String args[]) {
		Insertionsort sort = new Insertionsort();
		sort.insertionSort();
	}
	
	public void insertionSort() {
		int a[] = {5,2,4,3,6,1};
		for(int j = 1; j< a.length ;j++) {
			int i =j-1;
			int key = a[j];
			while(i >= 0 && a[i] > key) {
				a[i+1] = a[i];
				i = i-1;
				a[i+1] = key;
			}
		
		}
		System.out.println(Arrays.toString(a));
		
	}
	
	

}
