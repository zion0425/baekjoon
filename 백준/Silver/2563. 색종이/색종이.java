import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[][] whiteSection = new boolean[101][101];
        for (boolean[] a : whiteSection) {
            Arrays.fill(a, false);
        }

        StringTokenizer st;
        Integer paperCount = Integer.parseInt(br.readLine());
        while (paperCount-- > 0) {
            st = new StringTokenizer(br.readLine());
            int input1 = Integer.parseInt(st.nextToken());
            int input2 = Integer.parseInt(st.nextToken());
            for (int i = input1; i < input1 + 10; i++) {
                for (int j = input2; j < input2 + 10; j++) {
                    whiteSection[i][j] = true;
                }
            }
        }

        int cnt = 0 ;
        for (int i = 0 ; i < 100; i++){
            for (int j = 0; j < 100; j ++) {
                if (whiteSection[i][j] == true)
                    cnt ++;
            }
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
