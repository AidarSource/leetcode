class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int difference = arr[1]-arr[0];
        for(int itr = 2; itr < arr.length; itr++){
            if(arr[itr]-arr[itr-1] != difference) return false;
        }
        return true;
    }
}