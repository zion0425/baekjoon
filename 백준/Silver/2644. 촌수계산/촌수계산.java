
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, a, b, m;
    static int[] peoples;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        peoples = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            peoples[child] = parent;
        }
        System.out.println(calc());
    }

    static int calc() {
        int cntA = 0, cntB = 0, tmpA = a, tmpB = b;
        int[] visitA = new int[n + 1];

        while (tmpA != 0) {
            visitA[tmpA] = ++cntA;
            tmpA = peoples[tmpA];
        }

        while (tmpB != 0) {
            if (visitA[tmpB] > 0) {
                return cntB + visitA[tmpB] - 1;
            }
            tmpB = peoples[tmpB];
            cntB++;
        }

        return -1;
    }
}