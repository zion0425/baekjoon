import java.io.*;

public class Main {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] fib = new int[41][2];

        fib[0][0] = 1;
        fib[0][1] = 0;
        fib[1][0] = 0;
        fib[1][1] = 1;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = 2; j <= n; j++) {
                fib[j][0] = fib[j - 1][0] + fib[j - 2][0];
                fib[j][1] = fib[j - 1][1] + fib[j - 2][1];
            }
            sb.append(fib[n][0]).append(' ').append(fib[n][1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}