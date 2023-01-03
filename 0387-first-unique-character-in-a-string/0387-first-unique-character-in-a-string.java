class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        // Iterate through string to get actual character frequency
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Iterate through Map to find unique character
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(freq.get(c) == 1) {
                return i;
            }
        }

        return -1;
    }
}