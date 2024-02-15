import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    private static int[] tankPosition;
    static int h;
    static int w;
    private static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());


        for (int t = 1; t <= testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new String[h][w];
            tankPosition = new int[2];
            for (int i = 0; i < h; i++) {
                String[] str = br.readLine().split("");
                for (int j = 0; j < w; j++) {
                    map[i][j] = str[j];
                    findTank(i, j);
                }
            }
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split("");
            for (int i = 0; i < n; i++) {
                move(str[i]);
            }
            StringBuilder sb = new StringBuilder();

            sb.append("#").append(t).append(" ");
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++){
                    sb.append(map[i][j]);
                }
                if (i != h - 1) sb.append('\n');
            }
            System.out.println(sb);
        }

    }

    static void findTank(int y, int x) {
        switch (map[y][x]) {
            case "<":
            case ">":
            case "^":
            case "v":
                tankPosition[0] = y;
                tankPosition[1] = x;
                break;
        }
    }

    static void move(String input) {
        int y = tankPosition[0];
        int x = tankPosition[1];
        switch (input) {
            case "U":
                map[y][x] = "^";
                if (isIn(y - 1, x) && canMove(y - 1, x)) {
                    map[y--][x] = ".";
                    map[y][x] = "^";
                    tankPosition[0] = y;
                }
                break;
            case "D":
                map[y][x] = "v";
                if (isIn(y + 1, x) && canMove(y + 1, x)) {
                    map[y++][x] = ".";
                    map[y][x] = "v";
                    tankPosition[0] = y;
                }
                break;
            case "L":
                map[y][x] = "<";
                if (isIn(y, x - 1) && canMove(y, x - 1)) {
                    map[y][x--] = ".";
                    map[y][x] = "<";
                    tankPosition[1] = x;
                }
                break;
            case "R":
                map[y][x] = ">";
                if (isIn(y, x + 1) && canMove(y, x + 1)) {
                    map[y][x++] = ".";
                    map[y][x] = ">";
                    tankPosition[1] = x;
                }
                break;
            case "S":
                shoot();
        }
    }

    static void shoot() {
        int y = tankPosition[0];
        int x = tankPosition[1];
        switch (map[y][x]) {
            case "<":
                for (int i = x; isIn(y, i); i--) {
                    if (map[y][i].equals("*")) {
                        map[y][i] = ".";
                        break;
                    } else if (map[y][i].equals("#")) {
                        break;
                    }
                }
                break;
            case ">":
                for (int i = x; isIn(y, i); i++) {
                    if (map[y][i].equals("*")) {
                        map[y][i] = ".";
                        break;
                    } else if (map[y][i].equals("#")) {
                        break;
                    }
                }
                break;
            case "^":
                for (int i = y; isIn(i, x); i--) {
                    if (map[i][x].equals("*")) {
                        map[i][x] = ".";
                        break;
                    } else if (map[i][x].equals("#")) {
                        break;
                    }
                }
                break;
            case "v":
                for (int i = y; isIn(i, x); i++) {
                    if (map[i][x].equals("*")) {
                        map[i][x] = ".";
                        break;
                    } else if (map[i][x].equals("#")) {
                        break;
                    }
                }
                break;
        }
    }

    static boolean canMove(int y, int x) {
       switch (map[y][x]) {
           case "*" :
           case "#" :
           case "-" : return false;
           default : return true;
        }
    }

    static boolean isIn(int y, int x) {
        return (y < h && y >= 0 && x >= 0 && x < w);
    }

}
