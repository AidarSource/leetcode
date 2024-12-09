class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int[] ps = new int[nums.length];
        for(int i=1;i<nums.length;i++){
            ps[i] = ps[i-1];
            if(nums[i-1]%2 == nums[i]%2){
                ps[i]++;
            }
        }
        for(int i=0;i<queries.length;i++){
            int from = queries[i][0],to = queries[i][1];
            int cnt = ps[to] - ps[from];
            ans[i] = cnt>0 ? false : true;
        }
        return ans;
    }
}