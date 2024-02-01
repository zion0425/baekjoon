import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[] chars = br.readLine().toCharArray();

        // 입력 ACGT 개수를 저장하는 배열
        int[] ACGT = new int['T' + 1];
        char[] alphaACGT = {'A', 'C', 'G', 'T'};

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i ++) {
            ACGT[alphaACGT[i]] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++)
            --ACGT[chars[i]];

        int cnt = Arrays.stream(ACGT).allMatch(value -> value <= 0) ? 1 : 0;

        for (int i = m; i < chars.length; i++) {
             ACGT[chars[i]]--;
             ACGT[chars[i - m]]++;
             if (Arrays.stream(ACGT).allMatch(value -> value <= 0)) {
                 cnt++;
             }
        }

        System.out.println(cnt);

    }
}
