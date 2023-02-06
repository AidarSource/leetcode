class Solution {
    public int[] shuffle(int[] nums, int n) {
        int i = 0;
        int left = 0;
        int right = nums.length / 2;
        int[] res = new int[nums.length];
        
        while(right != nums.length) {
            res[i++] = nums[left++];
            res[i++] = nums[right++];
        }

        return res;
    }
}