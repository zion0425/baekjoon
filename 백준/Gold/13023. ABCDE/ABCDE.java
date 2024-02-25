import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * edge 만들고
 * edgeList로 edge 정보들 넣고, 각각의 엣지마다 to를 따라가서 4번 따라갈 수 있다면 true
 */
public class Main {

    static int n;
    static int m;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        for (int i = 0 ; i < n; i++)  {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(to);
            list[to].add(from);
        }

        boolean istrue = false;
        for (int i = 0; i < list.length; i++){
            visit = new boolean[n];
            visit[i] = true;
            if (dfs(0, i)) {
                istrue = true;
                break;
            }
        }
        System.out.println(istrue ? 1 : 0);
    }
    private static boolean[] visit;

    public static boolean dfs(int d, int index) {
        if (d == 4) {
            return true;
        }
        visit[index] = true;
        for (int i  = 0; i < list[index].size(); i++) {
            if (!visit[list[index].get(i)]) {
                if (dfs(d + 1, list[index].get(i))) return true;
            }
        }
        visit[index] = false;

        return false;
    }
}
