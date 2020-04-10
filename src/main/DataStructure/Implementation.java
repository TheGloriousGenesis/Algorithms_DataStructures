package main.DataStructure;

public class Implementation {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(4);
        list.add("Hi");
        list.add("My Name is");
        list.add("Ana");
        list.add("Maybe");
        list.add("I will talk");

        for(int i=0; i<list.size();i++) {
            System.out.printf("%s ", list.get(i));
        }
        System.out.println();

        list.remove("Ana");

        for(int i=0; i<list.size();i++) {
            System.out.printf("%s ", list.get(i));
        }

    }
}
