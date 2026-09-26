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

    private int hashFunction(String id) {
    int hash = 0;

    for (char c : id.toCharArray()) {
        hash += c;
    }

    return Math.abs(hash) % CAPACITY;
}
private int hashFunction(String id) {
    int hash = 0;

    for (char c : id.toCharArray()) {
        hash += c;
    }

    return Math.abs(hash) % CAPACITY;
}
public void insert(Student student) {
    int index = hashFunction(student.getId());
    HashNode newNode = new HashNode(student);

    if (table[index] == null) {
        table[index] = newNode;
    } else {
        HashNode temp = table[index];

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }
}
public Student search(String id) {
    int index = hashFunction(id);
    HashNode temp = table[index];

    while (temp != null) {
        if (temp.student.getId().equalsIgnoreCase(id)) {
            return temp.student;
        }

        temp = temp.next;
    }

    return null;
}

}
