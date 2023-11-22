package org.example;

import java.io.*;
import java.util.Arrays;

public class S10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer alphabets[] = new Integer[26];
        Arrays.fill(alphabets, -1);

        String input = br.readLine();
        input = input.toUpperCase();
        char[] inputs = input.toCharArray();

        for (int i =0; i < inputs.length; i++) {
            if (alphabets[inputs[i] - 65] == -1)
                alphabets[inputs[i] - 65] = i;
        }

        for (Integer a : alphabets) {
            bw.write(a + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
