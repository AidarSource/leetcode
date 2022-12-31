class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> resultList = new ArrayList<>();
        for (int num : nums2) {
            int count = frequencyMap.getOrDefault(num, 0);
            if (count > 0) {
                resultList.add(num);
                frequencyMap.put(num, count - 1);
            }
        }
        
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}