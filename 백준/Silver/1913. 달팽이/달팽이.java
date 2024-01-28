
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];


        int[][] alpha = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int num = 2;
        int x = n/2;
        int y = n/2;
        int aIndex = 0;

        map[y][x] = 1;
        String point = (y+1) + " " + (x+1);

        int cnt = 1;
        while (num <= n * n) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < cnt; j++) {
                    int rx = x + alpha[aIndex][1];
                    int ry = y + alpha[aIndex][0];
                    if (rx >= 0 && rx < n && ry >=0 && ry < n) {
                        if (num > n * n)
                            break;
                        if (num == target) {
                            point = (ry + 1) + " " + (rx + 1);
                        }
                        map[ry][rx] = num++;

                        x = rx;
                        y = ry;

                    }
                }
                aIndex = (aIndex + 1) % 4;
            }
            cnt++;
        }

        for (int[] ns: map) {
            for (int nn : ns) {
                bw.write(nn + " ");
            }
            bw.write("\n");
        }
        bw.write(point);
        bw.flush();
        br.close();
        bw.close();
    }
}
