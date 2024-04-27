class Solution {
    public String reverseWords(String s) {
        StringBuilder newWord = new StringBuilder();
        StringBuilder reverseWord = new StringBuilder();
        boolean inWord = false;

        for ( char c : s.toCharArray()){
            if (c != ' '){
                newWord.append(c);
                inWord = true;
            } else {
                if (inWord){
                    reverseWord.insert(0, newWord.toString() + " ");
                    newWord.setLength(0);
                }
                inWord = false;
            }
        }
        if (inWord){
            reverseWord.insert(0, newWord.toString() + " ");
        }
        return reverseWord.toString().trim();
    }
}