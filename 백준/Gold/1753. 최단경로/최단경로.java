import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 방문배열[]
 * 
 * @author SSAFY
 *
 */
public class Main {
	static class Node {
		int to, weight;
		Node next;
		public Node(int to, int weight, Node next) {
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int curV = Integer.parseInt(br.readLine());
		Node[] adjList = new Node[V + 1];
		
		boolean[] visit = new boolean[V + 1];
		int[] minEdge = new int[V + 1];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken()); 
			int to = Integer.parseInt(st.nextToken()); 
			int weight  = Integer.parseInt(st.nextToken()); 
			
			adjList[from] = new Node(to, weight, adjList[from]); 
		}
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[curV] = 0;
		
		
		for (int i = 1; i <= V; i++) {
			
			int min = Integer.MAX_VALUE;
			int nextVisitNodeIndex = -1;

			// 방문할 노드를 구한다. 방문할 노드는 현재까지 살펴본 경로중에 최소 경로를 가진 정점을 방문한다.
			// minEdge의 각각의 인덱스는 각각의 정점을 의미한다.
			// minEdge에 저장되는 값은 각 정점에 도착할 수 있는 경로 중 최소값이 저장되어 있다. 초기에는 아무 경로도 살펴보지 않았으니, 시작값은 0이고 이를 제외한 나머지에는 MAX_VALUE 값이 들어가 있다. 
			for (int j = 1; j <= V; j++) {
				if (!visit[j] && min > minEdge[j]) {
					min = minEdge[j];
					nextVisitNodeIndex = j;
				}
			}
			// 모든 경로의 최소값을 구한 경우
			if (nextVisitNodeIndex == -1) break;
			visit[nextVisitNodeIndex] = true;

			// 최소값을 구하는 과정은 아래와 같다.
			// 초기에는 이 최소값이 시작 정점과 인접한 정점의 거리를(가중치)저장한다.
			// 추후에는 위의 로직에서 시작 정점이 방문 정점으로 변경되게 되고, 
			// 방문 정점(B)에서 다른 정점(C)으로 가는 경로(방문 정점(B)까지의 경로 합계 + 방문 정점에서 다른 정점(C)까지의 경로)의 값을 구한다. 
			// 방문 정점(B)에서 다른 정점(C)으로 가려고 할 때, minEdge의 다른 정점(C)인덱스에는 기존의 다른 정점에서 (C)까지 가는 최소경로 값을 가지고 있다.
			// 이 minEdge(C)의 값과 방문정점(B)에서 다른 정점(C)으로 가는 경로의 값을 계산해서 더 작은 값을 minEdge[C] 에 저장한다.
			for (Node tmp = adjList[nextVisitNodeIndex]; tmp != null; tmp = tmp.next) {
				// 현재 경로의 weight과, 현재까지 오는데 걸린 min이 기존의 minEdge보다 적다면 minEdge의 값을 변경 -> 더 짧은 거리로 변경하는 과정
				if (tmp.weight + min < minEdge[tmp.to]) {
					minEdge[tmp.to] = min + tmp.weight;
				}
			}
			
		}
		for (int i = 1; i <= V; i++) {
			System.out.println(minEdge[i] == Integer.MAX_VALUE ? "INF" : minEdge[i]);
		}
		
		
	}
}
