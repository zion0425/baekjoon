package org.stream;

import java.io.*;
import java.util.Arrays;

public class S10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        String inputs = br.readLine();
        String inputNumbers[] = inputs.split(" ");
        String matchCharacter = br.readLine();

        long count = Arrays.stream(inputNumbers)
                .filter(s -> s.equals(matchCharacter))
                .count();

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
