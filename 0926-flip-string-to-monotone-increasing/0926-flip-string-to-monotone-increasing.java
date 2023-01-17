class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int ones = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
            left[i] = ones;
        }
        ones = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                ones++;
            }
            right[i] = ones;
        }
        int minFlips = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minFlips = Math.min(minFlips, left[i] + (n - i - 1 - right[i]));
        }

        return minFlips;
    }
}