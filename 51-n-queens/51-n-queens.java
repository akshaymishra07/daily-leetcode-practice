class Solution {
   int[][] board;
    int n;
    List<List<String>> solutionBoards = new ArrayList();
    public List<List<String>> solveNQueens(int n) {
        this.board = new int[n][n];
        this.n = n;
        setQueens(0);
        return solutionBoards;
    }
    
	//This recursive method sets queen in a specific column
    void setQueens(int colIndex){
	    //if column number is equal to n, means you are able to place all the queens successfully
        if(colIndex==n){
            addToSolution();
            return;
        }
        
		//check all the rows and find out if it is valid position for the queen
        for(int row=0;row<n;row++){
            if(isPlaceValid(row, colIndex)){
                board[row][colIndex] = 1;
                
                setQueens(colIndex+1);
                
                //backtrack
                board[row][colIndex] = 0;
            }
        }
    }
    
    boolean isPlaceValid(int row, int col){
        //check if there is a queen in the current row
        for(int c=0;c<col;c++){
            if(board[row][c] == 1){
                return false;
            }
        }
        
        //check diagonal to the top
        for(int r=row-1, c=col-1;r>=0 && c>=0;r--,c--){
            if(board[r][c] == 1){
                return false;
            }
        }
        
        //check diagonal to the bottom
        for(int r=row+1, c=col-1;r<n && c>=0;r++,c--){
            if(board[r][c] == 1){
                return false;
            }
        }
        return true;
    }
    
	//Convert the array to List<String> and add to the final solution
    void addToSolution(){
        List<String> solBoard = new ArrayList();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            solBoard.add(sb.toString());
        }
        solutionBoards.add(solBoard);
    }
}