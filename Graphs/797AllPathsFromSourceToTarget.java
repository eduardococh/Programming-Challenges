//My solution using DFS
//Good runtime O(P) better than 94.86% where P is every possible path
//Good memory O(N) better than 65.82% where N is number of nodes, recursive stack lenght will be N at most, as the
//path list length will be N at most 
//Good simple solution overall, an acyclic graph can also be seen as a kind of tree, since every path will end at some
//point, avoid need to check for visited nodes
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths=new ArrayList<List<Integer>>();
        List<Integer> path=new ArrayList<Integer>();
        path.add(0);
        dfs(graph,paths,0,graph.length-1,path);
        return paths;
    }
    
    public void dfs(int[][] graph,List<List<Integer>> paths,int currentNode,int targetNode,List<Integer> path){
        if(currentNode==targetNode){
            List<Integer> copy = new ArrayList<Integer>(path);
            paths.add(copy);
        }
        int[] neighbors=graph[currentNode];
        for(int neighbor:neighbors){
            path.add(neighbor);
            dfs(graph,paths,neighbor,targetNode,path);
            path.remove(path.size()-1);
        }
        return;
    }
}