import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int[] delta = {1, 2, 3, 4, 5, 6};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ladderN = Integer.parseInt(st.nextToken());
        int snakeN = Integer.parseInt(st.nextToken());

        ArrayDeque<int[]> q = new ArrayDeque<>();

        int[] map = new int[107];

        for (int i = 0; i < ladderN + snakeN; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start] = end;
        }

        for (int i = 0; i < 101; i++) {
            if(map[i] == 0) map[i] = i;
        }

        boolean[] visited = new boolean[107];

        q.offer(new int[] {1,0});

        while (!q.isEmpty()) {
            int cPos = q.peek()[0];
            int count = q.poll()[1];

            if (cPos >= 100) {
                System.out.println(count);
                return;
            }

            for (int i = 0; i< delta.length; i++) {
                int num = map[cPos + delta[i]];
                if(!visited[num]) {
                    q.offer(new int[] {num, count + 1});
                    visited[num] = true;
                }
            }
        }

    }



}