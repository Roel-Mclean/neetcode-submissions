class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                while (set.contains(s.charAt(i))) {
                    set.remove(s.charAt(left));
                    left++;
                }
            } 
            set.add(s.charAt(i));
            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}
