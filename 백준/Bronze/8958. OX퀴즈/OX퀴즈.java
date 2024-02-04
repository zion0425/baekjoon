import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int t = 0; t < n; t++) {
            String[] str = br.readLine().split("");
            int cnt = 0;
            int sum = 0;
            for (int i = 0; i < str.length; i++) {
                if(str[i].equals("X")) {
                    cnt = 0;
                    continue;
                }
                cnt++;
                sum+= cnt;
            }
            System.out.println(sum);
        }
    }
}
