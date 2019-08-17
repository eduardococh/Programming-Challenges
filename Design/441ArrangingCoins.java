class Solution {
    public int arrangeCoins(int n) {
        long stair=1,i=0;
        while(i<n){
            i+=stair;
            stair++;
        }
        stair--;
        if(i==n) return (int)stair;
        //System.out.println(stair);
        return (int)stair-1;
    }
}