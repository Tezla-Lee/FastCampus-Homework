package day12;

/**
 * 람다식을 이용하여 알고리즘 정답을 테스트하는 프로그램을 작성하시오.
 * 주어진 interface와 실행 메소드를 이용하여 알고리즘 정답을 테스트하는 프로그램을 작성하시오.
 * 이 테스트 방식을 이용하여 실제 알고리즘 문제를 하나 이상 풀이하시오.
 */

interface Solution<T, R> {
    R solve(T t);
}

class Algorithm<T, R> {
    boolean test(T input, R groundtruth, Solution<? super T, ? super R> solution) {
        return solution.solve(input).equals(groundtruth);
    }
}

public class LambdaExpressions {
    public static void main(String[] args) {
        /**
         * 문제 1. n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
          */
        // case 1 : 입력 5, 출력 15
        System.out.println(new Algorithm<>().test(5, 15, x -> {
            int sum = 0;
            for (int i = 1; i <= (int) x; i++) {
                sum += i;
            }
            return sum;
        }));

        // case 2 : 입력 3, 출력 6
        System.out.println(new Algorithm<>().test(3, 6, x -> {
            int sum = 0;
            for (int i = 1; i <= (int) x; i++) {
                sum += i;
            }
            return sum;
        }));

        /** 문제 2. 가운데 글자 가져오기
         *  - 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
         */
        // case 1 : 입력 "abcde", 출력 "c"
        System.out.println(new Algorithm<String, String>().test("abcde", "c", s -> {
            String answer = "";
            int len = s.length();
            if (len %2 == 0) {
                char [] arr = {s.charAt(len / 2 - 1), s.charAt(len / 2)};
                answer = String.valueOf(arr);
            } else {
                answer = Character.toString(s.charAt(len / 2));
            }
            return answer;
        }));

        // case 2 : 입력 "qwer", 출력 "we"
        System.out.println(new Algorithm<String, String>().test("qwer", "we", s -> {
            String answer = "";
            int len = s.length();
            if (len %2 == 0) {
                char [] arr = {s.charAt(len / 2 - 1), s.charAt(len / 2)};
                answer = String.valueOf(arr);
            } else {
                answer = Character.toString(s.charAt(len / 2));
            }
            return answer;
        }));
    }
}