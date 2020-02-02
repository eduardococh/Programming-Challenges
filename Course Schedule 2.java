class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        final int len=prerequisites.length;
        int res[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<len;i++){
            graph.get(i).add(prerequisites[i][1]);
        }
        HashSet<Integer> visited=new HashSet<>();
        Stack<Integer> order=new Stack<>();
        for(int i=0;i<numCourses;i++){
            processNode(i,graph,visited,order);
        }
        for(int i=0;i<numCourses;i++){
            res[i]=order.pop();
        }
        return res;
    }
    
    private void processNode(int i, ArrayList<ArrayList<Integer>> graph, Set<Integer> visited,Stack<Integer> order){
        if(visited.contains(i)) return;
        visited.add(i);
        for(Integer prereq:graph.get(i)){
            processNode(prereq,graph,visited,order);
        }
        order.push(i);
    }
}