package day02;

import java.util.Scanner;

public class InputOutput {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("첫 번째 정수를 입력하세요.");
        int num1 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("두 번째 정수를 입력하세요.");
        int num2 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("세 번째 정수를 입력하세요.");
        int num3 = scanner.nextInt();
        scanner.nextLine();

        int bigNum = num1>num2?num1:num2;
        int mostBig = bigNum>num3?bigNum:num3;

        System.out.printf("가장 큰 정수는 %d 입니다.", mostBig);
    }
}
