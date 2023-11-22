package org.example;

import java.io.*;
import java.util.Arrays;

public class S5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Boolean[] checked = new Boolean[31];
        Arrays.fill(checked, false);
        for (int i = 1; i <= 28; i++) {
            checked[Integer.parseInt(br.readLine())] = true;
        }

        for (int j = 1; j < checked.length; j++) {
            if (!checked[j]) {
                bw.write(j + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}