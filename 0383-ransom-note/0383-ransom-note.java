class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;

        int[] count = new int[26];

        for(char c : ransomNote.toCharArray()) count[c - 'a']++;

        for(char c : magazine.toCharArray()) count[c - 'a']--;

        for(int c : count) {
            if(c > 0) return false;
        }

        return true;
    }
}