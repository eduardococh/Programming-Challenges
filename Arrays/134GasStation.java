        //My solution
        //Amazing runtime 0ms better than 100% O(N)
        //Good runtime better than 74.51% O(1)
        //It does one loop searching for a viable path
        //if it finds a canditate, it goes to the second loop and confirms
        //that it can be done, otherwise return 1
        //Since the program guarantees that there's only one solution this 
        //simple approach works (unlike finding the maximum for example)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len=gas.length;
        int currentStreak=0;
        int startIndex=0;
        for(int i=0;i<len;i++){
            currentStreak=(currentStreak+gas[i]-cost[i]);
            if(currentStreak<0){
                currentStreak=0;
                startIndex=i+1;
            } 
        }
        if(startIndex==len+1) return -1;
        for(int i=0;i<startIndex;i++){
            currentStreak=(currentStreak+gas[i]-cost[i]);
            if(currentStreak<0){
                return -1;
            } 
        }
        return startIndex;
    }
}

        //Leetcode's solution
        //Same runtime as my solution
        //Does not need to do second loop, only get total gas amount and if you find a possible 
        //station and total gas is positive return it
class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;

    int total_tank = 0;
    int curr_tank = 0;
    int starting_station = 0;
    for (int i = 0; i < n; ++i) {
      total_tank += gas[i] - cost[i];
      curr_tank += gas[i] - cost[i];
      // If one couldn't get here,
      if (curr_tank < 0) {
        // Pick up the next station as the starting one.
        starting_station = i + 1;
        // Start with an empty tank.
        curr_tank = 0;
      }
    }
    return total_tank >= 0 ? starting_station : -1;
  }
}