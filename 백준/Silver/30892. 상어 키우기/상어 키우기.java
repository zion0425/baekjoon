import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Stack<Long> smallGroup = new Stack<>();
		Queue<Long> bigGroup = new LinkedList<>();

		int countSharks = Integer.parseInt(st.nextToken());
		int eatCount = Integer.parseInt(st.nextToken());
		long curSharkSize = Long.parseLong(st.nextToken());

		long[] sharkGroupArr = new long[countSharks];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < countSharks; i++) {
			sharkGroupArr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(sharkGroupArr);

		for (int i = 0; i < sharkGroupArr.length; i++) {
			if (sharkGroupArr[i] >= curSharkSize)
				bigGroup.offer(sharkGroupArr[i]);
			else
				smallGroup.push(sharkGroupArr[i]);
		}

		while (eatCount > 0) {
			if (smallGroup.isEmpty() && bigGroup.peek() >= curSharkSize) {
				break;
			} else if (bigGroup.isEmpty() && !smallGroup.isEmpty()) {
				curSharkSize += smallGroup.pop();
				eatCount--;
			} else if (bigGroup.peek() < curSharkSize) {
				smallGroup.push(bigGroup.poll());
			} else if (bigGroup.peek() >= curSharkSize) {
				curSharkSize += smallGroup.pop();
				eatCount--;
			}
		}
		System.out.println(curSharkSize);
	}
}