package org.example;

import java.io.*;
import java.util.Arrays;

public class S1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        String[] inputs = br.readLine().split(" ");
        Integer[] numbers = Arrays.stream(inputs)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);

        int max = Arrays.stream(numbers)
                .mapToInt(value -> value)
                .max()
                .orElse(0);

        int cnt = 0;
        float sum = 0;

        for (; cnt < numbers.length; cnt++) {
            sum += (float)numbers[cnt] / max * 100.0;
        }
        bw.write(sum / cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
