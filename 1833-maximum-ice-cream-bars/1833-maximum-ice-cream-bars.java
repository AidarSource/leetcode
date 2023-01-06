class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int max = 0;

        for(int i = 0; i < costs.length; i++) {
            if(coins >= costs[i]) {
                max++;
                coins -= costs[i];
            } else if(coins < costs[i]) {
                break;
            }
        }
        
        return max;
    }
}