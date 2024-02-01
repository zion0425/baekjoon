import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    public static void main(String[] args) throws IOException {
        int[] primNumbers = {2, 3, 5, 7};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int num :primNumbers) {
            rec(0, num);
        }
    }

    private static void rec(int index, int num) {
        if (index == n - 1) {
            System.out.println(num);
            return ;
        }
        for (int i = 1; i < 10; i++) {
            int tmpNum = num * 10 + i;
            if (!isPrime(tmpNum)) {
                continue;
            }
            rec(index + 1, tmpNum);
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
