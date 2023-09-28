class Solution {
    public String frequencySort(String s) {
          Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Sort the characters based on their frequencies in decreasing order
        List<Character> sortedChars = new ArrayList<>(charCount.keySet());
        Collections.sort(sortedChars,(a,b)->{
            return charCount.get(b)-charCount.get(a);
        });

        // Create the sorted string
        StringBuilder sortedStr = new StringBuilder();
        for (char c : sortedChars) {
            int count = charCount.get(c);
            for (int i = 0; i < count; i++) {
                sortedStr.append(c);
            }
        }

        return sortedStr.toString();
    }
    
}