        //My solution using List and set for visited
        //Good runtime at 4ms better than 85.39% O(N + P) 
        //where N is the number of nodes and P number of prerequisites
        //Good memory better than 96.34% (N + P)
        //Leetcode lists runtime and memory complexity as O(N)
        //
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        final int len=prerequisites.length;
        int res[]=new int[0];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<len;i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        HashSet<Integer> visited=new HashSet<>();
        ArrayList<Integer> order=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            if(!processNode(i,graph,visited,order,new HashSet<Integer>())) return res;
        }
        res=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            res[i]=order.get(i);
        }
        return res;
    }
    
    private boolean processNode(int i, ArrayList<ArrayList<Integer>> graph, Set<Integer> visited,ArrayList<Integer> order,Set<Integer> cycle){
        if(cycle.contains(i)) return false;
        if(visited.contains(i)) return true;
        visited.add(i);
        cycle.add(i);
        for(Integer prereq:graph.get(i)){
            if(!processNode(prereq,graph,visited,order,cycle)) return false;
        }
        order.add(i);
        cycle.remove(i);
        return true;
    }
}