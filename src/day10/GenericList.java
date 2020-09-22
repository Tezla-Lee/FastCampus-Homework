package day10;

/**
 * List<T> 제네릭 인터페이스를 구현하여 ArrayList<T> 제네릭을 완성하시오.
 * <p>
 * List 는 순서가 있는 연속된 값으로, List 인터페이스에 선언되어 있는 메소드의 기능은 아래와 같다.
 * <p>
 * - append(): List 의 마지막에 value 를 삽입한다.
 * - prepend(): List 의 시작점에 value 를 삽입한다. 기존의 데이터를 한 칸씩 뒤로 옮긴다.
 * - insert(): index 에 value 를 삽입한다. 기존 데이터를 한 칸씩 뒤로 옮긴다.
 * - remove(): index 의 value 를 삭제한다. 기존 데이터를 한 칸씩 앞으로 당긴다.
 * - get(): index 의 value 를 반환한다.
 * - length(): List 의 길이를 출력한다.
 * <p>
 * ArrayList<T>는 Object []를 이용하여 List<T>를 구현한다.
 * - 생성자에서는 capacity 를 입력받으며, 배열의 크기가 부족할 때마다 2배씩 증가시킨다.
 */

interface List<T> {
    void append(T value);

    void prepend(T value);

    void insert(int index, T value);

    void remove(int index);

    T get(int index);

    int length();
}

class ArrayList<T> implements List<T> {
    private int capacity;
    private int length = 0;
    private Object[] array;

    public <T extends Object> ArrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    private void expandCapacity(int offset) {
        Object[] new_array = new Object[capacity * 2];
        System.arraycopy(array, 0, new_array, offset, capacity);
        array = new_array;
        capacity *= 2;
    }


    @Override
    public void append(T value) {
        if (length + 1 == array.length) {
            expandCapacity(0);
        }
        array[length] = value;
        length++;
    }

    @Override
    public void prepend(T value) {
        if (length == array.length) {
            expandCapacity(1);
        } else {
            System.arraycopy(array, 0, array, 1, length);
        }
        array[0] = value;
        length++;
    }

    @Override
    public void insert(int index, T value) {
        if (length == array.length) {
            expandCapacity(0);
        }
        if (index >= 0 && index <= length) {
            System.arraycopy(array, index, array, index + 1, length - index);
        }
        array[index] = value;
        length++;
    }

    @Override
    public void remove(int index) {
        if (length == array.length) {
            expandCapacity(0);
        }
        if (index >= 0 && index <= length) {
            System.arraycopy(array, index + 1, array, index, length - index - 1);
            length--;
        }
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public int length() {
        return length;
    }

    public void printList(ArrayList<T> list) {
        for (int i = 0; i < list.length(); i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}


public class GenericList {
    public static void printList(ArrayList<Object> list) {
        for (int i = 0; i < list.length(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>(10);
        for (int i = 0; i < 20; i++) {
            list.append(i);
        }
        printList(list);

        list.remove(5);
        list.printList(list);

        list.prepend(1);
        list.prepend(2);
        list.prepend(3);
        printList(list);

        list.insert(5, "abc");
        list.prepend("abcd");
        list.prepend('a');
        printList(list);
        System.out.println(list.get(7));
        System.out.println();


        ArrayList<Object> listChar = new ArrayList<>(10);
        for (int i = 0; i < 20; i++) {
            char ch = (char) (i + 65);
            listChar.append(ch);
        }
        printList(listChar);
    }
}