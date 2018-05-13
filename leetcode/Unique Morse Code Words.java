class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        Set<String> set = new TreeSet<>(new Comparator<String>(){
            public int compare(String a, String b){
                return a.compareTo(b);
            }
        });
        int count = 0;
        for(String word : words){
            String morse = wordToMorse(word);
            if(set.add(morse))
                count++;
        }
        return count;
    }
    
    private String wordToMorse(String word){
        String str = "";
        for(int i=0; i<word.length(); i++){
            str += getMorse(word.charAt(i));
        }
        return str;
    }
    
    private String getMorse(char c){
        String[] mapper = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        return mapper[c - 'a'];
    }
}