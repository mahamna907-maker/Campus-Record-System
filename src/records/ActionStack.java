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

}
