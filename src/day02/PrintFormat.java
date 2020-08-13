package day02;

import java.util.Scanner;

public class PrintFormat {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("환자의 ID를 입력하세요.");
        int id = scanner.nextInt();
        scanner.nextLine(); // Enter도 문자열로 취급(?)되므로 추가해줌.
        System.out.println("환자의 병명을 입력하세요.");
        String s1 = scanner.nextLine();
        System.out.println("비고 사항을 입력하세요.");
        String s2 = scanner.nextLine();

        System.out.println("*----------*--------*---------------*");
        // | ID004029 | 코로나19 | 자가 격리 조치   |
        System.out.printf("| ID%06d | %-5s | %-10s |\n", id, s1, s2);
        System.out.println("*----------*--------*---------------*");



    }
}
