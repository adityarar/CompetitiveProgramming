public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        int counter = 0, maxL = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap();
        
        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) == 1) { // New char
                counter++;
            }
            if (counter <= k) {
                maxL = Math.max(maxL, right - left + 1);
            }

            while(counter > k) { // Fix overflowing window
                char leftChar = s.charAt(left);
                left++;
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    counter--;
                }
            }
        }

        return maxL;
        
    }
}
