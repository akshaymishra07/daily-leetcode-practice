class Solution {
    public void solve(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++){ 
          for(int j = 0; j < n; j++){
              
              if(i == 0 || i ==  m-1 || j == 0 || j == n-1){
                  
                  if(board[i][j] == 'O'){
                      q.add(new Pair(i,j));
                      visited[i][j] = true;
                  }    
              }
          }
        }
        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        while(!q.isEmpty()){
            
            Pair curr = q.poll();
            
            for(int i = 0; i < 4; i++){
                
                int newX = curr.x + dx[i];
                int newY = curr.y + dy[i];
                
                if(newX < 0 || newY < 0 || newX >= m || newY >= n || visited[newX][newY] == true || board[newX][newY] == 'X'){
                    continue;
                }
                
                q.add(new Pair(newX, newY));
                visited[newX][newY] = true;
            }   
        }
        
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && board[i][j] == 'O'){
                    
                     board[i][j] = 'X';
                }
            }
        }
    }
}

class Pair{
    
    int x;
    int y;
    
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}