import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(br.readLine());
        int res = 0;

        if (year % 4 == 0 && year % 100 != 0)
            res = 1;
        if (year % 100 == 0 && year % 400 == 0)
            res = 1;

        System.out.println(res);
    }
}
