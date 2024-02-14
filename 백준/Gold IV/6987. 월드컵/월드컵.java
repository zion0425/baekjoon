import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] team1;
    static int[] team2;
    static int[] win;
    static int[] draw;
    static int[] lose;
    static boolean avali;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = 4;
        int cnt = 0;

        team1 = new int[15];
        team2 = new int[15];

        for(int i = 0; i < 5; i++){
            for(int j = i+1; j < 6; j++){
                team1[cnt] = i;
                team2[cnt++] = j;
            }
        }

        for(int t = 0; t < T; t++){
            String s = br.readLine();
            st = new StringTokenizer(s);
            win = new int[6];
            draw = new int[6];
            lose = new int[6];
            avali = false;
            int w = 0, d = 0, l = 0;
            for(int i = 0; i < 6; i++){
                w += win[i] = Integer.parseInt(st.nextToken());
                d += draw[i] = Integer.parseInt(st.nextToken());
                l += lose[i] = Integer.parseInt(st.nextToken());
            }
            if(w+d+l != 30){
                avali = false;
            }else{
                DFS(0);
            }
            if(avali){
                System.out.print(1+" ");
            }else{
                System.out.print(0 + " ");
            }
        }


    }

    public static void DFS(int idx){
        if(avali) return;
        if(idx == 15){
            avali = true;
            return;
        }
        int a = team1[idx];
        int b = team2[idx];

        if(win[a] > 0 && lose[b] > 0){
            win[a]--;
            lose[b]--;
            DFS(idx+1);
            win[a]++;
            lose[b]++;
        }

        if(draw[a] > 0 && draw[b] > 0){
            draw[a]--;
            draw[b]--;
            DFS(idx+1);
            draw[a]++;
            draw[b]++;
        }

        if(lose[a] > 0 && win[b] > 0){
            lose[a]--;
            win[b]--;
            DFS(idx+1);
            lose[a]++;
            win[b]++;
        }
    }
}
