import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int num;
        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "add" :
                    num = Integer.parseInt(st.nextToken());
                    ans |=  1 << num;
                    break;
                case "remove" :
                    num = Integer.parseInt(st.nextToken());
                    ans &= ~(1 << num);
                    break;
                case "check" :
                    num = Integer.parseInt(st.nextToken());
                    sb.append(((ans & 1 << num) == 0) ? "0" : "1").append('\n');
                    break;
                case "toggle" :
                    num = Integer.parseInt(st.nextToken());
                    ans ^= 1 << num;
                    break;
                case "all" :
                    ans |= ~0;
                    break;
                case "empty" :
                    ans &= 0;
                    break;
            }
        }
        System.out.print(sb);

    }
}
