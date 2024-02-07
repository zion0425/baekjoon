import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int m;
	private static int k;
	private static int[][] arr;
	private static int[][] startPoint;
	private static int[][] endPoint;
	private static int[][] rotateAlpha = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		startPoint = new int[k][2];
		endPoint = new int[k][2];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			startPoint[i][0] = r - s - 1;
			startPoint[i][1] = c - s - 1;
			endPoint[i][0] = r + s - 1;
			endPoint[i][1] = c + s - 1;
		}

		isVisited = new boolean[k];
		combs = new int[k];
		findMin(0);
		System.out.println(realMin);
	}

	private static int realMin = Integer.MAX_VALUE;
	private static boolean[] isVisited;
	private static int[] combs;
	
	private static int[][] deepCopy(int[][] src) {
		int[][] dst = new int[src.length][src[0].length];
		
		for (int i = 0; i < src.length; i++) {
			for (int j = 0; j < src[0].length; j++) {
				dst[i][j] = src[i][j];
			}
		}
		return dst;
	}
	
	private static void findMin(int d) {
		if (d == k) {

			int[][] tmpArr = deepCopy(arr);
			for (int i = 0; i < combs.length - 1; i++) {
				realMin = Math.min(realMin, rotateArr(combs[i], tmpArr, false));
			}
			realMin = Math.min(realMin, rotateArr(combs[combs.length - 1], tmpArr, true));
			return ;
		}
		for (int i = 0; i < k; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				combs[d] = i;
				findMin(d + 1);
				isVisited[i] = false;
			}
		}
	}
	
	private static boolean isIn(int y, int x, int index) {
		return (y <= endPoint[index][0] && y >= startPoint[index][0] && x <= endPoint[index][1]
				&& x >= startPoint[index][1]);
	}
	

	private static int rotateArr(int index, int[][] tmpArr, boolean isLast) {
		int[][] afterRotateArr;

		int tmpy = startPoint[index][0];
		int tmpx = startPoint[index][1];
		int y = startPoint[index][0];
		int x = startPoint[index][1];

		int lastDepth = Math.min(endPoint[index][1] - startPoint[index][1] + 1,
				endPoint[index][0] - startPoint[index][0] + 1) / 2;
		
		afterRotateArr = new int[n][m];
		while (lastDepth-- > 0) {
			for (int d = 0; d < rotateAlpha.length; d++) {
				while (true) {
					int ry = y + rotateAlpha[d][0];
					int rx = x + rotateAlpha[d][1];
					if (!isIn(ry, rx, index) || afterRotateArr[ry][rx] != 0) {
						break;
					}
					afterRotateArr[y][x] = tmpArr[ry][rx];
					y = ry;
					x = rx;
				}
			}
			afterRotateArr[y][x] = tmpArr[startPoint[index][0]][startPoint[index][1]];
			y = ++startPoint[index][0];
			x = ++startPoint[index][1];
		}
		startPoint[index][0] = tmpy;
		startPoint[index][1] = tmpx;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < tmpArr.length; i++) {
			sum = 0;
			for (int j = 0; j < tmpArr[0].length; j++) {
				if (afterRotateArr[i][j] != 0) {
					tmpArr[i][j] = afterRotateArr[i][j];
				}
				if (isLast)
					sum += tmpArr[i][j];
			}
			if (isLast)
				min = Math.min(sum, min);
		}
//		
//		for (int a[] :tmpArr) {
//			for (int num : a) {
//				System.out.print(num + " ");
//			}
//			System.out.println();
//		}
		
		return min;
	}
}

