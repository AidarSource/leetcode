class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int cur = 0, n = A.length, res[] = new int[n], seen[] = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            if (++seen[A[i]] == 2) cur++;
            if (++seen[B[i]] == 2) cur++;
            res[i] = cur;
        }
        return res;
    }
}