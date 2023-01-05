class Solution {
    public String toHex(int num) {
        if(num == 0) return "0";

        StringBuilder hex = new StringBuilder();
        while(num != 0) {
            int digit = num & 0xF;
            char hexDigit;
            if(digit < 10) {
                hexDigit = (char) ('0' + digit);
            } else {
                hexDigit = (char) ('a' + digit - 10);
            }
            hex.append(hexDigit);
            num >>>= 4;
        }

        return hex.reverse().toString();
    }
}