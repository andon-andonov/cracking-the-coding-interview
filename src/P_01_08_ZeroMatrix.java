
public class P_01_08_ZeroMatrix {

	public static void main(String[] args) {
		test(5, 10);
	}
	
	private static void test(int rowCount, int colCount) {
		int[][] matrix = generateTestMatrix(rowCount, colCount, 0.05);
		printMatrix(matrix);
		zeroMatrix(matrix);
		printMatrix(matrix);
	}
	
	private static int[][] generateTestMatrix(int rowCount, int colCount, double probabilytForZero) {
		int[][] matrix = new int[rowCount][colCount];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = Math.random() <= probabilytForZero ? 0 : 1;
			}
		}
		return matrix;
	}
	
	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%3d", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void zeroMatrix(int[][] matrix) {
		boolean hasZeroInFirstRow = false;
		boolean hasZeroInFirstCol = false;
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				hasZeroInFirstRow = true;
				break;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				hasZeroInFirstCol = true;
				break;
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				zeroRow(matrix, i);
			}
		}
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				zeroCol(matrix, j);
			}
		}
		if (hasZeroInFirstRow) {
			zeroRow(matrix, 0);
		}
		if (hasZeroInFirstCol) {
			zeroCol(matrix, 0);
		}
		
	}
	
	private static void zeroRow(int[][] matrix, int row) {
		for (int j = 0; j < matrix[row].length; j++) {
			matrix[row][j] = 0;
		}
	}
	
	private static void zeroCol(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}

}
