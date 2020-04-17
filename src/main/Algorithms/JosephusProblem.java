package main.Algorithms;

import main.DataStructure.CircularLinkedList;

public class JosephusProblem {
    CircularLinkedList cli = new CircularLinkedList();
    int total = 0;

    public JosephusProblem(int size) {
        for(int i= 1; i<=size; i++) {
            cli.insert(i);
        }
        total = size;
    }

    public void start(int hops) {
        cli.setMarkerPosition(1);
        while(total > 1) {
            for (int i = 1; i<=hops; i++) {
                cli.move();
            }
            cli.delete();
            total--;
        }
        System.out.println(cli.toString());
    }


}
