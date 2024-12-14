import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    private static final char[] com = {'D', 'S', 'L', 'R'};

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	ArrayDeque<Integer> q = new ArrayDeque<>();
    	StringBuilder sb = new StringBuilder();
    	while (n-- > 0) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		String com = st.nextToken();
    		switch(com) {
    			case "push" :
    				q.offer(Integer.parseInt(st.nextToken()));
    				break;
    			case "pop" :
    				sb.append(q.isEmpty() ? "-1" : q.poll()).append('\n');
    				break;
    			case "size" :
    				sb.append(q.size()).append('\n');
    				break;
    			case "empty" :
    				sb.append(q.isEmpty() ? "1" : "0").append('\n');
    				break;
    			case "front":
    				sb.append(q.isEmpty() ? "-1" : String.valueOf(q.peek())).append('\n');
    				break;
    			case "back":
    				sb.append(q.isEmpty() ? "-1" : String.valueOf(q.peekLast())).append('\n');
    				break;
    		}
    	}
    	
    	System.out.print(sb);
    	
    }
}
