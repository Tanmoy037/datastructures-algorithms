// Reverse First K elements of Queue
// https://www.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1


class GfG {
    // Function to reverse the first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // Step 1: Create a stack to hold the first k elements.
        Stack<Integer> stack = new Stack<>();
        
        // Step 2: Dequeue the first k elements from the queue and push them onto the stack.
        for (int i = 0; i < k; i++) {
            stack.push(q.remove());
        }
        
        // Step 3: Pop the elements from the stack and enqueue them back into the queue.
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
        
        // Step 4: Move the remaining elements in the queue to the back of the queue.
        int remainingElements = q.size() - k;
        for (int i = 0; i < remainingElements; i++) {
            q.add(q.remove());
        }
        
        // Return the modified queue.
        return q;
    }
}