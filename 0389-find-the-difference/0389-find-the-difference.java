class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> sFreq = new HashMap<>();
        Map<Character, Integer> tFreq = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sFreq.put(c, sFreq.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        for(char c : tFreq.keySet()) {
            if(!sFreq.containsKey(c) || tFreq.get(c) > sFreq.get(c)) {
                return c;
            }
        }

        return ' ';
    }
}