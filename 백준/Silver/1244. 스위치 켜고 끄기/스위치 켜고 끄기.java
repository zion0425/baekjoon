import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] switches = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int studentCount = Integer.parseInt(br.readLine());

        for (int t = 0; t < studentCount; t++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int sNum = Integer.parseInt(st.nextToken());

            if (s.equals("1")) {
                for (int i = sNum; i < switches.length; i += sNum) {
                    switches[i] = Math.abs(switches[i] - 1);
                }
            } else {
                int j = sNum - 1;
                int k = sNum + 1;
                switches[sNum] = Math.abs(switches[sNum] - 1);
                for (; j >= 1 && k < switches.length; k++, j--) {
                    if (switches[k] != switches[j]) {
                        break;
                    }
                    switches[j] = switches[k] = Math.abs(switches[j] - 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for (int i = 1; i < switches.length; i++) {
            sb.append(switches[i]).append(' ');
            if (++cnt == 20) {
                cnt = 0;
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}