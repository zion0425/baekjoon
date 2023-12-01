package org.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class S1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());

        boolean isWhite;
        int cnt = 0;
        int min = 999;
        String[][] board = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            board[i] = br.readLine().split("");
        }

        for (int i = 0; i < rows - 7; i++) {
            for (int j = 0; j < cols - 7; j++) {
                isWhite = true;
                if (board[i][j].equals("B")) {
                    isWhite = false;
                }
                cnt = calculateWrongCount(board, i, j, isWhite);
                if (min > cnt) {
                    min = cnt;
                }
                cnt = calculateWrongCount(board, i, j, !isWhite);
                if (min > cnt) {
                    min = cnt;
                }
            }

        }
        bw.write(min + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static Integer calculateWrongCount(String[][] board, int rowStartIndex, int colStartIndex, boolean isWhite) {
        int cnt = 0;
        for (int i = rowStartIndex; i < rowStartIndex + 8; i++) {
            for (int j = colStartIndex; j < colStartIndex + 8; j++) {
                if (board[i][j].equals(isWhite ? "B" : "W")) {
                    cnt++;
                }
                isWhite = !isWhite;
            }
            isWhite = !isWhite;
        }
        return cnt;
    }
}
