class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList();
        int len = times.length;
        if(len<n-1) return -1;
        int ans = -1;
        int[] v = new int[n+1];
        Arrays.fill(v,600010);
        v[0] = 0;
        v[k] = 0;
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList());
        }
        for(int[] edge:times){
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }
        Queue<int[]> que = new ArrayDeque();
        que.offer(new int[]{k,0});
        n--;
        while(!que.isEmpty()){
            int[] temp = que.poll();
            for(int[] adj:graph.get(temp[0])){
                int d = adj[1]+temp[1];
                n -= v[adj[0]] == 600010?1:0; 
				/* Every time we get to a new node we let n substract 1*/
                if(d<v[adj[0]]){
                    que.offer(new int[]{adj[0],d});
                    v[adj[0]] = d;
                }
            }
        }
        if(n != 0) return -1;
		/*If we haven't reached all n nodes, we just return -1 instead of checking whether the ans is the infinite distance after the comparison with all the disances stored in the array v*/
        for(int dis:v){
            ans = Math.max(ans,dis);
        }
        return ans;
    }
}