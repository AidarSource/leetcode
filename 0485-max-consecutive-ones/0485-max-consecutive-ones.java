class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int innerMax = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                innerMax++;
            } else {
                innerMax = 0;
            }
            result = innerMax > result ? innerMax : result;
        }

        return result;
    }
}