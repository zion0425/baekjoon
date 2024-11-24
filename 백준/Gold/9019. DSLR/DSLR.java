import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    private static final char[] com = {'D', 'S', 'L', 'R'};

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int in = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (in-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append(bfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append('\n');
		}
		System.out.print(sb);
    }

    private static String bfs(int s, int t) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        boolean[] visit = new boolean[10000];

        q.offer(new Node(s, ""));
        visit[s] = true;

        while (!q.isEmpty()) {
            int curNum = q.peek().num;;
            String commands = q.poll().commands;

            if (curNum == t) return commands;
            for (char c : com) {
                int resNum = calc(curNum, c);
                if (!visit[resNum]) {
                    visit[resNum] = true;
                    q.offer(new Node(resNum, commands + c));
                }
            }
        }
        return null;
    }

    private static int calc(int num, char command) {
        switch (command) {
            case 'D': return (num * 2) % 10000;
            case 'S': return (num == 0) ? 9999 : num - 1;
            case 'L': return (num % 1000) * 10 + num / 1000;
            case 'R': return (num % 10) * 1000 + num / 10;
        }
        return -404;
    }

    private static class Node {
        int num;
        String commands;

        public Node(int num, String commands) {
            this.num = num;
            this.commands = commands;
        }
    }
}
