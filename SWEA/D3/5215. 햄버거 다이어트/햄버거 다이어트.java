import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static int[][] arr;
	private static int l;
	private static int n;
	private static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(br.readLine());
			max = 0;
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			arr = new int[n][2];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0, caseCount = 1 << n; i < caseCount; i++) {
				int sumReview = 0;
				int sumCal = 0;
				for (int j = 0; j < n; j++) {
					if ((i & 1 << j) != 0) {
						if (sumCal + arr[j][1] <= l) {
							sumCal += arr[j][1];
							sumReview += arr[j][0];
						}
						
					}
				}
				max = Math.max(max, sumReview);
			}
			
			System.out.println("#" + t + " " + max);
		}
		
	}
}

