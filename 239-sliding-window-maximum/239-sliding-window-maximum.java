class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
     
         int[] res = new int[arr.length-k+1];
         int p = 0;
         Deque<Integer> dq = new LinkedList<>();           
        
         for(int i = 0; i < arr.length; i++){
             
             while(dq.size() > 0 && dq.getLast() < arr[i]){
                 dq.pollLast();
             }
             dq.addLast(arr[i]);
             
             if(i >= k){
                 
                 if(dq.getFirst() == arr[i-k]){
                     dq.pollFirst();
                 }
                 
                 
             }
             
             if(i >= k-1){
                 
                 res[p++] = dq.getFirst();
                 
             }
             
             
         }
        
        return res;
    }
}