class Solution {
    public int[] getOrder(int[][] tasks) {
        int length = tasks.length;
        int [] result = new int [length];
        int [][] enqueFlow = new int [length][3];
        
        for (int i=0; i<length; i++) {
            enqueFlow[i][0] = tasks[i][0];
            enqueFlow[i][1] = tasks[i][1];
            enqueFlow[i][2] = i;
        }
        
        Arrays.sort(enqueFlow, (a, b) -> a[0] - b[0]);
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        int index = 0;
        int time = 0;
        int i = 0;
        
        while (i < length) {
            while (i < length && enqueFlow[i][0] <= time) {
                pq.offer(enqueFlow[i]);
                i += 1;
            }
            if (pq.isEmpty()) {
                time = enqueFlow[i][0];
            }
            else if (!pq.isEmpty()) {
                int [] current = pq.poll();
                result[index++] = current[2];
                time += current[1];
            }
        }
        
        while (!pq.isEmpty()) {
            int [] current = pq.poll();
            result[index++] = current[2];
        }
        
        return result;
    }
}