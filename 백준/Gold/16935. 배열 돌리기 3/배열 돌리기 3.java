import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			String select = st.nextToken();
			if (select.equals("1")) transOne(arr);
			else if (select.equals("2")) transTwo(arr);
			else if (select.equals("3")) arr =  transThree(arr);
			else if (select.equals("4")) arr =  transFour(arr);
			else if (select.equals("5")) arr = rotateArr(arr, new int[][]{  { n / 2, 0 }, { 0, m / 2 }, { - n / 2, 0 }, {0, -m/2} });
			else if (select.equals("6")) arr = rotateArr(arr, new int[][]{ { 0, m / 2 }, { n / 2, 0 }, {0, -m/2} , { - n / 2, 0 } });
			n = arr.length;
			m = arr[0].length;
		}

		for (int num[] : arr) {
			for (int n : num) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}

	private static boolean isIn(int y, int x) {
		return (y < n && y >= 0 && x < m && x >= 0);
	}

	private static void transOne(int[][] arr) {
		for (int i = 0; i < n / 2; i++) {
			int[] tmp = arr[n - i - 1];
			arr[n - i - 1] = arr[i];
			arr[i] = tmp;
		}
	}

	private static void transTwo(int[][] arr) {
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m / 2; i++) {
				int tmp = arr[j][m - i - 1];
				arr[j][m - i - 1] = arr[j][i];
				arr[j][i] = tmp;
			}
		}
	}

	private static int[][] transThree(int[][] arr) {
		int[][] newArr = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				newArr[i][j] = arr[n - j - 1][i];
			}
		}

		return newArr;
	}

	private static int[][] transFour(int[][] arr) {
		int[][] newArr = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				newArr[i][j] = arr[j][m - i - 1];
			}
		}

		return newArr;
	}

	private static int[][] rotateArr(int[][] arr, int[][] alpha) {
		int[][] afterRotateArr = new int[n][m];
		
		int x = 0;
		int y = 0;
		afterRotateArr = new int[n][m];
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				x = j; y = i;
				for (int d = 0; d < alpha.length; d++) {
					while (true) {
						int ry = y + alpha[d][0];
						int rx = x + alpha[d][1];
						if (!isIn(ry, rx) || afterRotateArr[ry][rx] != 0) {
							break;
						}
						afterRotateArr[y][x] = arr[ry][rx];
						y = ry;
						x = rx;
					}
				}
				afterRotateArr[y][x] = arr[i][j];
			}
		}
		return afterRotateArr.clone();
	}
}
