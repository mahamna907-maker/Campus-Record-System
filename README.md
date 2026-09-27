# Campus-Record-System

A Java console application that demonstrates core data structures through a university student record and campus route system.

## Features

- Student record management using a custom singly linked list
- Recent action history using a stack
- Service request processing using a queue
- Student ordering using a binary search tree
- Student lookup using a hash table with chaining
- Campus network management using a graph
- BFS and DFS graph traversal
- Input validation for menu choices and marks

## Project Structure

```
CampusRecordSystem/
├── bin/
├── lib/
├── src/
│   ├── app/
│   │   └── Main.java
│   ├── graph/
│   │   └── CampusGraph.java
│   ├── model/
│   │   └── Student.java
│   ├── records/
│   │   ├── LinkedListManager.java
│   │   ├── ActionStack.java
│   │   └── ServiceQueue.java
│   └── search/
│       ├── BSTManager.java
│       └── HashTableManager.java
└── README.md
```

## Compile

From the project root, compile the source files into bin.

Windows Command Prompt example:

```
javac -d bin src\model\Student.java src\records\LinkedListManager.java src\records\ActionStack.java src\records\ServiceQueue.java src\search\BSTManager.java src\search\HashTableManager.java src\graph\CampusGraph.java src\app\Main.java
```

## Run

```
java -cp bin app.Main
```

## Data Structures Used

1. Singly Linked List - student records
2. Stack - recent actions
3. Queue - service requests
4. Binary Search Tree - ordered student display
5. Hash Table - student ID search
6. Graph - campus locations and roads

## Team Contribution

- AUF. Minaal - 23DA2-0892: Student model and linked list
- T. Santhiya - 23DA2-1053: Stack and queue
- SF. Hamtha - 23DA2-0499: BST and hash table
- MA. Hamna - 23DA2-0508: Campus graph, Main integration, documentation, and final testing
