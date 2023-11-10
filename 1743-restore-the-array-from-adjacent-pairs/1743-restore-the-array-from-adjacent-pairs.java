class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        
        int[] restoredArray = new int[adjacentPairs.length+1];
     
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        
        for(int i= 0; i < adjacentPairs.length; i++){
             addToGraph(graph, adjacentPairs[i][0], adjacentPairs[i][1]);
             addToGraph(graph, adjacentPairs[i][1], adjacentPairs[i][0]);
         }
        
         int start = 0;
         for(int key : graph.keySet()){
             if(graph.get(key).size()==1){
                 start = key;
                 break;
            }
         }
        Set<Integer> seenSet = new HashSet<Integer>();
        List<Integer> answerList = new ArrayList<Integer>();
        dfs(start,graph,answerList,seenSet);

        for(int i=0;i<answerList.size();i++){
            restoredArray[i] = answerList.get(i);
        }
        return restoredArray;
    }
    
    private void dfs(int start,Map<Integer, List<Integer>> graph,List<Integer> answerList,Set<Integer> seenSet){
        answerList.add(start);
        seenSet.add(start);
        List<Integer> neighbors = graph.get(start);
        for(Integer curr : neighbors){
            if(!seenSet.contains(curr)){
                 dfs(curr,graph,answerList,seenSet);
            }
        } 
    }
	
	  private void addToGraph(Map<Integer, List<Integer>> graph, int key, int value) {
		     if(graph.containsKey(key)){
                 graph.get(key).add(value);
             }else{
                 List<Integer> temp = new ArrayList<Integer>();
                 temp.add(value);
                 graph.put(key, temp);
             }  
	  }
}