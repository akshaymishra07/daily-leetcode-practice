class Solution {
    
   static void sortByUnitsPerBox(int[][] arr){
        
        Arrays.sort(arr, new Comparator<int[]>(){
            
            @Override
            public int compare(int[] a1, int[] a2){
                
                if(a1[1] <= a2[1]){
                    return 1;
                }else
                    return -1;
                
            }
            
        } );
       
    }
    
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        sortByUnitsPerBox(boxTypes);
        int ans = 0;
        int count = 0;
    
        
        for(int i = 0; i < boxTypes.length; i++){
            
             if(count + boxTypes[i][0] <= truckSize){
                 count += boxTypes[i][0];
                 int inc = boxTypes[i][0] * boxTypes[i][1];
                 ans += inc;
             }else if(boxTypes[i][0] > truckSize - count){
                 
                 int temp = truckSize - count; 
                 count += temp;
                 int inc = temp * boxTypes[i][1]; 
                 ans += inc;
             }
            
        }
        
        return ans;
    }
}