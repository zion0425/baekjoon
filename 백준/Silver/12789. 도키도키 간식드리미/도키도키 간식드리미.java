import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	ArrayDeque<Integer> s1 = new ArrayDeque<>();
    	Stack<Integer> s2 = new Stack<>();

    	StringTokenizer st = new StringTokenizer(br.readLine());
    	while (n-- > 0) {
    		s1.offer(Integer.parseInt(st.nextToken()));
    	}
    	
    	n = 1;
    	
    	while (!s2.isEmpty() || !s1.isEmpty()) {
    		if (!s2.isEmpty() && s2.peek() == n) {
    			s2.pop();
    			n++;
    			continue;
    		}
    		if (s1.peek() == n) {
    			s1.poll();
    			n++;
    			continue;
    		}
    		int cur = s1.poll();
    		if (!s2.isEmpty() && cur > s2.peek()) {
    	    	System.out.println("Sad");
    			return;
    		}
    		s2.push(cur);
    	}
    	
    	System.out.println("Nice");
    	
    }
}
