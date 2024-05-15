class Solution {
    class Query {
        int index;
        int queryTimestamp;
        int result;

        public Query(int index, int queryTimestamp) {
            this.index = index;
            this.queryTimestamp = queryTimestamp;
            this.result = -1; // initial value
        }

        @Override
        public String toString() {
            return "[" + index + "," + queryTimestamp + "," + result + "]";
        }

        public void setResult(int result) {
            this.result = result;
        }
    }

    class IntervalComparator implements Comparator<int[]> {
        public static int getSize(int[] interval) {
            return interval[1] - interval[0] + 1;
        }

        @Override
        public int compare(int[] o1, int[] o2) {
            int o1Size = getSize(o1), o2Size = getSize(o2);
            if (o1Size != o2Size) {
                return (o1Size - o2Size);
            }
            return (o1[1] - o2[1]);
        }
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        // lengths book keeping
        int numIntervals = intervals.length;
        int numQueries = queries.length;

        // Sort intervals by starting points
        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));
        
        Query[] sortedQueries = new Query[numQueries];
        for(int i = 0; i < numQueries; i++) {
            sortedQueries[i] = new Query(i, queries[i]);
        }
        Arrays.sort(sortedQueries, (q1, q2) -> (q1.queryTimestamp - q2.queryTimestamp));

        // algorithm
        Comparator<int[]> comparator = new IntervalComparator();
        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);
        int idx = 0;

        for(Query query : sortedQueries) {
            // 1) Keep taking intervals that starting point of it smaller than query. 
            // Which is basically collecting potential intervals for query
            while(idx < numIntervals && query.queryTimestamp >= intervals[idx][0]) {
                pq.add(intervals[idx]);
                idx++;
            }

            // 2) Keep removing inconsistent intervals
            while(!pq.isEmpty() && pq.peek()[1] < query.queryTimestamp) {
                pq.remove();
            }

            // Now priority queue must have consistent and smallest interval
            int ans = pq.isEmpty() ? -1 : IntervalComparator.getSize(pq.peek());
            query.setResult(ans);
        }

        // reconversion
        int[] results = new int[numQueries];
        for(Query query : sortedQueries) {
            results[query.index] = query.result;
        }

        return results;
    }
}