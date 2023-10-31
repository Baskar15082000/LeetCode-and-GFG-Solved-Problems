class Solution {
    public int longestSubsequence(int[] arr, int difference) {
          Map<Integer, Integer> map = new HashMap<>();
          int maxLength = 1;

        for (int num : arr) {
            if (map.containsKey(num - difference)) {
                map.put(num, map.get(num - difference) + 1);
            } else {
                map.put(num, 1);
            }
            maxLength = Math.max(maxLength, map.get(num));
        }

        return maxLength;

    }
}