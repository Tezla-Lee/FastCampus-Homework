package day09;
/**
 * List<T> 제네릭 인터페이스를 구현하여 ArrayList<T> 제네릭을 완성하시오.
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
 * ArrayList<T>는 Object []를 이용하여 List<T>를 구현한다.
 * - 생성자에서는 capacity 를 입력받으며, 배열의 크기가 부족할 때마다 2배씩 증가시킨다.
 */
class IntArrayList implements List {
    int [] array;
    int capacity;
    int listLength = 0;


    public IntArrayList(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    @Override
    public void append(int value) {
        if (listLength + 1 == array.length) {
            int [] new_array = new int[capacity * 2];
            System.arraycopy(array,  0, new_array, 0, array.length);
            array = new_array;
            capacity *= 2;
        }
        array[listLength] = value;
        listLength++;
    }

    @Override
    public void prepend(int value) {
        if (listLength == array.length) {
            int [] new_array = new int[capacity * 2];
            System.arraycopy(array, 0, new_array, 0, array.length);
            array = new_array;
            capacity *= 2;
        }
        int [] new_array = new int[array.length];
        new_array[0] = value;
        System.arraycopy(array, 0, new_array, 1, array.length - 1);
        array = new_array;
        listLength++;
    }

    @Override
    public void insert(int index, int value) {
        if (listLength == array.length) {
            int [] new_array = new int[capacity * 2];
            System.arraycopy(array, 0, new_array, 0, array.length);
            array = new_array;
            capacity *= 2;
        }
        int [] new_array = new int[array.length];
        if (index ==0) {
        } else {
            System.arraycopy(array, 0, new_array, 0, index - 1);
        }
        new_array[index] = value;
        System.arraycopy(array, index, new_array, index + 1, array.length - index - 1);
        array = new_array;
        listLength++;
    }

    @Override
    public void remove(int index) {
        int [] new_array = new int[array.length];
        System.arraycopy(array,0,new_array,0,array.length);
        System.arraycopy(array, index + 1, new_array, index, array.length - index - 1);
        array = new_array;
        listLength--;
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public void length() {
        System.out.println("List 의 길이 : " + listLength);
    }
}

class IntArrayListTest {
    public static void main(String[] args) {
        IntArrayList list = new IntArrayList(10);
        for (int i = 0; i < 15; i ++) {
            list.append(i);
        }
        for (int i = 0; i < 5; i ++) {
            list.prepend(0);
        }
        for (int i = 0; i < 10; i ++) {
            list.remove(0);
        }
        for (int i = 0; i < 10; i ++) {
            list.insert(0,i);
        }

        for (int i = 0; i < list.listLength; i++) {
            System.out.printf("%d ", list.array[i]);
        }

        System.out.println();
        list.length();
        System.out.println("capacity : " + list.capacity);
        System.out.println(list.get(3));
    }
}