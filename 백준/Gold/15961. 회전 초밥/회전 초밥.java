import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] sushi;
        int[] eatFoodType;
        int diffFoodCnt;
        int n, d, k, c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new int[n];
        eatFoodType = new int[d + 1];
        diffFoodCnt = 0;

        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            if (eatFoodType[sushi[i]]++ == 0) {
                diffFoodCnt++;
            }
        }

        int max = (eatFoodType[c] == 0 ? diffFoodCnt + 1 : diffFoodCnt);
        for (int i = k; i < n + k; i++) {
            // 먹은 음식 중에 보너스 음식이 없다면(테이블에 보너스 음식이 없어도 주방장이 갖다 놓으니까) 추가로 먹을 수 있으므로 무조건 +1)
            max = Math.max((eatFoodType[c] == 0) ? diffFoodCnt + 1 : diffFoodCnt, max);
            // 앞의 인덱스를 뒤로 이동해서 하나만 있는 음식 종류가 빠지면 cnt--
            if (--eatFoodType[sushi[i - k]] == 0) diffFoodCnt--;
            // 뒤의 인덱스를 뒤로 이동해서 하나밖에 없는 음식 종류가 들어오면 cnt++
            if (eatFoodType[sushi[(i) % n]]++ == 0) diffFoodCnt++;

        }
        System.out.println(max);
    }
}
