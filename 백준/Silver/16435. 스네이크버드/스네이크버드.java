import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int snakeSize = Integer.parseInt(st.nextToken());
		
		int[] foods = new int[n];
		
		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) {
			foods[i] = Integer.parseInt(st.nextToken()); 
		}
		
		Arrays.sort(foods);
		for (int i = 0; i < n; i ++) {
			if (snakeSize >= foods[i]) snakeSize++;
		}
		
		System.out.println(snakeSize);
	}

}
