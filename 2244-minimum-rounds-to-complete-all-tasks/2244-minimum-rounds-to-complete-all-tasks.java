class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int res = 0;
        int i=0;

        while(i<tasks.length) {
            int j=i+1;
            while(j<tasks.length && tasks[i] == tasks[j]) j++;
            if(j-i==1) return -1;
            res += (j-i)%3 == 0 ? (j-i)/3 : (j-i)/3 + 1;
            i = j;
        }
        
        return res;
    }
}