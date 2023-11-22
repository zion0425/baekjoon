import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] correctDeck = {1, 1, 2, 2, 2, 8};
        int inputSize = st.countTokens();
        for (int i = 0; i < inputSize; i++) {
            correctDeck[i] -= Integer.parseInt(st.nextToken());
            bw.write(correctDeck[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}