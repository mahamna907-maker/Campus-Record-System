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

    public boolean updateStudent(
        String id,
        String newName,
        String newProg,
        double newMarks
) {

    Student s = search(id);

    if (s != null) {

        s.setName(newName);
        s.setProgramme(newProg);
        s.setMarks(newMarks);

        return true;
    }

    return false;
}

public boolean deleteStudent(String id) {

    if (head == null) {
        return false;
    }

    if (head.data.getId().equalsIgnoreCase(id)) {
        head = head.next;
        return true;
    }

    Node current = head;
    Node prev = null;

    while (
        current != null &&
        !current.data.getId().equalsIgnoreCase(id)
    ) {

        prev = current;
        current = current.next;
    }

    if (current != null) {
        prev.next = current.next;
        return true;
    }

    return false;
}



}
