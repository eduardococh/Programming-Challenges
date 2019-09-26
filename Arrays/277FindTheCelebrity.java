        //My solution
public class Solution extends Relation {
    public int findCelebrity(int n) {
        HashSet<Integer> isNotCel=new HashSet<Integer>();
        for(int i=0;i<n;i++){
            //System.out.println("in "+i);
            int j;
            for(j=0;j<n;j++){
                if(i==j) continue;
                if(knows(i,j)){
                    //I know j, I can't be celebrity
                    //System.out.println(i+" knows "+j);
                    break;
                }
                if(!knows(j,i)){
                    //j do not knows me, I can not be a celebrity
                    //System.out.println(i+" is not known by "+j);
                    break;
                }
            }
            if(j==n) return i;
        }
        return -1;
    }
}