class Solution {
    int[] root = new int[26];

    int get(int x) {
        return x == root[x] ? x : (root[x] = get(root[x]));
    }

    void unite(int x, int y) {
        x = get(x);
        y = get(y);

        if (x != y) {
            if (x < y)  root[y] = x;
            else root[x] = y;
        }

        return;
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        String ans = "";
        
        for (int i = 0; i < 26; i++)  root[i] = i;
        for (int i = 0; i < s1.length(); i++) unite(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        for (int i = 0; i < baseStr.length(); i++) {
            ans += (char)(get(baseStr.charAt(i) - 'a') + 'a');
        }

        return ans;
    }
}