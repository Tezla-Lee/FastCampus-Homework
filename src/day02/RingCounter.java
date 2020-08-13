package day02;

import java.util.Scanner;

public class RingCounter {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("numBit 입력 : ");
        int numBits = scanner.nextInt();
        scanner.nextLine();
        System.out.print("numCount 입력 : ");
        int numCount = scanner.nextInt();
        int zeroNum = numBits - (numCount % numBits) - 1;

        System.out.print("현재 링카운터의 값 : 0b");
        for ( int i = 0; i < zeroNum; i++){
            System.out.print("0");
        }
        System.out.printf("%s\n", Integer.toBinaryString(1 << numCount % numBits));

//        System.out.printf("0b%s%s\n", ,Integer.toBinaryString(1 << numCount % numBits));

        System.out.println("현재 링카운터의 10진수 값 : " + (1 << numCount % numBits));

    }
}
