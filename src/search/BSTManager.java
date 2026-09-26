package search;

import model.Student;

public class BSTManager {
    private class BSTNode {
        Student data;
        BSTNode left, right;

        BSTNode(Student data) {
            this.data = data;
            left = right = null;
        }
    }

    private BSTNode root = null;

    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private BSTNode insertRec(BSTNode root, Student student) {
        if (root == null) {
            return new BSTNode(student);
        }
        return root;
    }
}
