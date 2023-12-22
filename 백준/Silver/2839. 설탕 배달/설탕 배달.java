import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputNum = br.readLine();

        int num = Integer.parseInt(inputNum);
        int cnt = (num == 3) ? 1 : -1;
        int tmpNum;
        for (int i = num / 5; i >= 0; i--) {
            cnt = i;
            tmpNum = num;
            tmpNum -= (i * 5);
            if (tmpNum % 3 == 0) {
                cnt += tmpNum / 3;
                break;
            }
            cnt = -1;
        }
        System.out.println(cnt);
    }
}