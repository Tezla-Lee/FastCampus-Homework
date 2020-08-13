package day03;

import java.util.Scanner;

/**
 * 369게임+
 *
 * 369게임에 참여했을 때, 내가 외쳐야 하는 숫자나 동작을 순서대로 출력하시오.
 *
 * 규칙
 * 1. 3, 6, 9, 5가 포함되지 않은 숫자는 숫자를 외친다. (2!)
 * 2. 숫자에 포함된 3, 6, 9의 개수 만큼 박수를 친다. (짝!)
 * 3. 숫자에 포함된 5의 개수 만큼 발을 구른다. (쿵!)
 * 4. 박수와 발구르기의 순서는 관계 없으나, 반드시 번갈아 수행한다.
 *
 * 예시
 * 2   -> 2!
 * 33  -> 짝!짝!
 * 553 -> 쿵!짝!쿵! (짝!쿵!쿵!x)
 * 47  -> 47!
 *
 * 인자
 * gameLength: 게임이 종료되는 데 걸리는 턴 수
 * numPeople: 게임에 참여하는 인원 수
 * myTurn: 내가 숫자를 외치는 순번
 */
public class ThreeSixNineAdvanced {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("게임이 종료되는 데 걸리는 턴 수를 입력하세요 : ");
        int gameLength = scanner.nextInt();
        System.out.print("게임에 참여하는 인원 수를 입력하세요 : ");
        int numPeople = scanner.nextInt();
        System.out.print("내가 숫자를 외치는 순번을 입력하세요 : ");
        int myTurn = scanner.nextInt();

        for (int i = 1; i <= gameLength; i++) {
            int num1 = i % 10;                // 1의 자리
            int num10 = (i % 100) / 10;       // 10의 자리
            int num100 = i / 100;             // 100의 자리
            int numClap = 0;                  // 짝! 수
            int numFoot = 0;                  // 쿵! 수

            if ((i - myTurn) % numPeople != 0) {
                continue;
            }
            if (num1 == 3 || num1 == 6 || num1 == 9) {
                numClap++;
            }
            if (num10 == 3 || num10 == 6 || num10 == 9) {
                numClap++;
            }
            if (num100 == 3 || num100 == 6 || num100 == 9) {
                numClap++;
            }
            if (num1 == 5) {
                numFoot++;
            }
            if (num10 == 5) {
                numFoot++;
            }
            if (num100 == 5) {
                numFoot++;
            }
            if (numClap == 0 && numFoot == 0) {
                System.out.print(i);
            } else {
                while (numClap > 0 || numFoot > 0){
                    if (numClap > numFoot) {
                        System.out.print("짝!");
                        numClap--;
                        if (numFoot > 0) {
                            System.out.print("쿵!");
                            numFoot--;
                        }
                    } else if (numFoot >= numClap) {
                        System.out.print("쿵!");
                        numFoot--;
                        if (numClap > 0) {
                            System.out.print("짝!");
                            numClap--;
                        }
                    }
                }
//                System.out.print(i);
            }
            System.out.println();
        }
    }
}

//if (numClap + numFoot < 3 || numClap == 3 || numFoot == 3) {
//                    for (int j =0; j < numClap; j++){
//                        System.out.print("짝!");
//                    }
//                    for (int j =0; j < numFoot; j++){
//                        System.out.print("쿵!");
//                    }
//                } else {
//                    if (numClap == 1) {
//                        System.out.print("쿵!짝!쿵");
//                    } else {
//                        System.out.print("짝!쿵!짝");
//                    }
//                }