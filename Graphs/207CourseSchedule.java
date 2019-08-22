        //This problem basically comes down to finding cycles in a graph
       
        //My solution
        //It works and is not that complex
        //The key to the code is the usage of bloquedCourses hashMap
        //If a course has prerequisites it will appear, otherwise it will not appear
        //So we now check through every course in bloquedCourses and start solving their
        //Required courses until all courses are removed, meaning they can be done or until 
        //we reach a cycle, detected by the traversedCourses list
        //Bad runtime of 71ms better than only 11.99% O(N) where N is the number of prerequisites
        //first process al N prerequisites and then in classSolver we eliminate requirements one by one
        //so we visit them only once, if we visit one twice we break
        //Bad memory of 53.1mb better than 27.69% O(N) where N is the number of prerequisites
        //Since we store at most N prerequisites in the hashMap sets
        //I could be wrong in these complexities ?¿

        //Another implementation with maps checks for cycles while building the map, thus avoiding
        //the bloqCoursesList and two iterations, clever way
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,HashSet<Integer>> bloquedCourses=new HashMap<>();
        ArrayList<Integer> bloqCoursesList=new ArrayList<>();
        for(int i=0;i<prerequisites.length;i++){
            if(bloquedCourses.containsKey(prerequisites[i][0])){
                HashSet<Integer> mySet=bloquedCourses.get(prerequisites[i][0]);
                mySet.add(prerequisites[i][1]);
                bloquedCourses.put(prerequisites[i][0],mySet);
            }else{
                bloquedCourses.put(prerequisites[i][0],new HashSet<>(Arrays.asList(prerequisites[i][1])));
                bloqCoursesList.add(prerequisites[i][0]);
            }
        }
        while(!bloqCoursesList.isEmpty()){
            int currentCourse=bloqCoursesList.get(0);
            if(!classSolver(currentCourse,new ArrayList<Integer>(),bloquedCourses,bloqCoursesList)) return false;
        }
        return true;
    }
    
    private boolean classSolver(int currentCourse,ArrayList<Integer> traversedCourses,HashMap<Integer,HashSet<Integer>> bloquedCourses,ArrayList<Integer> bloqCoursesList){
        //System.out.println("WE enter forerr "+currentCourse);
        if(traversedCourses.contains(currentCourse)) return false;
        traversedCourses.add(currentCourse);
        //System.out.println("WE enter for "+currentCourse);
        HashSet<Integer> prereq=bloquedCourses.get(currentCourse);
        //System.out.println("onbj "+prereq);
        for(Integer num:prereq){
            if(bloquedCourses.containsKey(num)){//If this num has a prerequisite
                //System.out.println("testing "+num);
                if(!classSolver(num,traversedCourses,bloquedCourses,bloqCoursesList)){
                    return false;
                }
                //traversedCourses.remove(Integer.valueOf(num));
            }//else no prerequisite for this num
        }
        bloquedCourses.remove(currentCourse);
        bloqCoursesList.remove(Integer.valueOf(currentCourse));
        return true;
    }
}


        //Very simple solution, no big data structure, only arrays
        //From leetcode's 1ms samples
        //We have array COUNT that is the most important in this program, is like my bloquedCourses
        //map, but way more simple and elegant, here we count the number of courses that this
        //course is prerequisite, so a course that is prerequisite to none will have 0, this is 
        //inverse logic to my map, where I count the number of prerequisites a course have,
        //so for every pair we visit we decrease the "to" index (the prerequisite)
        //Until all are 0, or we find a cycle
        //Amazing runtime of 1ms better than 100% O(N) where N is number of prerequisites
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        
        int[] count = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int key = prerequisites[i][1];
            count[key]++;
        }
        
        boolean[] visited = new boolean[prerequisites.length];
        
        boolean isChanged = true;
        while(isChanged){
            isChanged = false;
            for (int i = 0; i < prerequisites.length; i++) {
                if (!visited[i]){
                    int from = prerequisites[i][0];
                    int to = prerequisites[i][1];

                    if (count[from] == 0){
                        visited[i] = true;
                        isChanged = true;
                        count[to]--;
                    }
                }
            }
        }
        
        for (int i : count){
            if (i > 0) {
                return false;
            }
        }        
        return true;
    }
}


        //A solution using DFS from leetcode's 2ms samples
        //First creates a "graph" using an array list of array lists and then
        //for every course it does a BFS, if there's a cycle it returns false
        //Amazing runtime at 2ms 
        
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // Initialization
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // build an adjacency list of the Graph
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][1];
            int prerequisite = prerequisites[i][0];// we take some courses after taking the course

            graph.get(course).add(prerequisite);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, visited)) {
                return false;
            }
        }

        return true;
    }

    //Detect cycles
    public boolean dfs(int i, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        if (visited[i] == 1) return true;
        if (visited[i] == 2) return false;

        visited[i] = 1;
        for (int next : graph.get(i)) {
            if (dfs(next, graph, visited)) {
                return true;
            }
        }

        visited[i] = 2;
        
        return false;
    }
}