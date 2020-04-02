        //My recursive solution
        //Amazing runtime 1ms better than 100% O(M+N)
        //Good memory better than 97.56% O(N)
        //Logical solution, fast
class Solution {
    
    public boolean isBipartite(int[][] graph) {
        int len=graph.length;
        int colors[]=new int[len];
        for(int i=0;i<len;i++){
            //REMEMBER ARRAYS CAN HAVE DIFFERENT LENGHTS, DOESNT HAVE TO BE A SQUARE
            if(colors[i]==0){
                if(!colorGraph(graph,colors,i,1)) return false;
            }
        }
        return true;
    }
    
    public boolean colorGraph(int[][] graph,int[] colors,int current,int color){
        if(colors[current]==color) return false;
        if(colors[current]!=0) return true; 
        color=color==1?-1:1;
        colors[current]=color;
        for(int neighbor:graph[current]){
            if(!colorGraph(graph,colors,neighbor,color)) return false;
        }
        return true;
    }
    
}

        //Iterative solution by leetcode+some changes by me
        //Good runtime at 1ms better than 68.81% O(N+M) we visit every node and every edge once
        //Amazing memory better than 100% O(N) since we create space for every node
        //Not the most  
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for (int start = 0; start < n; start++) {
            if (color[start] == 0) {
                Stack<Integer> stack = new Stack();
                stack.push(start);
                color[start] = 1;

                while (!stack.empty()) {
                    Integer node = stack.pop();
                    for (int nei: graph[node]) {
                        if (color[nei] == 0) {
                            stack.push(nei);
                            color[nei] = color[node]==1?-1:1;
                        } else if (color[nei] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}