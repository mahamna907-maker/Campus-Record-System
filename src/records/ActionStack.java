package records;

public class ActionStack {
    private class Node {
        String action;
        Node next;

        Node(String action) {
            this.action = action;
        }
    }

    private Node top = null;

    public void push(String action) {
        Node newNode = new Node(action);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (top == null) return null;
        String action = top.action;
        top = top.next;
        return action;
    }

    public void displayHistory() {
        if (top == null) {
            System.out.println("No recent actions logged.");
            return;
        }
        System.out.println("\n--- Recent Action History (Stack) ---");
        Node temp = top;
        int count = 1;
        while (temp != null) {
            System.out.println(count + ". " + temp.action);
            temp = temp.next;
            count++;
        }
    }
}
