class Solution {
    int[] root;
    int[] cnt;
    int get(int x) {
        return x == root[x] ? x : (root[x] = get(root[x]));
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length, ans = n;
        cnt = new int[n];
        root = new int[n];
        
        for (int i = 0; i < n; i++) {
            root[i] = i;
            cnt[i] = 1;
        }
        List<int[]> edgesList = new ArrayList<>();

        for(int i = 0; i < edges.length; i++) edgesList.add(edges[i]);

        Collections.sort(edgesList, new Comparator<int[]>() {
            public int compare(int[] x, int[] y) {
                int a = Math.max(vals[x[0]], vals[x[1]]);
                int b = Math.max(vals[y[0]], vals[y[1]]);
                if(a < b) return -1;
                else if(a > b) return 1;
                else return 0;
            }
        });

        for (int[] e : edgesList) {
            int x = e[0], y = e[1];
            x = get(x);
            y = get(y);

            if (vals[x] == vals[y]) {
                ans += cnt[x] * cnt[y];
                root[x] = y;
                cnt[y] += cnt[x];
            } else if (vals[x] > vals[y]) {
                root[y] = x;
            } else {
                root[x] = y;
            }
        }

        return ans;
    }
}