import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer num = Integer.parseInt(br.readLine());
        Integer resNum = 0;
        int cnt = 0;
        for (Integer i = 666; cnt < num; i++) {
            if (String.valueOf(i).contains("666")) {
                cnt++;
                resNum = i;
            }
        }
        bw.write(resNum + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
