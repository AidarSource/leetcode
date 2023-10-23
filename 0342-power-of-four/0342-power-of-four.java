class Solution {
    public boolean isPowerOfFour(int n) {
        double a = Math.log(n) / Math.log(4);
        return Math.abs(a - Math.rint(a)) <= 0.00000000000001;
    }
}