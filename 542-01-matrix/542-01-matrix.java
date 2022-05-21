class Pair{
    
    int x ;
    int y ;
    
    Pair(int x, int y){
        
        this.x = x;
        this.y = y;
    }
    
}

class Solution {
    
    static boolean isValid(int x, int y, int m, int n){
         
         return x >= 0 && x < m && y >= 0 && y < n;         
    }
    
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        
        boolean[][] visited  = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        
        int[] xmoves = new int[]{1 , -1 , 0 , 0};
        int[] ymoves = new int[]{0 , 0 , 1 , -1};
        
        // adding all the zeroes to the queue  , to start simultaneous bfs
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
               if(mat[i][j] == 0){
                    q.add(new Pair(i,j));
                    visited[i][j] = true;
                }
            }
        }
        
        //t dist = 0;
         
        while(!q.isEmpty()){
            
            int nums = q.size();
          
            while(nums-- > 0){
                
                Pair curr = q.poll();
                
                for(int k = 0 ; k < xmoves.length; k++){
                    
                    int x = curr.x + xmoves[k];
                    int y = curr.y + ymoves[k];
                    
                    if(!isValid(x,y,m,n)){
                        continue;
                    }    
                    
                    if(!visited[x][y]){
                            
                        
                       visited[x][y] = true;
                       mat[x][y] = mat[curr.x][curr.y]+1;
                       q.add(new Pair(x,y));

                 }
                }
            }
            //dist++;
        }  
        
        return mat;
    }
}