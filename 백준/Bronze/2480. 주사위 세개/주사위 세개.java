import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer[] nums = new Integer[3];
        int res = 0;
        for (int i = 0; i < 3; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        if (nums[0] == nums[1] && nums[0] == nums[2]) {
            res += 10000 + nums[0] * 1000;
        } else if (nums[0] == nums[1] || nums[0] == nums[2]) {
            res += 1000 + nums[0] * 100;
        } else if (nums[1] == nums[2]) {
            res += 1000 + nums[1] * 100;
        } else if (nums[0] > nums[1] && nums[0] > nums[2]) {
            res += nums[0] * 100;
        } else if (nums[1] > nums[2]) {
            res += nums[1] * 100;
        } else {
            res += nums[2] * 100;
        }
        System.out.println(res);
    }
}


