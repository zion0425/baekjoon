import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	private static int minMove;
	private static int n;
	private static int[] arr;
	private static int[][] homes;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			homes = new int[n + 2][n + 2];
			
			homes[0][0] = Integer.parseInt(st.nextToken());
			homes[0][1] = Integer.parseInt(st.nextToken());
			
			homes[n + 1][0] = Integer.parseInt(st.nextToken());
			homes[n + 1][1] = Integer.parseInt(st.nextToken());
			
			arr = new int[n];
			
			for (int i =  1; i <= n; i++) {
				homes[i][0] = Integer.parseInt(st.nextToken());
				homes[i][1] = Integer.parseInt(st.nextToken());
			}

			
			minMove = Integer.MAX_VALUE;
			isVisited = new boolean[n + 1];
			visit(0);
			
			System.out.println("#" + t + " " + minMove);
		}
		
	}
	private static boolean[] isVisited;
 	
	private static void visit(int d) {
		if (d == n) {
			calcSum(arr);
			return ;
		}
		
		for (int i = 1; i <= n; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				arr[d] = i;
				visit(d + 1);
				isVisited[i] = false;
			}
		}
	}

	private static int calcSum(int[] ar) {
		int sum = moveLength(0, ar[0]);
		for (int i = 1; i < ar.length; i++) {
			sum += moveLength(ar[i - 1], ar[i]);
		}
		sum+= moveLength(n + 1, ar[ar.length - 1]);
		minMove = Math.min(sum, minMove);
		return 0;
	}
	
	
	private static int moveLength(int start, int target) {
		return Math.abs(homes[target][0] - homes[start][0]) + Math.abs(homes[target][1] - homes[start][1]);
	}

}
