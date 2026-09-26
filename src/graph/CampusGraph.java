package graph;

import java.util.*;

public class CampusGraph {
    private Map<String, List<String>> adjList = new HashMap<>();

    public boolean addLocation(String location) {
        String loc = location.trim().toUpperCase();
        if (adjList.containsKey(loc)) {
            return false;
        }
        adjList.put(loc, new ArrayList<>());
        return true;
    }

    public boolean removeLocation(String location) {
        String loc = location.trim().toUpperCase();
        if (!adjList.containsKey(loc)) {
            return false;
        }
        adjList.remove(loc);
        for (List<String> neighbors : adjList.values()) {
            neighbors.remove(loc);
        }
        return true;
    }

    public boolean addConnection(String loc1, String loc2) {
        String u = loc1.trim().toUpperCase();
        String v = loc2.trim().toUpperCase();
        if (!adjList.containsKey(u) || !adjList.containsKey(v)) {
            return false;
        }
        if (!adjList.get(u).contains(v)) {
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            return true;
        }
        return false;
    }

    public boolean removeConnection(String loc1, String loc2) {
        String u = loc1.trim().toUpperCase();
        String v = loc2.trim().toUpperCase();
        if (adjList.containsKey(u) && adjList.containsKey(v)) {
            boolean r1 = adjList.get(u).remove(v);
            boolean r2 = adjList.get(v).remove(u);
            return r1 || r2;
        }
        return false;
    }

    public void displayGraph() {
        if (adjList.isEmpty()) {
            System.out.println("Campus graph is empty.");
            return;
        }
        System.out.println("\n--- Campus Connections Network ---");
        for (String loc : adjList.keySet()) {
            System.out.println(loc + " -> " + adjList.get(loc));
        }
    }

    public void bfsTraversal(String startLocation) {
        String start = startLocation.trim().toUpperCase();
        if (!adjList.containsKey(start)) {
            System.out.println("Error: Location does not exist in graph.");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("\nBFS Traversal from " + start + ": ");
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            System.out.print(curr + " ");

            for (String neighbor : adjList.get(curr)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfsTraversal(String startLocation) {
        String start = startLocation.trim().toUpperCase();
        if (!adjList.containsKey(start)) {
            System.out.println("Error: Location does not exist in graph.");
            return;
        }

        Set<String> visited = new HashSet<>();
        System.out.print("\nDFS Traversal from " + start + ": ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(String loc, Set<String> visited) {
        visited.add(loc);
        System.out.print(loc + " ");
        for (String neighbor : adjList.get(loc)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }
}
