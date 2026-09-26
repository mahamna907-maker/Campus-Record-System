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
}
