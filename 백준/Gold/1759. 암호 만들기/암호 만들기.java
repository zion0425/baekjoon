import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int l;
    private static int c;
    private static char[] alphabet;
    private static char[] password;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        alphabet = new char[c];
        password = new char[l];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabet);
        creatCombAlpha(0, 0);
        System.out.println(sb);
    }

    private static void creatCombAlpha(int d, int start) {
        if (d == l) {
            isPasswordComb();
            return ;
        }
        for (int i = start; i < c; i++) {
            password[d] = alphabet[i];
            creatCombAlpha(d + 1, i + 1);
        }
    }

    private static void isPasswordComb() {
        int aeiouCnt = 0;
        int otherCnt = 0;
        for (int i = 0; i < l; i++) {
            if (password[i] == 'a' || password[i] == 'e' || password[i] == 'i'
            || password[i] == 'o' || password[i] == 'u') {
                aeiouCnt++;
            } else {
                otherCnt++;
            }
        }
        if (aeiouCnt >= 1 && otherCnt >= 2) {
            sb.append(password).append('\n');
        }
    }
}
