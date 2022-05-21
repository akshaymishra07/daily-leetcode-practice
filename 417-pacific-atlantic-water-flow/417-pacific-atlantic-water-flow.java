class Pair{

    int x = 0;
    int y = 0;

    Pair(int x, int y){

       this.x = x;
       this.y = y;  

    }

}
class Solution {
    
    static void bfs(Queue<Pair> q, boolean[][] visited, int row, int col, int[][] mat){

           int xMoves[] = new int[]{1, -1, 0, 0};
           int yMoves[] = new int[]{0, 0, -1, 1};

           while(!q.isEmpty()){
               
               Pair curr = q.poll();

               for(int i = 0; i < 4; i++){
                   
                   int newX = curr.x + xMoves[i];
                   int newY = curr.y + yMoves[i];

                   if (newX < 0 || newY < 0 || newX >= row || newY >= col || visited[newX][newY] == true)
                    continue;  
                    
                   if (mat[curr.x][curr.y] <= mat[newX][newY])
                   {
                      q.add(new Pair(newX, newY));
                      visited[newX][newY] = true;
                   } 

               }
            

           }

    }
    
    public List<List<Integer>> pacificAtlantic(int[][] mat) {
     
      List<List<Integer>> ans = new ArrayList<>();
        
      int row = mat.length;
      if(row == 0){
          return ans;
      } 
      int col = mat[0].length;

      boolean[][] blueVisited = new boolean[row][col];
      boolean[][] redVisited = new boolean[row][col]; 
       
      Queue<Pair> redQueue = new LinkedList<>();
      Queue<Pair> blueQueue = new LinkedList<>();

      for(int i =  0 ; i < row; i++){
         for(int j = 0; j < col; j++){

           if(i == 0 || j == 0){
               blueQueue.add(new Pair(i,j));
               blueVisited[i][j] = true;
           }

           if(i == row - 1 || j == col - 1){
               redQueue.add(new Pair(i, j));
               redVisited[i][j] = true;
           }

         }

      }

      bfs(blueQueue,blueVisited,row,col,mat);
      bfs(redQueue,redVisited,row,col,mat); 
    
    
      for (int i = 0; i < row; i++)
      {
        for (int j = 0; j < col; j++)
        {
            if (blueVisited[i][j] && redVisited[i][j])
            {    
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
            }
        }
      }

       return ans;
  }
}