import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Queue<Integer> queue = new LinkedList<>();
		Scanner sca = new Scanner(System.in);
		
		int n = sca.nextInt();
		int k = sca.nextInt();
		
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		
		int index = 0;
		System.out.print("<");
		while (!queue.isEmpty()) {
			index++;
			int target = queue.poll();
			if (index % k == 0) {
				System.out.print(target);
				if (!queue.isEmpty()) {
					System.out.print(", ");
				}
				continue;
			}
			queue.offer(target);
		}
		System.out.print(">");
	}

}
