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

public class Insertionsort {

	public static void main(String args[]) {
		Insertionsort sort = new Insertionsort();
		sort.insertionSort();
		sort.descendingInsertionSort();
	}

	public void insertionSort() {
		int a[] = { 5, 2, 4, 3, 6, 1 };
		for (int j = 1; j < a.length; j++) {
			int i = j - 1;
			int key = a[j];
			while (i >= 0 && a[i] > key) {
				a[i + 1] = a[i];
				i = i - 1;
				a[i + 1] = key;
			}
		}
		System.out.println(Arrays.toString(a));

	}

	public void descendingInsertionSort() {
		int a[] = { 5, 2, 4, 3, 6, 1 };

		for (int j = 1; j < a.length; j++) {
			int i = j - 1;
			int key = a[j];
			
			while(i >=0 && a[i] < key) {
				a[i+1] = a[i];
				i = i-1;
				a[i+1] = key;
			}

		}
		System.out.println(Arrays.toString(a));
	}

}
