import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static class Coordinate {
        public int y;
        public int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int n;
    static int m;
    static ArrayList<Coordinate> chicken;
    static ArrayList<Coordinate> house;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        house = new ArrayList<>();
        chicken = new ArrayList<>();

        int[][] map = new int[n][n];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 2) {
                    chicken.add(new Coordinate(y, x));
                } else if (map[y][x] == 1) {
                    house.add(new Coordinate(y, x));
                }
            }
        }
        chickens = new int[m];
        findChic(0, 0);
        System.out.println(min);
    }


    private static int[] chickens;

    private static void findChic(int d, int n) {
        if (d == m) {
            findMinDistance(0);
            return ;
        }
        for (int i = n; i < chicken.size(); i++) {
            chickens[d] = i;
            findChic(d + 1, i + 1);
        }
    }

    private static void findMinDistance(int sum) {
        for (int h = 0; h < house.size(); h++) {
            Coordinate curHouse = house.get(h);
            int curMinDistance = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                Coordinate curChic = chicken.get(chickens[i]);
                curMinDistance = Math.min(curMinDistance, Math.abs(curChic.x - curHouse.x) + Math.abs(curChic.y - curHouse.y));
            }
            sum += curMinDistance;
        }
        min = Math.min(sum, min);
    }

}
