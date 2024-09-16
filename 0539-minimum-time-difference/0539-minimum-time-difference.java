class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] visited = new boolean[24 * 60];
        for (String time : timePoints) {
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));
            if (visited[h * 60 + m]) return 0;
            visited[h * 60 + m] = true;
        }
        
        int prev = 0, min = Integer.MAX_VALUE;
        int first = 0, last = 0;
        int idx = visited.length - 1;
        
        while(!visited[idx])
            idx--;  
        last = idx;
        
        idx = 0;
        while(!visited[idx])
            idx++;
        first = idx;
        
        prev = first;
        for(int i = first + 1; i <= last; i++){
            if(visited[i]){
                min = Math.min(min, i - prev);
                prev = i;
            }
        }
        
        min = Math.min(min, (24 * 60 - last + first));
        return min;
    }
}