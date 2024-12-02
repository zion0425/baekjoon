import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] DP = new int[n][3];
        StringBuilder sb = new StringBuilder();
        DP[0] = arr[0];

        for (int i = 1; i< n; i++) {
            DP[i][0] = Math.max(DP[i - 1][0], DP[i - 1][1]) + arr[i][0];
            DP[i][1] = Math.max(Math.max(DP[i-1][0], DP[i-1][1]), DP[i-1][2]) + arr[i][1];
            DP[i][2] = Math.max(DP[i-1][1], DP[i-1][2]) + arr[i][2];
        }

        sb.append(Math.max(Math.max(DP[n - 1][0], DP[n - 1][1]), DP[n - 1][2])).append(' ');

        DP = new int[n][3];
        DP[0] = arr[0];
        for (int i = 1; i< n; i++) {
            DP[i][0] = Math.min(DP[i - 1][0], DP[i - 1][1]) + arr[i][0];
            DP[i][1] = Math.min(Math.min(DP[i-1][0], DP[i-1][1]), DP[i-1][2]) + arr[i][1];
            DP[i][2] = Math.min(DP[i-1][1], DP[i-1][2]) + arr[i][2];
        }
        sb.append(Math.min(Math.min(DP[n - 1][0], DP[n - 1][1]), DP[n - 1][2]));

        System.out.println(sb);
    }
}