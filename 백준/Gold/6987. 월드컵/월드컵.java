import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int TOTAL_TEAM_NUMBER = 6;
    private static ArrayList<Player> teams;
    private static boolean isRightResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            res = 0;
            isRightResult = true;
            teams = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < TOTAL_TEAM_NUMBER; j++) {
                teams.add(new Player(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
                if (!(teams.get(j).validateTotalPlayCount(5))) {
                    isRightResult = false;
                    break;
                }
            }
            if (!isRightResult) {
                System.out.print("0 ");
                continue;
            }
            play(0, 1);
            System.out.print(res + " ");

        }
    }
private static int res = 0;
    private static void play(int aIndex, int bIndex) {
        // 한 팀이 만날 수 있는 모든 팀을 다 만나 경기를 진행
        if (bIndex == 6) {
            aIndex++;
            bIndex = aIndex + 1;
        }
        if (aIndex == 5) {
            res = 1;
            return ;
        }
        Player A = teams.get(aIndex);
        Player B = teams.get(bIndex);

        // 승
        if (isPossiblePlay(A, B, Result.WIN)) {
            A.changeCount(-1, Result.WIN);
            B.changeCount(-1, Result.LOSE);
            play(aIndex, bIndex + 1);
            A.changeCount(1, Result.WIN);
            B.changeCount(1, Result.LOSE);
        }

        // 패
        if (isPossiblePlay(A, B, Result.LOSE)) {
            A.changeCount(-1, Result.LOSE);
            B.changeCount(-1, Result.WIN);
            play(aIndex, bIndex + 1);
            A.changeCount(1, Result.LOSE);
            B.changeCount(1, Result.WIN);
        }

        // 무
        if (isPossiblePlay(A, B, Result.DRAW)) {
            A.changeCount(-1, Result.DRAW);
            B.changeCount(-1, Result.DRAW);
            play(aIndex, bIndex + 1);
            A.changeCount(1, Result.DRAW);
            B.changeCount(1, Result.DRAW);
        }
    }

    private static boolean isPossiblePlay(Player A, Player B, Result res) {
        if (res == Result.WIN && A.winCount != 0 && B.loseCount != 0) {
            return true;
        } else if (res == Result.DRAW && A.drawCount != 0 && B.drawCount != 0) {
            return true;
        } else if (res == Result.LOSE && A.loseCount != 0 && B.winCount != 0) {
            return true;
        }
        return false;
    }

    enum Result {
        WIN, DRAW, LOSE
    }

    static class Player {
        private int winCount;
        private int loseCount;
        private int drawCount;

        public Player(int winCount, int drawCount, int loseCount) {
            this.winCount = winCount;
            this.drawCount = drawCount;
            this.loseCount = loseCount;
        }

        public void changeCount(int addNumber, Result res) {
            if (res == Result.WIN) {
                this.winCount += addNumber;
            } else if (res == Result.DRAW) {
                this.drawCount += addNumber;
            } else if (res == Result.LOSE) {
                this.loseCount += addNumber;
            }
        }


        public boolean validateTotalPlayCount(int playCount) {
            return (this.winCount + this.drawCount + this.loseCount == playCount);
        }

        @Override
        public String toString() {
            return "Player{" +
                    "winCount=" + winCount +
                    ", loseCount=" + loseCount +
                    ", drawCount=" + drawCount +
                    '}';
        }
    }

}
