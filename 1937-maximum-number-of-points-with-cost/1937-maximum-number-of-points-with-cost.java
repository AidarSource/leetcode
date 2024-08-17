class Solution {
    public long maxPoints(int[][] p) {
        long[] cur_row = new long[p[0].length], prev_row = new long[p[0].length];
        for (var row : p) {
            long run_max = 0;
            for (int j = 0; j < row.length; ++j) {
                run_max = Math.max(run_max - 1, prev_row[j]);
                cur_row[j] = run_max;
            }
            for (int j = row.length - 1; j >= 0; --j) {
                run_max = Math.max(run_max - 1, prev_row[j]);
                cur_row[j] = Math.max(cur_row[j], run_max) + row[j];
            }
            prev_row = cur_row;
        }
        return Arrays.stream(prev_row).max().getAsLong();
    }
}