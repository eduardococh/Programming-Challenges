        //My approach using min heap/priority queue
        //Bad runtime at 10ms better than only 16.80% O(N Log N) because of sorting and
        //because at the worst case we will do N add O(1) and N removals (Log N)
        //Terrible memeory better than only 5% at O(N)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        ///SAVE METHOD
        //Arrays.sort(intervals, (a, b) -> (if(a[0]==b[0]){Double.compare(a[0], b[0])}));
        Arrays.sort(intervals, Comparator.<int[]>comparingInt(o -> o[0]).thenComparingInt(o -> o[1]));
        //By default min heap
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int max=0;
        for(int[] interval:intervals){
            while(!pq.isEmpty() && pq.peek()<=interval[0]){
                pq.poll();
            }
            pq.add(interval[1]);
            if(pq.size()>max){
                max=pq.size();
            }
        }
        return max;
    }
}


        //Super simple solution using two sorted arrays
        //trick is we separate start and end times, making meetings no sense
        //if the meeting at the end index is not over add one to result
        //This is not a solution someone would get at an interview I think, since sorting the arrays
        //start and end breaks the relation and it's not very logical
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] begins = new int[intervals.length];
        int[] ends = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i++) {
            begins[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        
        Arrays.sort(begins);
        Arrays.sort(ends);
        int res = 0;
        int ei = 0;
        for (int i = 0; i < begins.length; i++) {
            if (begins[i] < ends[ei]) {
                res++; 
            } else {
                ei++;
            }
        }
        return res;  
    }
}