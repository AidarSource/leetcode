class Solution {
    public String reverseVowels(String s) {
        char[] res = s.toCharArray();

        int left = 0;
        int right = res.length - 1;

        while(left < right) {
            if(!isVowel(res[left])) {
                left++;
            } else if(!isVowel(res[right])) {
                right--;
            } else {
                char temp = res[left];
                res[left] = res[right];
                res[right] = temp;

                left++;
                right--;
            }
        }

        return new String(res);
    }

    private boolean isVowel(char a) {
        a = Character.toLowerCase(a);
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u';
    }
}