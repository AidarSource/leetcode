class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // create an adjacency list representation of the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // initialize a set to track visited vertices
        Set<Integer> visited = new HashSet<>();

        // perform DFS
        return dfs(adjList, source, destination, visited);
    }

    static boolean dfs(List<List<Integer>> adjList, int vertex, int destination, Set<Integer> visited) {
        if (vertex == destination) {
            return true;
        }
        visited.add(vertex);
        for (int neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor) &&
                 dfs(adjList, neighbor, destination, visited)) {
                return true;
            }
        }
        return false;
    }
}