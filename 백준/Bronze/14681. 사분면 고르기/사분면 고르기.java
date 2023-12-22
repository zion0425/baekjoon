import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int res = 1;

        if (x > 0) {
            if (y < 0)
                res = 4;
        } else if (x < 0) {
            res = 2;
            if (y < 0)
                res = 3;
        }

        System.out.println(res);
    }
}
