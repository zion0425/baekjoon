package org.example;

import java.io.*;

public class S11781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";
        while ((input = br.readLine()) != null) {
            bw.write(input + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
