public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for(String s: strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        int j = 0;
        List<String> res = new ArrayList<>();
        while(j < str.length()) {
            String word = "";
            int i=j;
            String numString = "";
            while(str.charAt(i) != '#') {
                numString += str.charAt(i);
                i++;
            }
            int num = Integer.parseInt(numString);
            i++; // Shift to next char after #
            while(num-- != 0) {
                word += str.charAt(i);
                i++;
            }
            res.add(word);
            j = i;
        }

        return res;
    }
}
