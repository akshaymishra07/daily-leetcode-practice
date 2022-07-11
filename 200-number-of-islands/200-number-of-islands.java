class Solution {
    
    static boolean isValid(int x, int y, int m, int n){
        
        return x < m && y < n && x >= 0 && y >= 0;
    }
    
    static void bfs(Node node, char arr[][]){
     
        int[] xmoves = new int[]{0,0,1,-1};
        int[] ymoves = new int[]{1,-1,0,0};
        
        Queue<Node> q = new LinkedList<>();
         
        q.add(node);
        
        while(!q.isEmpty()){
            
            Node curr = q.poll();
    
            for(int i = 0; i < 4; i++){
                int nx = curr.x + xmoves[i];
                int ny = curr.y + ymoves[i];
                
                if(!isValid(nx,ny,arr.length, arr[0].length) || arr[nx][ny] == '0' || arr[nx][ny] == '2'  ){
                    continue;
                }
                
                
                arr[nx][ny] = '2';                
                q.add(new Node(nx,ny));
                
            } 
    
            
        }
        
    }
    
    public int numIslands(char[][] grid) {
        
        int ans = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                
                if(grid[i][j] == '1'){
                    
                    ans++;
                    grid[i][j] = '2';
                    bfs(new Node(i,j), grid);
                    
                }
                
                
            }
        }
        
        return ans;
    }
}

class Node{
    
    int x;
    int y;
    
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    
}