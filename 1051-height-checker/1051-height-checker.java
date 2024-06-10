class Solution {
    public int heightChecker(int[] heights) {
        final int[]  ordered = Arrays.copyOf(heights, heights.length);
        Arrays.sort(ordered);
        
		int outOfOrder = 0;
        for (int i = 0; i < ordered.length; i++) {
            if (ordered[i] != heights[i])
                outOfOrder++;
        }
        
        return outOfOrder;
    }
}