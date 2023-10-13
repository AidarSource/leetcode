class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        comb(candidates, target, ans, list, 0);

        return ans;
    }

    public void comb(
        int[] candidates,
        int target,
        List<List<Integer>> ans,
        List<Integer> list,
        int index
    ) {
        if(target == 0) {
            ans.add(new ArrayList(list));
        } else if(target < 0) return; else {
            for(int i = index; i < candidates.length; i++) {
                if(i > index && candidates[i] == candidates[i - 1]) continue;
                list.add(candidates[i]);
                comb(candidates, target - candidates[i], ans, list, i + 1);
                list.remove(list.get(list.size() - 1));
            }
        }
    }
}