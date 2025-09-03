class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        int end = 0, size = 0;
        for(int i = 0; i < s.length(); i++) {
            size++;

            end = Math.max(end, lastIndex.get(s.charAt(i)));

            if(end == i) {
                res.add(size);
                size = 0;
            }
        }

        return res;
    }
}