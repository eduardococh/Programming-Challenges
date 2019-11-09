class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len=gas.length;
        int diff[]=new int[len];
        int tgas=0,tcost=0;
        for(int i=0;i<len;i++){
            diff[i]=gas[i]-cost[i];
            tgas+=gas[i];
            tcost+=cost[i];
        }
        if(tcost>tgas) return -1;
        int longestStreak=0,startingIL=0;
        int currentStreak=0,startingIC=0;
        for(int i=0;i<len;i++){
            if(diff[i]>=0){
                if(currentStreak==0) startingIC=i;
                currentStreak+=diff[i];
            }else{
                if(currentStreak>0){
                    if(currentStreak>longestStreak){
                        longestStreak=currentStreak;
                        startingIL=startingIC;
                    }
                    currentStreak=0;
                    startingIC=0;
                }
            }
        }
        if(currentStreak>0){
            if(currentStreak>longestStreak){
                longestStreak=currentStreak;
                startingIL=startingIC;
            }
        }
        return startingIL;
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len=gas.length;
        int diff[]=new int[len];
        int tgas=0,tcost=0;
        int currentStreak=0;
        int startIndex=0;
        for(int i=0;i<len;i++){
            currentStreak=(currentStreak+gas[i]-cost[i]);
            //System.out.println(currentStreak);
            if(currentStreak<0){
                currentStreak=0;
                startIndex=i+1;
            } 
        }
        if(startIndex==len+1) return -1;
        return startIndex;
    }
}