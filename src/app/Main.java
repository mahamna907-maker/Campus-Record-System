package app;

import graph.CampusGraph;
import model.Student;
import records.ActionStack;
import records.LinkedListManager;
import records.ServiceQueue;
import search.BSTManager;
import search.HashTableManager;

import java.util.Scanner;

public class Main {
    private static LinkedListManager listManager = new LinkedListManager();
    private static ActionStack actionStack = new ActionStack();
    private static ServiceQueue serviceQueue = new ServiceQueue();
    private static BSTManager bstManager = new BSTManager();
    private static HashTableManager hashManager = new HashTableManager();
    private static CampusGraph campusGraph = new CampusGraph();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        campusGraph.addLocation("MAIN GATE");
        campusGraph.addLocation("LIBRARY");
        campusGraph.addLocation("AUDITORIUM");
        campusGraph.addConnection("MAIN GATE", "LIBRARY");
        campusGraph.addConnection("LIBRARY", "AUDITORIUM");

        while (true) {
            System.out.println("\n==================================================");
            System.out.println(" UNIVERSITY STUDENT RECORD & CAMPUS ROUTE SYSTEM ");
            System.out.println("==================================================");
            System.out.println("1.  Add Student Record");
            System.out.println("2.  Update Student Record");
            System.out.println("3.  Delete Student Record");
            System.out.println("4.  Display All Records using Linked List");
            System.out.println("5.  Add Service Request to Queue");
            System.out.println("6.  Process Next Service Request");
            System.out.println("7.  Display Recent Actions using Stack");
            System.out.println("8.  Display Students using BST/AVL");
            System.out.println("9.  Search Student using Hashing");
            System.out.println("10. Add Campus Location");
            System.out.println("11. Remove Campus Location");
            System.out.println("12. Add Campus Connection/Road");
            System.out.println("13. Remove Campus Connection/Road");
            System.out.println("14. Display Campus Connections");
            System.out.println("15. Traverse Campus Locations using BFS or DFS");
            System.out.println("16. Exit");
            System.out.print("Enter choice (1-16): ");

            int choice = readInt(sc);

            switch (choice) {

                case 1:
    System.out.print("Enter Student ID: ");
    String id = sc.nextLine().trim();
    System.out.print("Enter Name: ");
    String name = sc.nextLine().trim();
    System.out.print("Enter Programme: ");
    String prog = sc.nextLine().trim();
    System.out.print("Enter Marks (0-100): ");
    double marks = readDouble(sc, 0, 100);

    Student newStudent = new Student(id, name, prog, marks);
    if (listManager.addStudent(newStudent)) {
        bstManager.insert(newStudent);
        hashManager.insert(newStudent);
        actionStack.push("Added Student Record: ID " + id);
        System.out.println("Student record added successfully.");
    } else {
        System.out.println("Error: Student ID already exists!");
    }
    break;

case 2:
    System.out.print("Enter Student ID to Update: ");
    String uid = sc.nextLine().trim();
    if (listManager.search(uid) == null) {
        System.out.println("Error: Student record not found.");
        break;
    }
    System.out.print("Enter New Name: ");
    String uName = sc.nextLine().trim();
    System.out.print("Enter New Programme: ");
    String uProg = sc.nextLine().trim();
    System.out.print("Enter New Marks (0-100): ");
    double uMarks = readDouble(sc, 0, 100);

    listManager.updateStudent(uid, uName, uProg, uMarks);
    actionStack.push("Updated Student Record: ID " + uid);
    System.out.println("Student updated successfully.");
    break;

case 3:
    System.out.print("Enter Student ID to Delete: ");
    String did = sc.nextLine().trim();
    if (listManager.deleteStudent(did)) {
        actionStack.push("Deleted Student Record: ID " + did);
        System.out.println("Student record deleted from Linked List.");
    } else {
        System.out.println("Error: Student ID not found.");
    }
    break;

case 4:
    listManager.displayAll();
    break;

    case 5:
    System.out.print("Enter Service Request Description: ");
    String req = sc.nextLine().trim();
    serviceQueue.enqueue(req);
    actionStack.push("Enqueued Request: " + req);
    System.out.println("Service request added to queue.");
    break;

case 6:
    String processed = serviceQueue.dequeue();
    if (processed != null) {
        actionStack.push("Processed Request: " + processed);
        System.out.println("Processed Request: " + processed);
    } else {
        System.out.println("Queue is empty. No requests to process.");
    }
    break;

case 7:
    actionStack.displayHistory();
    break;

case 8:
    bstManager.displayInOrder();
    break;

case 9:
    System.out.print("Enter Student ID to Search (HashTable): ");
    String hid = sc.nextLine().trim();
    Student found = hashManager.search(hid);
    if (found != null) {
        System.out.println("Found Record: " + found);
    } else {
        System.out.println("Record not found in Hash Table.");
    }
    break;

            }
        }
    }
}
