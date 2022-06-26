package sortalgos;

import java.util.Arrays;
import java.util.Scanner;

/* 
* Copyright (c) 2021, Menka Goswami
* All rights reserved.
* 
* Redistribution and use in source and binary forms, with or without
* modification, are permitted provided that the following conditions are met:
* * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
* * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
* * Neither the name of the <copyright holder> nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
* 
* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

public class MaxHeapify {

//	static int[] arr =  { 15, 5, 20, 1, 17, 10, 30 };
	static int[] arr = new int[100];

	static int heapsize = 0; // heapsize;

	private void elements() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the heapsize of the array");
		heapsize = sc.nextInt();
		System.out.println("Enter the elements of the array");
		int k = 0;
		while (k < heapsize) {
			arr[k] = sc.nextInt();
			k++;
		}
		sc.close();
		System.out.println(Arrays.toString(arr));
	}

	public int[] maxHeapify(int[] arr, int heapsize, int i) {

		if (i < 0) {
			return arr;
		}

		int larg = i;
		int l = 2 * i + 1;
		int r = (2 * i) + 2;

		if (l < heapsize && arr[l] > arr[larg]) {
			larg = l;
		}
		if (r < heapsize && arr[r] > arr[larg]) {
			larg = r;
		}
		if (larg != i) {
			int[] res = swap(arr, larg, i);
			return maxHeapify(res, heapsize, larg);
		}
		return maxHeapify(arr, heapsize, --i);

	}

	private int[] swap(int[] arr, int largest, int i) {
		int temp = arr[i];
		arr[i] = arr[largest];
		arr[largest] = temp;
		return arr;
	}

	public int[] heapSort(int[] arr, int num) {
		int i = arr.length / 2 - 1;
		int[] res = null;
		for (int j = i; j >= 0; j--) {
			maxHeapify(arr, num, j);
		}
		int len = num - 1;
		for (int j = len; j >= 0; j--) {
			res = swap(arr, 0, j);
			--num;
			maxHeapify(res, num, 0);

		}
		return res;
	}

	public int[] insertion(int[] arr, int num, int value) {
		int[] newArr = checkIfFull(arr, num);
		num = num + 1;
		newArr[num - 1] = value;
		int[] result = heapInsert(newArr, num, value);
		heapsize = num;
		return result;
	}

	private int[] heapInsert(int[] arr, int num, int value) {
		int l, r, parent;
		String child = "";
		// int[] newArr = new int[arr.length];
		if (num % 2 != 0) {
			r = num;
			parent = r / 2 - 1;
			child = "r";
		} else {
			l = num;
			parent = (l - 1) / 2;
			child = "l";
		}

		if (arr[parent] > value) {
			return arr;
		}
		int index = num - 1;
		while (arr[parent] < arr[index] && index > 0) {
			arr = swap(arr, parent, index);
			index = parent;
			parent = (index - 1) / 2;

		}
		return arr;

	}

	private int[] checkIfFull(int[] arr, int num) {
		if (arr.length < num) {
			return arr;
		}
		int capacity = arr.length * 2;
		int[] newArr = new int[capacity];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		return newArr;
	}

	public int[] deletion(int[] arr, int num, int index) {
		int[] res;
		while (index > 0) {
			int parent = (index - 1) / 2;
			arr = swap(arr, parent, index);
			index = parent;
		}
		arr[0] = arr[num - 1];

		num = num--;
		res = maxHeapify(arr, num, 0);
		heapsize = num;
		return res;

	}

	public int extractMax(int[] arr) {
		return arr[0];
	}

	public int heapExtractMax(int[] arr) throws Exception {
		if (MaxHeapify.heapsize < 0) {
			throw new Exception("Error: heap undeflow");
		}
		int max = arr[0];
		arr[0] = arr[MaxHeapify.heapsize - 1];
		MaxHeapify.heapsize = heapsize - 1;
		maxHeapify(arr, MaxHeapify.heapsize, 1);
		return max;

	}

	public static void main(String[] args) {

		MaxHeapify max = new MaxHeapify();

		max.elements();
		int i = heapsize / 2 - 1;
		int[] res = max.maxHeapify(arr, heapsize, i);
		System.out.println(Arrays.toString(res));
		int[] insertion = max.insertion(res, heapsize, 35);
		System.out.println(Arrays.toString(insertion));
		System.out.println("arr " + Arrays.toString(arr));
		int[] deletion = max.deletion(insertion, heapsize, 5);
		System.out.println(Arrays.toString(deletion));
		int[] ans = max.heapSort(insertion, heapsize);
		System.out.println(Arrays.toString(ans));
		try {
			int l = max.heapExtractMax(res);
			System.out.println(l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
