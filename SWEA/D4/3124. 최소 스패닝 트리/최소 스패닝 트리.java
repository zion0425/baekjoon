import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	private static int[] arr;
	private static Edge[] edgeList;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(br.readLine());
			
			int v =  Integer.parseInt(st.nextToken());
			int e =  Integer.parseInt(st.nextToken());
			
			arr = new int[v + 1];
			edgeList = new Edge[e];
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(from, to, weight);
			}

			long cnt = 0, weight = 0;
			Arrays.sort(edgeList);
			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) {
					weight += edge.weight;
					if (++cnt == v - 1) break;
					
				}
			}
			sb.append("#").append(t).append(" ").append(weight).append("\n");
		}
        System.out.println(sb);
	}
	
	private static int find(int x) {
		if (arr[x] == 0) return x;
		return arr[x] = find(arr[x]);
	}
	
	private static boolean union(int a, int b) {
		int ca = find(a);
		int cb = find(b);
		if (ca == cb) return false;
		arr[ca] = cb;
		return true;
	}

}
