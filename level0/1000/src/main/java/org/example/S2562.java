package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S2562 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0;
        int maxIndex = 0;
        for (int i = 1; i <= 9; i++) {
            Integer inputNumber = Integer.parseInt(br.readLine());
            if (max < inputNumber) {
                maxIndex = i;
                max = inputNumber;
            }
        }
        bw.write(max + "\n" + maxIndex);
        bw.flush();
        bw.close();
        br.close();
    }
}

