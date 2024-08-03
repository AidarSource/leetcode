class Solution {
    public boolean canBeEqual(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            map.put(b[i], map.getOrDefault(b[i], 0) - 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) != 0) return false;
        }
        return true;
    }
}