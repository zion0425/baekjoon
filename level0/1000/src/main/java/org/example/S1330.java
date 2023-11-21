package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class S1330 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        Integer leftValue = Integer.parseInt(st.nextToken());
        Integer rightValue = Integer.parseInt(st.nextToken());

        if (leftValue > rightValue) {
            bw.write(">");
        } else if (leftValue < rightValue) {
            bw.write("<");
        } else if (leftValue.equals(rightValue)) {
            bw.write("==");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
