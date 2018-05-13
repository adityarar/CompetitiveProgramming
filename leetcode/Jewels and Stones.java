class Solution {
    public int numJewelsInStones(String J, String S) {
        int[] hash1 = new int[130];
        int count=0;
        
        for(int i=0; i<J.length(); i++){
            hash1[J.charAt(i)] = 1;
        }
        
        for(int i=0; i<S.length(); i++){
            if(hash1[S.charAt(i)] == 1)
                count++;
        }
        return count;
    }
}