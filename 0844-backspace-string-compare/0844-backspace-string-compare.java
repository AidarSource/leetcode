class Solution {
    public boolean backspaceCompare(String S, String T) {
        return sb(S).equals(sb(T));
    }
    
    private String sb(String str) {
        StringBuilder sbr = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            
            if (c != '#') {
                sbr.append(c);
            } else if (sbr.length() != 0) {
                sbr.deleteCharAt(sbr.length() - 1);
            }
        }
        return sbr.toString();
    }
}