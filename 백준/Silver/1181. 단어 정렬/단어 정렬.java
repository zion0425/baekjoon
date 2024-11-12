import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> wordSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            wordSet.add(br.readLine());
        }

        List<String> words = new ArrayList<>(wordSet);
        words.sort((a, b) -> a.length() == b.length()? a.compareTo(b) : Integer.compare(a.length(), b.length()));

        for (String word : words) {
            System.out.println(word);
        }
    }
}