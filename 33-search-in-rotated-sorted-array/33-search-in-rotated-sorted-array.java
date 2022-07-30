class Solution {
    
    int bs(int low, int high, int key, int arr[]){
        
        while(low <= high){
            
            int mid = (high+low)/2;
            
            if(arr[mid] == key){
                return mid;
            }else if(arr[mid] > key){
                high = mid - 1;
            }else
                low = mid + 1;
        }
        
        return -1;
    }
    
    public int search(int[] nums, int key) {
      //step 1 : find the pivot
      //step 2 :  based on pivot, do the binary search in one part of the array   
      
     int low = 0; int high = nums.length-1; int mid=0;
     int pivot = -1;   
     while(low <= high){
         
         mid = (low+high)/2;
         
         if(nums[mid] <= nums[nums.length-1]){
             high = mid-1;
         }else{
             
             if(nums[mid] > nums[mid+1]){
                 pivot = mid;
             }
             low = mid+1;
         }
      }   

        
        
       int ans =  -1;
        
        if(key > nums[nums.length-1]){
           // System.out.println("in a");
            ans = bs(0,pivot,key,nums);
        }else{
            
            //System.out.println("in b");
            ans = bs(pivot+1,nums.length-1,key,nums);
        }
            
        
        
        return ans;
    }
}