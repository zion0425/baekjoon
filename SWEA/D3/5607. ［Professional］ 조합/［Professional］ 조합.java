import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.StringTokenizer;

public class Solution {
    static long p = 1234567891;
    public static void main(String[] args) throws IOException {
        int n, r;
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            long res = nCr(n, r);
            sb.append("#").append(t).append(" ").append(res).append("\n");
        }
        System.out.println(sb);
    }

    static long nCr (int n, int r) {
        if (r == 0) return 1L;

        long[] fac = new long[n + 1];
        fac[0] = 1;
        for (int i = 1; i <= n; i++) {
            fac[i] = fac[i - 1] * i % p;
        }
        return (fac[n] * power(fac[r], p - 2)
                % p * power(fac[n - r], p - 2)
                % p )
                % p;
    }

    static long power(long x, long y) {
        long res = 1L;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1) res = (res * x) % p;
            y = y >> 1;
            x = x * x % p;
        }
        return res;
    }

}
