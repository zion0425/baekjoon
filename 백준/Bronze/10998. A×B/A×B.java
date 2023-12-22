import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nums = br.readLine();
        StringTokenizer st = new StringTokenizer(nums);

        System.out.println(Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
    }
}