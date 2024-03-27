import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		
		// O(NlogN)
		int n = Integer.parseInt(br.readLine());
	    int LIS[] = new int[n];
		
		int[] S = new int[n];
		Arrays.fill(LIS, Integer.MAX_VALUE);
	    int size = 1;
	    
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			S[i] = Integer.parseInt(st.nextToken()); 
		}
	    
		LIS[0] = S[0];
	    for (int i = 1; i < n; i++) {
	        if (LIS[size - 1] > S[i]) {
	        	// 이진 탐색으로 O(logN)
	        	int index = Arrays.binarySearch(LIS, S[i]);
	        	if (index >= 0) {
	        		LIS[index] = S[i];
	        	} else {
	        		LIS[-index - 1] = S[i];
	        	}
	        } else if (LIS[size - 1] < S[i]) {
	        	LIS[size++] = S[i];
	        }
	    }
	    System.out.println(size);
	}
}



