import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {

	static class Juwel implements Comparable<Juwel> {
		int M, V;

		public Juwel(int m, int v) {
			M = m;
			V = v;
		}
		
		@Override
		public int compareTo(Juwel o) {
			return Integer.compare(this.M, o.M);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		PriorityQueue<Integer> backpack = new PriorityQueue<>();
		PriorityQueue<Juwel> juwelList = new PriorityQueue<>();
		PriorityQueue<Juwel> tmpJuwel = new PriorityQueue<>((o1, o2) -> o2.V - o1.V);

		for (int i = 0; i < N; i++)
			juwelList.add(new Juwel(sc.nextInt(), sc.nextInt()));

		for (int i = 0; i < K; i++)
			backpack.add(sc.nextInt());

		long sum = 0;
		int findIndex = 0;
		
		for (int i = 0; i < K; i++) {
			while (findIndex < N && juwelList.peek().M <= backpack.peek()) {
				++findIndex;
				tmpJuwel.add(juwelList.poll());
			}
			if (!tmpJuwel.isEmpty()) {
				sum += tmpJuwel.poll().V;
			}
			backpack.poll();
		}
		System.out.println(sum);
	}
}

