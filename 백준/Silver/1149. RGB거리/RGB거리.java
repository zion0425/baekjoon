
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[][] rgb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
        rgb = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // RED, GREEN, BLUE
        dp[0][0] = rgb[0][0];
        dp[0][1] = rgb[0][1];
        dp[0][2] = rgb[0][2];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
            dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
            dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
        }
        System.out.println(Math.min(Math.min(dp[N - 1][0], dp[N -1][1]), dp[N-1][2]));
    }

}
