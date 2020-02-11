        //My solution
        //Amazing runtime of 0ms better than 100%
        //Bad memory better than only 5%
        //Simple problem, improvement might be not using to char array method
class Solution {
    public boolean checkRecord(String s) {
        int ACount=0;
        int lateCount=0;
        for(char car:s.toCharArray()){
            
            if(car=='A') ACount++;
            if(car=='L'){
                lateCount++;
            }else{
                lateCount=0;
            }
            
            if(ACount==2) return false;
            if(lateCount==3) return false;
        }
        return true;
    }
}