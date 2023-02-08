class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right) {
            if(nums[(right + left) / 2] == target) {
                return (right + left) / 2;
            } else if(nums[(right + left) / 2] > target) {
                right = ((right + left) / 2) - 1;
            } else {
                left = ((right + left) / 2) + 1;
            }
        }

        return -1;
    }
}