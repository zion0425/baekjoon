package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S10818{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer inputN = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        if (st.countTokens() != inputN) {
            throw new Exception("N과 실제 입력한 숫자들의 개수가 일치하지 않습니다.");
        }

        int max = -1000001;
        int min = 1000001;
        while (st.hasMoreTokens()) {
            Integer number = Integer.parseInt(st.nextToken());
            if (max < number) {
                max = number;
            }
            if (min > number) {
                min = number;
            }
        }
        bw.write(min + " ");
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
