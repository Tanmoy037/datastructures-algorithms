// solution can be ve optimized in O(1) space
import java.util.Stack;

class MinStack {
    Stack <Integer> st = new Stack<>();
    Stack <Integer> min = new Stack<>(); 

    public MinStack() {
        
    }
    
    public void push(int val) {
        if (st.size() == 0 && min.size() == 0){
            st.push(val);
            min.push(val);
            return;
        } 
        st.push(val);
        int temp = Math.min(val, min.peek());
        min.push(temp);
        
    }
    
    public void pop() {
        st.pop();
        min.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

