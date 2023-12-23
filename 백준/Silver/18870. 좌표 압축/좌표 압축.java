import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] nums1 = new Integer[N];
        Integer[] nums2 = new Integer[N];

        for (int i = 0; i < N; i++) {
            nums2[i] = nums1[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums1);

        HashMap<Integer,Integer> map = new HashMap<>();
        int index = 0;
        for (Integer num : nums1) {
            if (!map.containsKey(num))
                map.put(num, index++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int ranking = map.get(nums2[i]);
            sb.append(ranking).append(' ');
        }

        System.out.println(sb);
    }
}


