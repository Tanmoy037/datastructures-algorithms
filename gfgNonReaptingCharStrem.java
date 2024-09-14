// First non-repeating character in a stream

// https://www.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1


class Solution
{
     public String FirstNonRepeating(String A)
    {
        
        Queue<Character> q = new LinkedList<>();
        HashMap<Character, Integer>hm = new HashMap<>();
        char[] ans = new char[A.length()];
        
        for(int i=0;i<A.length();i++){
            char c = A.charAt(i);
            
            q.add(c);
            if(hm.containsKey(c) == true){
                int temp = hm.get(c);
                hm.put(c,temp+1);
            }else{
                hm.put(c,1);
            }
            
            while(q.size()>0 && hm.get(q.peek())> 1){
                q.remove();
            }
            
            if(q.size()>0){
                ans[i] = q.peek();
            }else{
                ans[i] = '#';
            }
        }
        
        return String.valueOf(ans);

    }

}