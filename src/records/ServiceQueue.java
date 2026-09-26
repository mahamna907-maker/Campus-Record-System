package records;

public class ServiceQueue {
    private class Node {
        String request;
        Node next;

        Node(String request) {
            this.request = request;
            this.next = null;
        }
    }

    private Node front = null;
    private Node rear = null;

    public void enqueue(String request) {
        Node newNode = new Node(request);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }
}
