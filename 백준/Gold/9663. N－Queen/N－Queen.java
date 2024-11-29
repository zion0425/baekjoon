import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, cnt = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        DFS(0);
        System.out.println(cnt);
    }

    private static void DFS(int d) {
        if (d == N) {
            cnt++;
            return ;
        }
        for (int i = 0; i < N; i++) {
            arr[d] = i;
            if (canPos(d)) DFS(d + 1);
        }
    }

    private static boolean canPos(int d) {
        for (int j = 0; j < d; j++) {
            if (arr[j] == arr[d]) return false;
            else if (Math.abs(d - j) == Math.abs(arr[d] - arr[j])) return false;
        }
        return true;
    }
}