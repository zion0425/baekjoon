import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] tops = new int[n + 1];
		int[] printNumber = new int[n + 1];
		
		Stack<Integer> indexStack = new Stack<>(); 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			tops[i] = Integer.parseInt(st.nextToken());
			printNumber[i] = 0;
		}
		
		for (int i = n; i > 0; i--) {
			indexStack.push(i);
			while (!indexStack.isEmpty() && tops[i - 1] >= tops[indexStack.peek()]) {
				printNumber[indexStack.pop()] = i - 1; 
			}
		}
		
		for (int i = 1; i < printNumber.length; i++)  {
			System.out.print(printNumber[i] + " ");
		}
	}
}