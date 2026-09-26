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
        if (student.getId().compareToIgnoreCase(root.data.getId()) < 0) {
            root.left = insertRec(root.left, student);
        } else if (student.getId().compareToIgnoreCase(root.data.getId()) > 0) {
            root.right = insertRec(root.right, student);
        }
        return root;
    }

    public void displayInOrder() {
        if (root == null) {
            System.out.println("BST is empty.");
            return;
        }
        System.out.println("\n--- Student Records In-Order (BST) ---");
        inOrderRec(root);
    }

    private void inOrderRec(BSTNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.data);
            inOrderRec(root.right);
        }
    }
}
