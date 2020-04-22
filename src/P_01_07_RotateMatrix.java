
public class P_01_07_RotateMatrix {

	public static void main(String[] args) {
		test(5);
	}
	
	private static void test(int n) {
		int[][] m = new int[n][n];
		int cnt = 1;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				m[i][j] = cnt++;
			}
		}
		printMatrix(m);
		rotateMatrix(m);
		printMatrix(m);
	}
	
	private static void printMatrix(int[][] m) {
		int printPositions = (int) Math.log10(m.length * m.length) + 2;
		String format = "%" + printPositions + "d";
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.printf(format, m[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void rotateMatrix(int[][] m) {
		int n = m.length;
		for (int i = 0; i < n / 2; i++) {
			int k = n - i - 1;
			for (int j = i; j < k; j++) {
				int t = m[i][i + j];
				m[i][i + j] = m[k - j][i];
				m[k - j][i] = m[k][k - j];
				m[k][k - j] = m[i + j][k];
				m[i + j][k] = t;
			}
		}
	}

}
