import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	private static int m;
	private static int n;


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] studentsList = new ArrayList[n + 1];
		int[] inputNodeCount = new int[n + 1];
		
		boolean[] firstSearch = new boolean[n + 1]; 


		for (int i = 1 ; i <= n; i++) {
			studentsList[i] = new ArrayList<>();	
		}
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			inputNodeCount[value]++;
			studentsList[index].add(value);
		}
		
		int cnt = 0;
		while (cnt < n) {
			for (int i = 1; i <= n; i++) {
				if (inputNodeCount[i] == 0) {
					System.out.print(i + " ");
					inputNodeCount[i]--;
					for(int adjNode : studentsList[i]) {
						inputNodeCount[adjNode]--;	
					}
					
					cnt++;
				}
			}
		}
	}
}
