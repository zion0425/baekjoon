import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        HashMap<Integer,Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n -- > 0) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, num);
        }

        n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        while (n -- > 0) {
            int num = Integer.parseInt(st.nextToken());
            sb.append ((map.get(num) != null) ? '1' : '0').append(' ');
        }

        System.out.println(sb);

    }
}