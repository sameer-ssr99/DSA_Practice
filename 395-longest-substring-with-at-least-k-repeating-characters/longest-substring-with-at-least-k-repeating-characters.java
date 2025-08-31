class Solution {
    public int longestSubstring(String s, int k) {
        // n holds the length of input string s
        int n = s.length();

        // counts is a hashmap that keeps track of how many times each letter appears in the string
        Map<Character, Integer> counts = new HashMap<>();
        
        // Let's count how many times each letter shows up
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // Let's check each letter count in counts
        for (char c : counts.keySet()) {
            // Oops! This letter doesn't meet our 'at least k times' rule
            if (counts.get(c) < k) {
                int maxLen = 0;
                
                // Time to split the string by the problem letter and see if parts of it work
                for (String sub : s.split(String.valueOf(c))) {
                    // Recursively, let's check the smaller pieces
                    maxLen = Math.max(maxLen, longestSubstring(sub, k));
                }
                
                // Okay, what was the longest valid piece after splitting?
                return maxLen;
            }
        }

        // Hooray! All letters show up at least k times, so the whole string is valid
        return n;
    }
}