class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<Character> substr = new ArrayList<>();
        int maxLen = 0;
        
        for(int right = 0; right < s.length(); right++) {
            if(substr.contains(s.charAt(right))) {
                int index = substr.indexOf(s.charAt(right));
                substr.remove(index);
                if(index > 0) {
                    substr.subList(0, index).clear();
                }
            }
            substr.add(s.charAt(right));
            maxLen = Math.max(maxLen, substr.size());
        }

        return maxLen;
    }
}