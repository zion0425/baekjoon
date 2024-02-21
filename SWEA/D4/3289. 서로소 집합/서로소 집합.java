import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr = new int[n + 1];
            sb.append("#").append(t).append(" ");
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                if (st.nextToken().equals("0")) {
                    union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                } else {
                    sb.append(findGroup(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int findSet(int num) {
        if (arr[num] == 0)
            return num;
        return arr[num] = findSet(arr[num]);
    }

    private static char findGroup(int a, int b) {
        return findSet(a) == findSet(b) ? '1' : '0';
    }

    private static void union(int a, int b) {
        int ca = findSet(a);
        int cb= findSet(b);
        if (ca != cb)
            arr[ca] = cb;
    }
}
