// { Driver Code Starts


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends


class Pair{
    int key;
    int value;
    
    Pair(int key, int value){
        this.key = key;
        this.value  = value;
    }
}

class Solution
{
    static void createMoves(List<int[]> moves){
        
        moves.add(new int[]{2,1});
        moves.add(new int[]{2,-1});
        moves.add(new int[]{-2,1});
        moves.add(new int[]{-2,-1});
        moves.add(new int[]{1,2});
        moves.add(new int[]{-1,2});
        moves.add(new int[]{1,-2});
        moves.add(new int[]{-1,-2});
        
    }
    
    static boolean isValid(int x, int y, int N){
             
        return x > 0 && x <= N && y > 0 && y <= N;
             
    }
    
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[N+1][N+1];
        
        List<int[]> moves = new ArrayList<>();
        createMoves(moves);
        
        q.add(new Pair(KnightPos[0], KnightPos[1]));
        visited[KnightPos[0]][KnightPos[1]] = true;
        int level = 0;
        
        while(!q.isEmpty()){
            
            int nums = q.size();
            
            while(nums-- > 0){
                
                Pair curr = q.poll();
                //System.out.println("at"+curr.key+":"+curr.value);
                if(curr.key == TargetPos[0] && curr.value == TargetPos[1]){
                    return level;
                }
                
                for(int move[] : moves){
                   int x = curr.key + move[0];
                   int y = curr.value + move[1]; 
                   
                   if(!isValid(x,y,N))continue;
                   
                   if(! visited[x][y]){
                       q.add(new Pair(x,y));
                       visited [x][y] = true;
                   }
                }
                
            }
            
            level++;
        }
     
       return -1;   
    }
}









































































