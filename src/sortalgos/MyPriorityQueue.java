package sortalgos;

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

public class MyPriorityQueue {

	static HeapNodes[] heapArr = new HeapNodes[100];
	static int heapsize;

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("");
		HeapNodes node = new HeapNodes();
		for (int i = 0; i < heapsize; i++) {
			node = heapArr[i];
			int id = node.getId();
			int key = node.getKey();
			sb.append(id).append("  ").append(key).append(",");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		MyPriorityQueue queue = new MyPriorityQueue();
		HeapNodes[] a = queue.addNodes();
		// System.out.println(a.toString());
		int i = MyPriorityQueue.heapsize / 2 - 1;
		HeapNodes[] res = queue.maxHeapify(a, heapsize, i);
		printPriorityQueue(res);
		System.out.println("******************************************************************");
		int max = queue.extractMax(res);
		System.out.println(max);
		System.out.println("******************************************************************");
		try {
			int maxKey = queue.heapExtractMax(res);
			System.out.println(maxKey);
		} catch (Exception e) {
			e.getMessage();
		}
		
		System.out.println("******************************************************************");
		HeapNodes[] del = queue.deletion(res, 4);
		printPriorityQueue(del);
		System.out.println("******************************************************************");

		HeapNodes node = new HeapNodes();
		node.setId(8);
		node.setKey(6);
		HeapNodes[] insert = queue.insert(del, node);
		printPriorityQueue(insert);
		System.out.println("******************************************************************");
	}

	private HeapNodes[] insert(HeapNodes[] del, HeapNodes node) {
		HeapNodes[] newArr = increaseHeapCapacity(del);

		heapsize = heapsize + 1;
		newArr[heapsize - 1] = node;
		int position = heapsize - 1;
		newArr = heapIncreaseKey(newArr, position);

		return newArr;
	}

	private HeapNodes[] heapIncreaseKey(HeapNodes[] newArr, int position) {
		int parent = (position - 1) / 2;
		if (newArr[parent].getKey() > newArr[position].getKey()) {
			return newArr;
		}

		while (position > 0 && newArr[parent].getKey() < newArr[position].getKey()) {
			newArr = swap(newArr, parent, position);
			position = parent;
			parent = (position - 1) / 2;
		}
		return newArr;

	}

	private HeapNodes[] increaseHeapCapacity(HeapNodes[] del) {
		if (heapsize < del.length) {
			return del;
		}
		int capacity = del.length * 2;
		HeapNodes[] newArr = new HeapNodes[capacity];
		for (int i = 0; i < heapsize; i++) {
			newArr[i] = del[i];
		}
		return newArr;
	}

	private HeapNodes[] deletion(HeapNodes[] res, int position) {
		int parent = (position - 1) / 2;

		while (position > 0) {
			res = swap(res, parent, position);
			position = parent;
			parent = (position - 1) / 2;
		}
		res[0] = res[heapsize - 1];
		heapsize--;
		res = maxHeapify(res, heapsize, 0);
		return res;
	}

	private int heapExtractMax(HeapNodes[] res) throws Exception {
		int max;
		if (MyPriorityQueue.heapsize <= 0) {
			throw new Exception("Error: heapUnderflow");
		}
		max = res[0].getKey();
		res[0] = res[MyPriorityQueue.heapsize - 1];
		MyPriorityQueue.heapsize = heapsize - 1;
		maxHeapify(res, heapsize, 0);
		return max;
	}

	private int extractMax(HeapNodes[] res) {
		return res[0].getKey();
	}

	// printing only keys of the node
	private static void printPriorityQueue(HeapNodes[] heapArr) {
		for (int i = 0; i < MyPriorityQueue.heapsize; i++) {
			System.out.print(heapArr[i] + " , ");

		}
		System.out.println();
	}

	private HeapNodes[] addNodes() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the heapsize of the array");
		heapsize = sc.nextInt();
		System.out.println("Enter the id and the key of the array");
		int k = 0;
		while (k < heapsize) {
			HeapNodes node = new HeapNodes();
			int id = sc.nextInt();
			node.setId(id);
			int key = sc.nextInt();
			node.setKey(key);
			heapArr[k] = node;
			k++;
		}
		sc.close();
		return heapArr;
	}

	public HeapNodes[] maxHeapify(HeapNodes[] arr, int heapsize, int i) {

		if (i < 0) {
			return arr;
		}
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		HeapNodes parent = arr[i];
		HeapNodes leftNode = arr[left];
		HeapNodes rightNode = arr[right];
		int largest = i;

		if (left < heapsize && parent.getKey() < leftNode.getKey()) {
			largest = left;
		}
		if (right < heapsize && parent.getKey() < rightNode.getKey()) {
			largest = right;
		}
		if (largest != i) {
			arr = swap(arr, i, largest);
			MaxHeapify.heapsize = heapsize;
			return maxHeapify(arr, heapsize, largest);

		}
		MaxHeapify.heapsize = heapsize;
		return maxHeapify(arr, heapsize, --i);
	}

	private HeapNodes[] swap(HeapNodes[] arr, int i, int largest) {
		HeapNodes temp = arr[i];
		arr[i] = arr[largest];
		arr[largest] = temp;

		return arr;
	}

}
