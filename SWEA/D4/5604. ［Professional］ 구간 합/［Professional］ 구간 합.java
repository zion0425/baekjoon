

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static long tmp = 45;
	static long A, B;
	static long res;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			long v = 1;
			res = 0;
			long sum = 0;
			while (A <= B && B != 0) {
				// A의 1의 자리를 1씩 더해서 0으로
				while (A % 10 != 0 && A <= B) {
					rec(A, v);
					++A;
				}
				
				if (A > B) break;
				
				// B의 1의 자리를 1씩 빼서 9로 
				while (B % 10 != 9 && A <= B) {
					rec(B, v);
					--B;
				}
				
				A /= 10;
				B /= 10;
				sum = (B - A + 1L)* v * 45L;
				res += sum;
				v *= 10L;
				
			}
			
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void rec(long n, long v) {
		while (n > 0) {
			// 등장하는 숫자 카운트, 
			res += n % 10 * v;
			n /= 10;
		}
	}
}


/*



*/