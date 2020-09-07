//My solution using a graph
//Problem seems complicated but is not since we can plant the gardens with any flower
//as long as we verify the rules, and it's guaranteed that it will be possible
//since no more than 3 paths converge on any garden (greedily plant)
//Average runtime 33ms faster than 44.51% O(N+P) 
//since we take P (paths) time to create the graph and N since we visit every
//garden once
//Average-bad memory better than 33% O(N) since every garden can have at most 3 neighbors, 
//a constant, the recursive stack will be N depth at most
//Biggest improvements to time and memory use arrays instead of a hashmap for graph creation
class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        HashMap<Integer,List<Integer>> graph=createGraph(N,paths);
        int res[]=new int[N];
        for(int i=1;i<=N;i++){
            generateFlowerArray(res,graph,i);               
        }
        return res;
    }
    
    public void generateFlowerArray(int[] res,HashMap<Integer,List<Integer>> graph,int garden){
        if(res[garden-1]>0) return;
        //get my neighbors flowers
        Set<Integer> neighborsFl=new HashSet<Integer>();
        List<Integer> neighbors=graph.get(garden);
        for(Integer neighbor:neighbors){
            if(res[neighbor-1]>0){
                neighborsFl.add(res[neighbor-1]);//add my neighbor flower number (they could be repeated)
            }
        }
        for(int i=1;i<=4;i++){
            if(!neighborsFl.contains(i)){
                res[garden-1]=i;
                break;
            }
        }
        for(Integer neighbor:neighbors){
            if(res[neighbor-1]==0){
                generateFlowerArray(res,graph,neighbor);
            }
        }
    }
    
    public HashMap<Integer,List<Integer>> createGraph(int N,int[][] paths){
        HashMap<Integer,List<Integer>> graph=new HashMap<>();
        for(int i=1;i<=N;i++){
            graph.put(i,new ArrayList<Integer>());
        }
        for(int[] path:paths){
            List<Integer> neighbors1=graph.get(path[0]);
            neighbors1.add(path[1]);
            graph.put(path[0],neighbors1);
            List<Integer> neighbors2=graph.get(path[1]);
            neighbors2.add(path[0]);
            graph.put(path[1],neighbors2);
        }
        return graph;
    }
}