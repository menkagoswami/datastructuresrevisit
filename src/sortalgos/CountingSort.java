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


public class CountingSort {

	static int[] A = new int[]{2,5,3,0,2,3,0,3};
	static int[] B = new int[A.length];
	public static void main(String[] args) {
		CountingSort sort = new CountingSort();
		int max = -1;
		for(int i=0 ;i<A.length ;i++) {
			if(A[i] > max) {
				max= A[i];
			}
		}
		
		sort.countingSort(A, B , max+1);
		System.out.println(Arrays.toString(A));
		
	}
	private int[] countingSort(int[] A, int[] B, int max) {
		int[] C = new int[max];
		for(int i =0 ;i<A.length ;i++) {
			C[A[i]] = C[A[i]] + 1;
		}
		for(int i = 1 ;i <C.length ;i++) {
			C[i] = C[i] + C[i-1];
		}
		for(int i = B.length-1;i>=0 ;i--) {
			B[-- C[A[i]]] = A[i];
		}
		
		for(int i=0; i< B.length ; i++) {
			A[i] = B[i];
		}
		return A;
	}
}
