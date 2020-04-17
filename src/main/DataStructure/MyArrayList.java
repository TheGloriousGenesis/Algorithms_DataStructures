package main.DataStructure;

import java.util.Arrays;

public class MyArrayList {

    public String[] list;
    private int index = 0;


    public MyArrayList() {
        list = new String[10];
    }

    public MyArrayList(final int n) {
        list = new String[n];
    }

    public String get(final int index) {
        return list[index];
    }

    public void add(final String element) {
        if (index < list.length) {
            list[index] = element;
            index++;
        } else {
            list = Arrays.copyOf(list, size() *2);
            list[index]=element;
            index++;
        }
    }

    public int size() {
        return list.length;
    }

    public void remove(final String element) {
        int indexElement = find(element);
        if(find(element) >= 0) {
            for(int i =indexElement; i<list.length-1; i++){
                list[i] = list[i + 1];
            }
        }
        index--;
        list[index] = null;
    }

    public int find(final String element) {
        for(int i=0; i < size(); i++) {
            if (list[i].equalsIgnoreCase(element)) {
                return i;
            }
        }
        return -1;
    }
}
