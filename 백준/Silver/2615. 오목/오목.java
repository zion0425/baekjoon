import java.util.Scanner;

public class Main {

    static int[][] delta = {{0,1}, {1,0}, {1,1}, {-1, 1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[19][19];

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] != 0) {
                    int color = map[i][j];
                    for (int d = 0; d < delta.length; d++) {
                        int count = 1;
                        int nx = i + delta[d][0];
                        int ny = j + delta[d][1];

                        while (nx >= 0 && ny >= 0 && nx < 19 && ny < 19 && map[nx][ny] == color) {
                            count++;
                            nx += delta[d][0];
                            ny += delta[d][1];
                        }

                        if (count == 5) {
                            int px = i - delta[d][0];
                            int py = j - delta[d][1];
                            if (px >= 0 && py >= 0 && px < 19 && py <19 && map[px][py] == color) continue;
                            if (nx >= 0 && ny >= 0 && nx < 19 && ny < 19 && map[nx][ny] == color) continue;

                            System.out.println(color + "\n" + (i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }
}