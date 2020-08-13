package day09;

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