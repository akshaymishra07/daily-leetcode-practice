class Solution {
    
    static void swap(int arr[], int i, int j){
        
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
         
    }
    
    static void reverse(int arr[], int i, int j){
        
        while(i < j){
            
            swap(arr,i,j);
            i++;
            j--;
            
        }
        
        
    }
    
    public void nextPermutation(int[] arr) {
       
        int n = arr.length;
        
        int x = n-1;
        
        while(x > 0 && arr[x] <= arr[x-1]){
            x--;
        }
        
        if(x-1 >= 0){
            
            for(int y = n-1; y >= x; y--){
                
                if(arr[y] > arr[x-1]){
                    swap(arr,y,x-1);
                    break;
                }
            }
              
           reverse(arr,x,n-1);  
        }else{
            reverse(arr,0,n-1);
        }
        
    }
}