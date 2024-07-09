import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack <Integer> stk = new Stack<>();
        
        int i = 0;
        int j = 0;

        while (i < pushed.length && j < popped.length){
            if (stk.size()== 0){
                stk.push(pushed[i]);
                i++;
                continue;
            }
            if (popped[j] == stk.peek()){
                stk.pop();
                j++;
            } else {
                stk.push(pushed[i]);
                i++;
            }
        }

        while ( j < popped.length && popped[j] == stk.peek()){
            stk.pop();
            j++;
        }

        if (stk.size() == 0){
            return true;
        } else {
            return false;
        }
        
    }
}