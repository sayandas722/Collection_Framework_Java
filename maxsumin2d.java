import java.io.*;
import java.lang.*;
import java.util.*;
class GFG {
	public static void maxMatrixSum(int[][] matrix)
	{
		int n = matrix.length; // no of rows in a matrix;
		int m
			= matrix[0].length; // no of columns in matrix;
		int maxsum = -999999999;
		int top = 0, bottom = 0, left = 0, right = 0;
		for (int i = 0; i < n;
			i++) { // This loop for top row position in the
					// rectangle
			for (int j = 0; j < m;
				j++) { // This loop for left column
						// position of the rectangle
				for (int k = 0; k < n;
					k++) { // This loop for bottom row in
							// the rectangle
					for (int l = 0; l < m;
						l++) { // This loop for right
								// column in the rectangle

						int curr = 0;
						for (int x = i; x <= k;
							x++) { // This loops execute
									// for finding sum of
									// elements in the
									// rectangle
							for (int y = j; y <= l;
								y++) { // for all possibble
										// points of
										// rectangle
								curr += matrix[x][y];
							}
						}
						if (curr > maxsum) {
							maxsum = curr;
							top = i;
							left = j;
							right = k;
							bottom = l;
						}
					}
				}
			}
		}
		System.out.println("Top , Left ) ( " + top + " , "
						+ left + " )");
		System.out.println("Bottom , Right) ( " + bottom
						+ " , " + right + " )");
		System.out.println("The sum of the rectangle is: "
						+ maxsum);
	}
	public static void main(String[] args)
	{
		int arr[][] = new int[][] { { 1, 2, -1, -4, -20 },
									{ -8, -3, 4, 2, 1 },
									{ 3, 8, 10, 1, 3 },
									{ -4, -1, 1, 7, -6 } };

		// Function call
		maxMatrixSum(arr);
	}
}
// contributed by hungry_coder_109(Naveen);
