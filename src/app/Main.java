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
                // cases are added in the following commits
            }
        }
    }
}
