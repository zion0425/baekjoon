import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			int absO1 = Math.abs(o1);
			int absO2 = Math.abs(o2);

			if (absO1 == absO2)
				return o1 - o2;
			return absO1 - absO2;
		});

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int command = Integer.parseInt(br.readLine());
			if (command != 0) {
				queue.offer(command);
				continue;
			}
			if (queue.isEmpty()) {
				sb.append("0").append("\n");
				continue;
			}
			sb.append(queue.poll()).append("\n");
		}
		System.out.println(sb);
	}
}
