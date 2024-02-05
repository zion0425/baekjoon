import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 기존의 priorityQueue를 두 개 사용하면, 해당 자료 구조의 특성상 우선순위에 따른 재배치 과정이 필요하기 때문에 시간 초과 발생 O(N)
 * key로 정렬되는 TreeMap 사용, RedBlack Tree 자료구조 사용, O(logN) 발생
 * 해당 문제에서 중복된 숫자도 저장 허용, 중복된 숫자가 입력으로 들어올 시, value로 중복된 숫자의 개수를 카운팅
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        TreeMap<Integer, Integer> numbers = new TreeMap<>();
        int t = Integer.parseInt(br.readLine());
        int k;

        for (int i = 0; i < t; i++) {
            numbers.clear();
            k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int number = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    numbers.put(number, numbers.getOrDefault(number, 0) + 1);
                } else if (!numbers.isEmpty() && command.equals("D")) {
                    if (number == -1) {
                        if (numbers.firstEntry().getValue() > 1) {
                            numbers.put(numbers.firstKey(), numbers.firstEntry().getValue() - 1);
                        } else {
                            numbers.pollFirstEntry();
                        }
                    } else if (number == 1) {
                        if (numbers.lastEntry().getValue() > 1) {
                            numbers.put(numbers.lastKey(), numbers.lastEntry().getValue() - 1);
                        } else {
                            numbers.pollLastEntry();
                        }
                    }
                }
            }
            if (numbers.isEmpty())
                sb.append("EMPTY").append('\n');
            else
                sb.append(numbers.lastKey()).append(' ').append(numbers.firstKey()).append('\n');
        }
        System.out.print(sb);
    }
}

