class Solution {
    
    public static int firstIndex(int arr[],int key){
        
        int low = 0;
        int high = arr.length-1;
        int mid ;
        int ans = -1;
        
        while(low <= high){
            mid = (low + high) / 2;
            
            if(arr[mid] == key){
            	
                ans = mid;
                high = mid - 1;
            
            }else if(arr[mid] > key){
                    high = mid - 1;
            }else
                low = mid + 1;
            
        }
        return ans;
    }
    
    public static int lastIndex(int arr[],int key){
        int low = 0;
        int high = arr.length-1;
        int mid;
        int ans = -1;
        
        while(low <= high){
            mid = (low + high) / 2;
            
            if(arr[mid] == key){
            		
                ans = mid;
                low = mid + 1;
            
            }else if(arr[mid] > key){
                    high = mid - 1;
            }else
                low = mid + 1;
            
        }
        return ans;
        
        
    }
    
    public int[] searchRange(int[] nums, int target) {
        
        int res[] = new int[2];
        
        res[0] = firstIndex(nums,target);
        res[1] = lastIndex(nums,target);  
        
        
        return res;
    }
}