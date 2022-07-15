class Solution {
    
    
    static boolean isValid(int x, int y, int[][] grid){
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
    
    int bfs(Node node, int[][] grid){
        
        Queue<Node> q = new LinkedList<>();
        
        int xmoves[] = new int[]{0,0,1,-1};
        int ymoves[] = new int[]{1,-1,0,0};
        
        q.add(node);
        int count = 1;
        
        while(!q.isEmpty()){
            
            Node curr = q.poll();
            
            for(int i = 0; i < 4; i++){
                
                int nx = curr.x + xmoves[i];
                int ny = curr.y + ymoves[i];
                
                if(!isValid(nx, ny, grid) || grid[nx][ny] == 0 || grid[nx][ny] == 2){
                    continue;
                }
                
                count++;
                grid[nx][ny] = 2;
                q.add(new Node(nx,ny));
            }
            
            
        }
        System.out.println(count);
        return count;
        
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int ans = Integer.MIN_VALUE;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                
                if(grid[i][j] == 1){
                    grid[i][j] = 2;
                    int cnt = bfs(new Node(i,j), grid);
                    ans = Math.max(ans, cnt);
                }
                
                
            }
        }
        
        return ans == Integer.MIN_VALUE ? 0 : ans;
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