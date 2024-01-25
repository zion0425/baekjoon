import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int START_NUMBER = 100;

    private static boolean[] noNumbers;
    private static int targetChannel;
    private static long clickCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        targetChannel = Integer.parseInt(br.readLine());
        int noNumberCount = Integer.parseInt(br.readLine());

        if (noNumberCount == 0) {
            bw.write(Math.min(Math.abs(100 - targetChannel), String.valueOf(targetChannel).length()) + "");
            bw.flush();
            return;
        }

        noNumbers = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            noNumbers[Integer.parseInt(st.nextToken())] = true;
        }

        clickCount = Math.abs(targetChannel - START_NUMBER);

        find(0, 0);
        bw.write(clickCount +"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void find(int index, int click) {
        for (int i = 0; i < 10; i++) {
            if (!noNumbers[i]) {
                int channelNumber = click * 10 + i;
                int count = Math.abs(targetChannel - channelNumber) + String.valueOf(channelNumber).length();
                clickCount = Math.min(clickCount, count);

                if (index < 6) {
                    find(index + 1, channelNumber);
                }
            }
        }
    }
}