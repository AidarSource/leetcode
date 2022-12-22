class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] res = new int[n];
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] count = new int[n];
        int[] sum = new int[n];
        
        dfs(graph, 0, -1, count, sum);
        dfs(graph, 0, -1, count, sum, res);
        return res;
    }
    private void dfs(List<List<Integer>> graph, int node, int parent, int[] count, int[] sum) {
        count[node] = 1;
        sum[node] = 0;
        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            dfs(graph, child, node, count, sum);
            count[node] += count[child];
            sum[node] += sum[child] + count[child];
        }
    }

    private void dfs(List<List<Integer>> graph, int node, int parent, int[] count, int[] sum, int[] res) {
        res[node] = sum[node];
        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            sum[child] = sum[node] + count[0] - 2 * count[child];
            count[child] = count[0] - count[child];
            dfs(graph, child, node, count, sum, res);
        }
    }
}