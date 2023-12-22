import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String startHM = br.readLine();
        int loadingM = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(startHM);
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int res = h * 60 + m + loadingM;

        h = res / 60;
        m = res % 60;

        if ( h >= 24 ) {
            h %= 24;
        }
        System.out.println(h + " " + m);
    }
}
