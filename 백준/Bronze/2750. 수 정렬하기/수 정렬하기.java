import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> a = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(a);

        for (int i = 0; i < n; i++) {
            System.out.println(a.get(i));
        }
    }
}