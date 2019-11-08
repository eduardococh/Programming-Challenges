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