class Solution {
    public int longestSubsequence(int[] arr, int difference) {
          Map<Integer, Integer> dp = new HashMap<>();
        int maxLength = 1;

        for (int num : arr) {
            if (dp.containsKey(num - difference)) {
                dp.put(num, dp.get(num - difference) + 1);
            } else {
                dp.put(num, 1);
            }
            maxLength = Math.max(maxLength, dp.get(num));
        }

        return maxLength;

    }
}