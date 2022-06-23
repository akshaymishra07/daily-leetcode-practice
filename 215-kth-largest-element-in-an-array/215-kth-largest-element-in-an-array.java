class Solution {
    public int findKthLargest(int[] nums, int k) {
      Queue<Integer> pq = new PriorityQueue<>(k);
      
      for(int num : nums){
          
          pq.add(num);
          
          if(pq.size() > k){
              pq.poll();
          }
                }  
        
        return pq.peek();
    }
}