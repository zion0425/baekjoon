import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int passwordLength, commandCount;
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		ArrayList<Integer> password;
		
		for (int t = 1; t <= 10; t++) {
			passwordLength = Integer.parseInt(br.readLine());
			password = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < passwordLength; i++) {
				password.add(i, Integer.parseInt(st.nextToken()));
			}
			
			commandCount = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split("I");
			for (int i = 1; i <= commandCount; i++) {
				st = new StringTokenizer(str[i]);
				
				int insertIndex = Integer.parseInt(st.nextToken());
				int passLength = Integer.parseInt(st.nextToken());
				for (int j = 0; j < passLength; j++) {
					password.add(insertIndex++, Integer.parseInt(st.nextToken()));
				}
			}
			sb.append('#').append(t).append(' ');
			for (int i = 0; i < 10; i++) {
				sb.append(password.get(i)).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
		
}
