import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputNum1 = br.readLine();
        String inputNum2 = br.readLine();
        Integer num1 = Integer.parseInt(inputNum1);
        String[] num2 = inputNum2.split("");

        for (int i = 2; i >= 0; i--) {
            System.out.println(Integer.parseInt(num2[i]) * num1);
        }
        System.out.println(Integer.parseInt(inputNum2) * num1);


    }
}