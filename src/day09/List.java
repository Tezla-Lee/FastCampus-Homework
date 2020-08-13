package day09;

/**
 * List 인터페이스를 구현하여 IntArrayList 클래스를 완성하시오.
 *
 * List 는 순서가 있는 연속된 값으로, List 인터페이스에 선언되어 있는 메소드의 기능은 아래와 같다.
 *
 * - append(): List 의 마지막에 value 를 삽입한다.
 * - prepend(): List 의 시작점에 value 를 삽입한다. 기존의 데이터를 한 칸씩 뒤로 옮긴다.
 * - insert(): index 에 value 를 삽입한다. 기존 데이터를 한 칸씩 뒤로 옮긴다.
 * - remove(): index 의 value 를 삭제한다. 기존 데이터를 한 칸씩 앞으로 당긴다.
 * - get(): index 의 value 를 반환한다.
 * - length(): List 의 길이를 출력한다.
 *
 * IntArrayList 는 int []를 이용하여 List 를 구현한다.
 * - 생성자에서는 capacity 를 입력받으며, 배열의 크기가 부족할 때마다 2배씩 증가시킨다.
 */

interface List {
    public void append(int value);
    public void prepend(int value);
    public void insert(int index, int value);
    public void remove(int index);
    public int get(int index);
    public void length();
}

