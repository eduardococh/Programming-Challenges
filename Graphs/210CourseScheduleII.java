        //My solution using List and set for visited
        //Good runtime at 4ms better than 85.39% O(N + P) 
        //where N is the number of nodes and P number of prerequisites
        //Good memory better than 96.34% (N + P)
        //Leetcode lists runtime and memory complexity as O(N)
        //https://www.youtube.com/watch?v=ddTC4Zovtbc&t
        //This video explains the code very well, but we have a fundamental difference
        //in the video and in most algoriths they create the graph with the inverse case
        //where a node edges are the nodes that depend on him
        //here a node edges are the nodes on which I depend
        //this means that when we explore the graph we will start from a node and go
        //up in dependencies until we found a node which is dependent on no other node
        //and this will be the first node, unlike the video example where he starts from 
        //a node and then searches for nodes dependent on him, util he founds a node from 
        //which no other node depends and adds it, this makes the example order inverse
        //and my solution order normal
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        final int len=prerequisites.length;
        int res[]=new int[0];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<len;i++){
            //to take course [i][0] you need to take course [i][1]
            //so every node will have their prerequisites
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
            //in most examples they build it like
            //course [i][1] unlocks course [i][0], so every node
            //will have
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