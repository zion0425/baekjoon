import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            long m = Long.parseLong(br.readLine());

            while (!isPrime(m)) {
                m++;
            }
            sb.append(m).append('\n');
        }
        System.out.print(sb);
    }

    private static boolean isPrime(long num) {
        if (num <= 1) return false;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}