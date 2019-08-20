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
        if(traversedCourses.contains(currentCourse)) return false;
        //System.out.println("WE enter for "+currentCourse);
        HashSet<Integer> prereq=bloquedCourses.get(currentCourse);
        //System.out.println("onbj "+prereq);
        for(Integer num:prereq){
            if(bloquedCourses.containsKey(num)){//If this num has a prerequisite
                traversedCourses.add(num);
                if(!classSolver(num,traversedCourses,bloquedCourses,bloqCoursesList)){
                    return false;
                }
                traversedCourses.remove(Integer.valueOf(num));
            }//else no prerequisite for this num
        }
        bloquedCourses.remove(currentCourse);
        bloqCoursesList.remove(Integer.valueOf(currentCourse));
        return true;
    }
}