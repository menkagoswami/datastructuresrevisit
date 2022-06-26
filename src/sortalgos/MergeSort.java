package sortalgos;

import java.util.Arrays;
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
