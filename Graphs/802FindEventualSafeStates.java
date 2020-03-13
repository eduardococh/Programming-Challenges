class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        HashSet<Integer> visited=new HashSet<>();
        int dp[]=new int[graph.length];

        for(int i=0;i<graph.length;i++){
            if(checkSafe(i,graph,dp,visited)){
                result.add(i);
            }
        }
        return result;
    }
    
    private boolean checkSafe(int node,int[][] graph,int[] dp, HashSet<Integer> visited){
        if(dp[node]==1) return true;
        if(dp[node]==2) return false;

        if(visited.contains(node)) return false;

        int edges[]=graph[node];
        visited.add(node);

        for(int i=0;i<edges.length;i++){
            if(!checkSafe(edges[i],graph,dp,visited)){
                visited.remove(node);
                dp[node]=2;
                return false;
            }

        }
        dp[node]=1;
        visited.remove(node);
        return true;
        }

}