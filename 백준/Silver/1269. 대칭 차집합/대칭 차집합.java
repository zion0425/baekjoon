import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> A = new HashSet<>(), B = new HashSet<>(), tmp = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        tmp = (HashSet<Integer>) A.clone();
        A.removeAll(B);
        B.removeAll(tmp);
        System.out.println(A.size() + B.size());
    }
}