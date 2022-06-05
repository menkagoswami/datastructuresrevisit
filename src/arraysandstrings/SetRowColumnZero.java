package arraysandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetRowColumnZero {

	public static void main(String[] args) {
		int[][] arr = SetRowColumnZero.formMatrix(4, 3);
		SetRowColumnZero.findZeroElement(arr, 0);
	}

	public static int[][] formMatrix(int row, int column) {
		Scanner scanner = new Scanner(System.in);

		int[][] arr = new int[row][column];
		System.out.println("Enter the matrix of dimension " + row + " * " + column);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				arr[i][j] = scanner.nextInt();
			}
			System.out.println();
		}
		scanner.close();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		return arr;
	}

	public static void findZeroElement(int[][] arr, int element) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0) {
					list.add(i);
					list.add(j);
				}
			}
			System.out.println();
		}

		for (int j = 0; j < list.size(); j = j + 2) {
			setRowCoulmnZero(list.get(j), list.get(j + 1), arr);
		}

		System.out.println(Arrays.deepToString(arr));
	}

	private static void setRowCoulmnZero(Integer row, Integer col, int[][] arr) {
		for (int i = row; i <= row; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = 0;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = col; j <= col; j++) {
				arr[i][j] = 0;
			}
		}
	}

}
