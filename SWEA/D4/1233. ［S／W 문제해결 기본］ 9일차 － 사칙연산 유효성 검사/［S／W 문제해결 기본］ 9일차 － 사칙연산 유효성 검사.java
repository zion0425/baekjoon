import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());

			short result = 1;

			for (int i = 0; i < Math.ceil((float)n / 2); i++) {
				String str = br.readLine();
			}
			
			for (int i = (int)Math.ceil((float)n / 2); i < n; i++) {
				String[] str = br.readLine().split(" ");
				if (!str[1].matches("[0-9]+")) {
					result = 0;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}
