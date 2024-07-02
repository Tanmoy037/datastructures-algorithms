// https://www.geeksforgeeks.org/problems/non-repeating-element3958/1

import java.util.HashMap;

class Check{
    
    public int firstNonRepeating(int arr[], int n) 
    { 
        // Complete the function
        HashMap <Integer,Integer>hm=new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])==false){
                hm.put(arr[i],1);
            }
            else{
                int temp=hm.get(arr[i]);
                hm.put(arr[i],temp+1);
            }
        }
        
        for(int i=0;i<arr.length;i++){
            int a=arr[i];
            if(hm.get(a)==1){
                return a;
            }
        }
        return 0;
    }  
    
}