import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int m;
	private static int[] numbers;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); 
		m = Integer.parseInt(st.nextToken());
		numbers = new int[m];

		rec(0, 0);
		System.out.println(sb.append('\n'));
	}

	// 직전까지 던진 주사위 횟수: d
	private static void rec(int d, int start) {
		if (d == m) {
			for (int num : numbers) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		} else {
			for (int i = start; i < n; i++) {
				numbers[d] = i + 1;
				rec(d + 1, i + 1);
			}
		}
	}

}
