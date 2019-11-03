        //My solutions using stacks
        //Fast to code, simple to understand
        //Amazing runtime better than 100% O(1) for hit, O(N) for getHits
        //Average runtime at 42.86% O(N)
        //Good enough solution, but could be done better
        //Stack<Integer> data structure
class HitCounter {
    
    private Stack<Integer> keeper;

    /** Initialize your data structure here. */
    public HitCounter() {
        keeper=new Stack<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        keeper.push(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int cont=0;
        Stack<Integer> aux=new Stack<>();
        while(!keeper.isEmpty()){
            if(keeper.peek()>timestamp-300){
                cont++;
            }else{
                break;
            }
            aux.push(keeper.pop());
        }
        while(!aux.isEmpty()){
            keeper.push(aux.pop());
        }
        return cont;
    }
}

        //My aproach using queue
        //Same runtime and memory than stack approach
        //Difference is that in general, you only go through the list
        //one time, either to push or to remove items
        //Huge improvement over the stack solution, problem with this one is
        //that for large inputs queue could take a lot of memory for repeated
        //hits, so better solution is to use a mapping
class HitCounter {
    
    private Queue<Integer> keeper;

    /** Initialize your data structure here. */
    public HitCounter() {
        keeper=new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        keeper.add(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!keeper.isEmpty() && keeper.peek()<=timestamp-300){
            keeper.remove();
        }
        return keeper.size();
    }
}


        //Solution using mapping from leetcode's xuyirui
        //Same runtime and memory as past solutions
        //Constant runtime O(1) because it always does a 300 loop
        //Constant memory because it always saves 300 spaces
        //hit will save the hits up to a point, using the %300
        //so when a new number comes it asks if a position index is the same
        //as the one previously, if not then is overwrites that position
        //getHits is pretty simple, just sum the 300 positions in the array, verifying
        //that is fills the timestamp-300 condition
public class HitCounter {
    private int[] times;
    private int[] hits;
    /** Initialize your data structure here. */
    public HitCounter() {
        times = new int[300];
        hits = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                total += hits[i];
            }
        }
        return total;
    }
}