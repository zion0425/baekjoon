import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int m;
	private static StringBuilder sb = new StringBuilder();
	private static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); 
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < n; i++) {
			arr[i] += arr[i - 1]; 
		}
		
		for (int t = 1; t <= m; t++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			
			if (i < 1) { 
				sb.append(arr[j]).append('\n');
				continue;
			}
			sb.append(arr[j] - arr[i - 1]).append('\n');
		}
		System.out.println(sb);
	}
}
