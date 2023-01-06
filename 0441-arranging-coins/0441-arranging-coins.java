class Solution {
    public int arrangeCoins(int n) {
        int stares = 0;
        while(n - stares > 0) {
            stares++;
            n -= stares;
        }

        return stares;
    }
}