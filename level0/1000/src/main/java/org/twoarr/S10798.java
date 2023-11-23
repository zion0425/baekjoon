package org.twoarr;

import java.io.*;

public class S10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[][] arr = new String[15][5];

        for (int j = 0; j < 5; j++) {
            String[] inputs = br.readLine().split("");
            for (int i = 0; i < inputs.length; i++) {
                arr[i][j] = inputs[i];
            }
        }

        for (String[] a : arr) {
            for (String b : a) {
                if (b != null)
                    bw.write(b);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
