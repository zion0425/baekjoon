import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> numbers = new ArrayList<>();
			
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
				
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				numbers.add(Integer.parseInt(st.nextToken()));
			}
		}
		Collections.sort(numbers, Collections.reverseOrder());
		bw.write(numbers.get(n - 1).toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
