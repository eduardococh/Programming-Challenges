class Solution {
    
    HashSet<Integer> visited=new HashSet<Integer>();
    
    class Edge{
        int target;
        int time;
        
        public Edge(int target,int time){
            this.target=target;
            this.time=time;
        }
    }
    
    public int networkDelayTime(int[][] times, int N, int K) {
        ArrayList<ArrayList<Edge>> graph=createGraph(times,N);
        int res=depthSearch(K-1,0,graph,new HashSet<Integer>());
        if(visited.size()!=N) return -1;
        return res;
    }
    
    public int depthSearch(int startNode,int startingLen,ArrayList<ArrayList<Edge>> graph,HashSet<Integer> trace){
        if(visited.contains(startNode)) return startingLen;
        if(trace.contains(startNode)) return startingLen;
        ArrayList<Edge> edges=graph.get(startNode);
        if(edges.size()==0){
            visited.add(startNode);
            return startingLen;
        }
        int biggestLen=startingLen+edges.get(0).time;
        trace.add(startNode);
        for(Edge edge:edges){
            int edgeMax=depthSearch(edge.target,startingLen+edge.time,graph,trace);
            if(edgeMax<biggestLen) biggestLen=edgeMax;
        }
        visited.add(startNode);
        trace.remove(startNode);
        return biggestLen;
    }
    
    public ArrayList<ArrayList<Edge>> createGraph(int[][] times, int N){
        ArrayList<ArrayList<Edge>> graph=new ArrayList<ArrayList<Edge>>();
        for(int i=0;i<N;i++){
            graph.add(new ArrayList<Edge>());
        }
        final int len=times.length;
        for(int i=0;i<len;i++){
            graph.get(times[i][0]-1).add(new Edge(times[i][1]-1,times[i][2]));
        }
        return graph;
    }
}



//Attempt using priority queue, might no be much better than simple dfs
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        //Set<Integer> visited=new HashSet<Integer>();
        ArrayList<ArrayList<Edge>> graph=new ArrayList<PriorityQueue<Edge>>();
        for(int [] vertice:times){
            if(graph.size()<(vertice[0]-2)){
                graph.get(vertice[0]-1).add(new Edge(vertice[1],vertice[2]));
            }else{
                graph.add(new PriorityQueue<Edge>(new MyComparator()));
            }
        }
        
        
    }
    
    static class Edge{
        int destination;
        int time;

        public Edge(int destination,int time){
            this.destination=destination;
            this.time=time;
        }
    }
    
    static class MyComparator implements Comparator<Edge> {
        public int compare(Edge a, Edge b) {
            return a.time-b.time;
        }
    }
    
}