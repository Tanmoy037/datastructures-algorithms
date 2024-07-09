import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        Stack <Character> stack = new Stack <>();

        int j = 0;

        while (j < s.length()){

            char i = s.charAt(j);

            if (stack.size() == 0 || i == '(' || i == '{' || i == '['){
                
                stack.push(i);

            } else if ((i == ')' && stack.peek() == '(') || (i == '}' && stack.peek() == '{') || (i == ']' && stack.peek() == '[')){
                stack.pop();

            } else {
                return false;
            }
            j++;
        }
        if ( stack.size() == 0){
            return true;
        } else {
            return false;
        }
    }
}