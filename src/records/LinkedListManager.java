package records;

import model.Student;

public class LinkedListManager {

    private class Node {

        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;

    public boolean addStudent(Student student) {

        if (search(student.getId()) != null) {
            return false;
        }

        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
        } else {

            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        return true;
    }

    public Student search(String id) {

        Node temp = head;

        while (temp != null) {

            if (temp.data.getId().equalsIgnoreCase(id)) {
                return temp.data;
            }

            temp = temp.next;
        }

        return null;
    }
}
