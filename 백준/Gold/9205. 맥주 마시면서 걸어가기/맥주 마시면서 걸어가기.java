import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 밀집 그래프?? 입력 값 적음 플로이드 워샬 다 구하고 각 행마다 50미만인 수가 하나이상 있을 경우
 * 
 * @author SSAFY
 *
 */
public class Main {
	private static int MAX = 32767 * 2 * 100;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 0; t < testCase; t++) {
			int storeCount = Integer.parseInt(br.readLine());
			int[][] DP = new int[storeCount + 3][storeCount + 3];

			int[][] distance = new int[storeCount + 3][2];
			for (int i = 1; i < distance.length; i++) {
				st = new StringTokenizer(br.readLine());
				distance[i][0] = Integer.parseInt(st.nextToken());
				distance[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i < storeCount + 3; i++) {
				Arrays.fill(DP[i], MAX);
				for (int j = 1; j < storeCount + 3; j++) {
					int sX= distance[i][0];
					int sY= distance[i][1];
					int eX= distance[j][0];
					int eY= distance[j][1];
					DP[i][j] = calcDis(sY, sX, eY, eX);
					if (DP[i][j] > 1000) DP[i][j] = MAX;
				}
				DP[i][i] = 0;
			}

			for (int k = 1; k <= storeCount + 2; k++) {
//				System.out.println(k);
				for (int i = 1; i <= storeCount + 2; i++) {
					for (int j = 1; j <= storeCount + 2; j++) {
						DP[i][j] = Math.min(DP[i][j], DP[i][k] + DP[k][j]);
					}
				}	
//				
			}
			if (DP[1][storeCount + 2] <= 1000 * (storeCount + 1)) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
			
		}

	}

	private static void print(int[][] DP) {
		for (int[] d : DP) {
			System.out.println(Arrays.toString(d));
		}
		System.out.println();
	}
	
	private static int calcDis(int sY, int sX, int eY, int eX) {
		return Math.abs(eY - sY) + Math.abs(eX - sX);
		
	}
}
