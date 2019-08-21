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