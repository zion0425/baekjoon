import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, String> findByIndexMap = new HashMap<>();
		HashMap<String, Integer> findByNameMap = new HashMap<>();
		
		
		for (int i = 1; i <= n; i++) {
			String name = br.readLine();
			findByIndexMap.put(i, name);
			findByNameMap.put(name, i);
		}
		
		StringBuilder sb = new StringBuilder();
		while (m-- > 0) {
			String input = br.readLine();
			
			if(input.charAt(0) >= '0' && input.charAt(0) <= '9') {
				sb.append(findByIndexMap.get(Integer.parseInt(input))).append('\n');
				continue;
			}
			sb.append(findByNameMap.get(input)).append('\n');
				
		}
		
		System.out.print(sb);
    }
}