import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static int diffMin;
    private static int[][] recipes;
    private static int n;
    private static boolean[] isSelected;
    private static int[] tmpArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            diffMin = Integer.MAX_VALUE;
            n = Integer.parseInt(br.readLine());
            recipes = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    recipes[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            tmpArr = new int[n / 2];
            findComb(0, 0);
            System.out.println("#" + t + " " + diffMin);
        }
    }

    private static void combReceipes() {
        int cook1 = 0, cook2 = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // 현재 선택 판단
                if (isSelected[i] && isSelected[j])
                    cook1 += recipes[i][j] + recipes[j][i];
                // 나머지 선택
                if (!isSelected[i] && !isSelected[j])
                    cook2 += recipes[i][j] + recipes[j][i];
            }
        }
        // 둘의 차이 중 최소값
        diffMin = Math.min(Math.abs(cook1 - cook2), diffMin);

    }

    private static void findComb(int d, int start) {
        if (d == n / 2) {
            isSelected = new boolean[n];
            for (int i = 0; i < tmpArr.length; i++) {
                isSelected[tmpArr[i]] = true;
            }
            combReceipes();
            return;
        }

        for (int i = start; i < n; i++) {
            tmpArr[d] = i;
            findComb(d + 1, i + 1);
        }

    }
}
