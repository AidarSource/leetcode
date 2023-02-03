class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();
        int n = s.length();
        int i = 0;
        while(i < n) {
            for(int j = 0; j < numRows && i < n; j++) {
                sb[j].append(s.charAt(i++));
            }
            for(int j = numRows - 2; j >= 1 && i < n; j--) {
                sb[j].append(s.charAt(i++));
            }
        }
        for(int j = 1; j < sb.length; j++) {
            sb[0].append(sb[j]);
        }
        
        return sb[0].toString();
    }
}