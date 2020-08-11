package day1;

public class TIL {

    /**
     * 자료형 (Data Type)
     * 자료형 - 기본형 (Primitive Type), 참조형 (Reference Type)
     * 기본형 자료형 - 정수형, 실수형, 문자형, 논리형
     * 참조형 자료형 - 문자형 (Strnig)
     */

    public static void main(String[] args) {
        //정수형 : byte, short, int, long
        System.out.println("Byte"); // 1바이트 = 8비트
        System.out.println(Byte.BYTES);
        byte byteValue = 42;
        System.out.println(byteValue);
        System.out.println(Byte.MAX_VALUE); // 2^7 - 1
        System.out.println(Byte.MIN_VALUE); // -2^7
        //byte byteValu1 = 128;
        System.out.println("");

        System.out.println("Short");
        System.out.println(Short.BYTES);
        System.out.println(Short.MAX_VALUE); //2^15-1
        System.out.println(Short.MIN_VALUE); //-2^15
        System.out.println("");

        System.out.println("Int");
        System.out.println(Integer.BYTES); // 4
        System.out.println(Integer.MAX_VALUE); // 2^31-1
        System.out.println(Integer.MIN_VALUE); // -2^31
        System.out.println("");

        System.out.println("Long");
        System.out.println(Long.BYTES); // 8
        System.out.println(Long.MAX_VALUE); // 2^63 - 1
        System.out.println(Long.MIN_VALUE); // -2^63
        System.out.println("");

        // Overflow
        // 32767 = 2^15 - 1 => 0111111111111111 맨 앞에 0은 양수를 의미함.
        short shortValue = (short) 64000; // 억지로 short로 바꿈. short의 최대값은 2^15 -1 = 32767
        System.out.println(shortValue); // 따라서 이상한 값이 나옴.
        System.out.println("");

        // 정수형은 기본적으로 int
        // byte byteValue3 = 144;
        short shortA = 10;
        short shortB = 20;
        short shortC = (short) (shortA + shortB); // short 2개를 더 하면 int가 됨. 따라서 강제로 short 로 바꿔줌.

        int bigInt = Integer.MAX_VALUE; // int의 최대값.
        int biggerInt = bigInt + 1; // 최대값을 넘어감.
        System.out.println(biggerInt); // 이상한 값이 나옴. (빨간줄이 나오지도 않음)

        long veryBigInt = 10000000000000L; // long 뒤에는 L를 써줘야 됨.
        System.out.println(veryBigInt);

        // 진수법 - Binary(2), Octal(8), Decimal(10), Hexadecimal(16)
        System.out.println(0b1101); // 2진수 ob
        System.out.println(071); // 8진수 0
        System.out.println(1424); // 10진수
        System.out.println(0x01); // 16 진수 0x, 10 ~ 15 : a,b,c,d,e,f
        System.out.println(0xff);

        byte flagByte = 0b00101100;
    }
}
