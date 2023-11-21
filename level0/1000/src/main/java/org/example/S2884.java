package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S2884 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer hour = 0;
        Integer minute = 0;

        hour = Integer.parseInt(st.nextToken());
        minute = Integer.parseInt(st.nextToken());

        if (minute < 45 && (hour = hour - 1) == -1) {
            hour = 23;
        }

        minute = (minute + 15) % 60;
        bw.write(hour + " " + minute);
        bw.flush();
    }
}
