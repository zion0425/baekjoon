import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int number = 0;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int size = (int) Math.pow(2, n);

		findNum(r, c, size);
		System.out.println(number);

	}

	private static void findNum(int y, int x, int size) {
		if (size == 0) return ;
		int center = size / 2;

		if (center > x && center > y) {
			number += 0;
			
		} else if (center <= x && center > y) {
			number += center * center * 1;
			x -= center;
		} else if (center > x && center <= y) {
			number += center * center * 2;
			y -= center;
		} else if (center <= x && center <= y) {
			number += center * center * 3;
			x -= center;
			y -= center;
		}
		findNum(y, x, center);

	}
}
