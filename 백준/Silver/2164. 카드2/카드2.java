import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		
		int n = sca.nextInt();
		
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		
		while (queue.size() > 1) {
			queue.poll();
			if (queue.size() == 1) break;
			queue.add(queue.poll());
		}
		System.out.println(queue.poll());
	}

}
