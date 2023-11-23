import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";
        int sum = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while (!(input = br.readLine()).equals("-1")) {
            Integer number = Integer.parseInt(input);
            sum = 0;
            arr.clear();
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    arr.add(i);
                    sum += i;
                }
            }
            if (sum == number) {
                bw.write(number + " = ");
                for (int i = 0 ; i < arr.size(); i ++) {
                    bw.write(arr.get(i) + "");
                    if (i != arr.size() - 1) {
                        bw.write(" + ");
                    }
                }
            } else {
                bw.write(number + " is NOT perfect.");
            }
            bw.write("\n");
            
        }
        bw.flush();
        bw.close();
        br.close();
    }
}