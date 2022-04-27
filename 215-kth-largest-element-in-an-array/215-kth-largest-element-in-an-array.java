class Solution {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        
        int i = 0;
        while(k-- > 0){
             minheap.add(arr[i++]);
        }
        
        while(i < arr.length){
            
            if(arr[i] > minheap.peek()){
                minheap.poll();
                minheap.add(arr[i]);
            }
            i++;
            
        }
        
        return minheap.peek();
    }
}