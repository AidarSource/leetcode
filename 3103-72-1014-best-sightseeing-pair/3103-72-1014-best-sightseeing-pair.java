class Solution {
    public int maxScoreSightseeingPair(int[] A) {
		//Intitialize previously seen value of A[i] + i
        int prev_max = A[0]+0;
		//Initialize the value of first pair
        int res = A[0] + A[1] - 1;
        for(int j = 1; j < A.length; j++){
			//update res if a higher value of prev_max+A[j]-j is found
            res = Math.max(prev_max + A[j] - j, res);
			//Update prev_max
            prev_max = Math.max(A[j] + j, prev_max);
        }
        return res;
    }
}