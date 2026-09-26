package search;

import model.Student;

public class HashTableManager {
    private class HashNode {
        Student student;
        HashNode next;

        HashNode(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    private final int CAPACITY = 10;
    private HashNode[] table;

    public HashTableManager() {
        table = new HashNode[CAPACITY];
    }
}
