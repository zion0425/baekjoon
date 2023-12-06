import java.util.Arrays;
import java.util.Scanner;

class Member implements Comparable<Member> {
    int age;
    String name;
    int order; // 입력 순서를 저장하는 변수

    public Member(int age, String name, int order) {
        this.age = age;
        this.name = name;
        this.order = order;
    }

    @Override
    public int compareTo(Member other) {
        if (this.age == other.age) {
            return Integer.compare(this.order, other.order);
        }
        return Integer.compare(this.age, other.age);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 회원 수 입력
        int n = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 제거

        // 회원 정보를 저장할 배열 생성
        Member[] members = new Member[n];

        // 회원 정보 입력 및 배열에 추가
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            members[i] = new Member(age, name, i);
        }

        // 정렬
        Arrays.sort(members);

        // 정렬된 회원 정보 출력
        for (Member member : members) {
            System.out.println(member.age + " " + member.name);
        }
    }
}