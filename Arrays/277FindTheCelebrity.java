        //My solution
        //Bad runtime at 8ms better than 29.00% O(N)
        //Average memory at 45.7mb better than 56.25% O(1)
        //Not terrible but no good, not really any good logic, just know when to break
public class Solution extends Relation {
    public int findCelebrity(int n) {
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

        //Two pass solution
        //Amazing runtime at 0ms better than 100% O(N)
        //Average memory better than 56% O(1)
        //Brilliant algorithm, I'll explain below

        //FIRST LOOP is to find our probable candidate, let's say from 100 persons we end
        //with 71 as candidate, we start with 0 and for every number we 

        //A)Know it, in this case this new N could be a celebrity, 
        //  and we N don't (since we know someone) so we switch celebrity
        //B)Don't know it, in this case N number can not be celebrity since we dont know it

        //Then we reach 71, if this is really our celebrity this number will not know any other
        //number after 71, since that is the definition of celebrity, and there is only one celebrity

        //The second loop is for verification, since there might not be any celebrity
public class Solution extends Relation {
    public int findCelebrity(int n) {
        //Special case where two persons do not know each other (no celebrity)
        if (n == 2 && !knows(0, 1) && !knows(1, 0)) return -1;
        
        int candidate = 0;
        for (int i = 1; i < n; i++)
            if (knows(candidate, i)) candidate = i;
        
        for (int i = 0; i < candidate; i++) 
            if (knows(candidate, i)) return -1;
            
        return candidate;
    }
}

        //My two pass solution
        //Missed some details from the original one, so its not
        //the most elegant or best runtime
        //Buuut solution above while faster does consider a special case
        //My solution works for all cases (and in an interview i believe this
        //would be more welcome than using if for special case, but i dont know)
        //Amazing runtime at 6ms better than 97.37% O(N)
        //Good memory better than 58.33%
public class Solution extends Relation {
    public int findCelebrity(int n) {
        
        int celebrity=0;
        for(int candidate=1;candidate<n;candidate++){
            if(knows(celebrity,candidate)){
                celebrity=candidate;
            }
        }
        for(int i=0;i<n;i++){
            if(i!=celebrity && (!knows(i,celebrity) || knows(celebrity,i))){
                return -1;
            }
        }
        return celebrity;
    }
}