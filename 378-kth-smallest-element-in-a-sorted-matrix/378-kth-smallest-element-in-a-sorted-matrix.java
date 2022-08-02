class Solution {
    static int func(int x, int matrix[][]){
        int n = matrix.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            
            int low = 0;
            int high = n-1;
            int mid;
            
            while(low <= high){
                mid = (low + high)/2;
                
                if(matrix[i][mid] <= x){
                    if(mid == n-1){
                        count += n;
                        break;
                    }
                    low = mid + 1;
                }else{
                    
                     if (mid == 0){break;}
                    
                    if(matrix[i][mid-1] > x){
                        
                       
                        high = mid - 1;
                    }else{
                       
                        count += mid;
                        break;
                    }
                    
                }
            }
            
        }
        
        return count;
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n-1][n-1];
        
        int low = min;
        int high = max;
        int mid;
        
        while(low <= high){
            mid = (low + high)/2;
            
            int cnt = func(mid,matrix);
            
            
            
            if( cnt < k){
                low = mid + 1;
            }else{
                
                if(func(mid-1, matrix) < k){
                    return mid;
                }else
                    high = mid - 1; 
                
            }
            
        }
        
        return 1;
    }
}