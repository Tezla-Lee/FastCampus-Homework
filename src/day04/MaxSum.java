package day04;

/**
 * 배열의 연속합 최대 구하기
 *
 * 정수 배열에서 연속된 값의 합의 최대값을 구하시오.
 *
 * ex1) {1, 45, -2, 5, -6} => 1 + 45 + (-2) + 5 = 49
 * ex2) {-4, 5, 12, -7, 52, -5, 7} => 5 + 12 + (-7) + 52 + (-5) + 7 = 64
 *
 *
 * 인자
 * integers: 정수 배열
 */
public class MaxSum {
    public static void main(String[] args) {
        int[] integers = {-4, 7, 14, 9, -5, 4, 16, -22, 31};
        int max = 0;
        int sum = 0;
        for (int i = 0; i < integers.length; i++) {
            for (int j = 0; j <= integers.length - i - 1; j++) {
                sum += integers[i + j];
            }
            max = max >= sum ? max : sum;
            sum = 0;
        }
        System.out.println(max);
    }
}