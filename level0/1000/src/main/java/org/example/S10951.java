package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class S10951 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";
        StringTokenizer st;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bw.write(A + B + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
