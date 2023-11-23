package org.example;

import java.io.*;

public class S11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer number = Integer.parseInt(br.readLine());

        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                bw.write(i + "\n");
                number /= i;
                i = 1;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
