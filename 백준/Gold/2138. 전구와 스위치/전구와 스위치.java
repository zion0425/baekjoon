import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());

		int[] switches = new int[n];
		int[] targetSwithces = new int[n];

		String[] st1 = br.readLine().split("");
		String[] st2 = br.readLine().split("");
		for (int i = 0; i < n; i++) {
			switches[i] = Integer.parseInt(st1[i]);
			targetSwithces[i] = Integer.parseInt(st2[i]);
		}

		int result1 = 0;
		int result2 = 0;

		int[] clickOneSwitch = switches.clone();
		changeSwitch(clickOneSwitch, 0);
		result2++;

		for (int i = 1; i < n; i++) {
			if (switches[i - 1] != targetSwithces[i - 1]) {
				changeSwitch(switches, i);
				result1++;
			}
			if (clickOneSwitch[i - 1] != targetSwithces[i - 1]) {
				changeSwitch(clickOneSwitch, i);
				result2++;
			}
		}

		if (Arrays.equals(targetSwithces, switches) && Arrays.equals(targetSwithces, clickOneSwitch)) {
			bw.write(Math.min(result1, result2) + "");
		} else if (Arrays.equals(targetSwithces, switches)) {
			bw.write(result1 + "");
		} else if (Arrays.equals(targetSwithces, clickOneSwitch)) {
			bw.write(result2 + "");
		} else {
			bw.write(-1 + "");
		}

		bw.flush();
	}

	private static void changeSwitch(int[] switches, int i) {
		switches[i] = Math.abs(switches[i] - 1);
		if (i != 0) {
			switches[i - 1] = Math.abs(switches[i - 1] - 1);
		}
		if (i != n - 1) {
			switches[i + 1] = Math.abs(switches[i + 1] - 1);
		}
	}
}