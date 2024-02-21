import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 서로소 집합 DisJointSet
 */
public class Solution {
    private static int[] arr;

    // 최대 간선의 수 N(N - 1) / 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 1 ~ 100
            int m = Integer.parseInt(st.nextToken()); // 0 ~ 완전그래프 간선 개수
            
            // 대표자를 0으로 지정하면 굳이 makeSet을 할 필요 없음
//            makeSet(n);
            arr = new int[n + 1];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
            }

            int cnt = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == 0)  cnt++;
            }
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);

    }

    /**
     * 1 ~ n, 각 원소를 하나의 구성 요소로 하는 집합 생성
     */
    public static void makeSet(int n) {
        arr = new int[n + 1]; // 0은 안 씀
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    /**
     * x 원소의 집합의 대표자를 리턴
     */
    public static int findSet(int x) {
        // 내가 대표자일 경우
        if (arr[x] == 0) {
            return x;
        } else { // 내가 대표자가 아닐 경우
            return arr[x] = findSet(arr[x]);
        }
    }

    /**
     * 두 원소의 집합 합치기
     */
    public static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
        if (px == py) { // 같은 집합
            return;
        } else { // 다른 집합
            arr[px] = py;
        }
    }
}
// 사람이 1 ~ N 까지 있다 몇 다리를 거쳐 알게 되는 관계를 하나의 무리라고 한다.
