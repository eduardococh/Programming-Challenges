        //My approach using min heap/priority queue
        //Bad runtime at 10ms better than only 16.80% O(N Log N) because of sorting and
        //because at the worst case we will do N add O(1) and N removals (Log N)
        //Terrible memeory better than only 5% at O(N)
        //
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //Arrays.sort(intervals, (a, b) -> (if(a[0]==b[0]){Double.compare(a[0], b[0])}));
        //sort by two columns
        int result=0;
        Arrays.sort(intervals, java.util.Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));
        PriorityQueue<Integer> meetingRooms=new PriorityQueue<Integer>();
        for(int[] meeting:intervals){
            if(meetingRooms.isEmpty()){
                meetingRooms.add(meeting[1]);
            }else{
                while(!meetingRooms.isEmpty() && meetingRooms.peek()<=meeting[0]){//remove all meetings until my start   
                    meetingRooms.poll();
                }
                meetingRooms.add(meeting[1]);
            }
            
            if(meetingRooms.size()>result) result = meetingRooms.size();
        }
        return result;
    }
}


        //Super simple solution using two sorted arrays
        //trick is we separate start and end times, making meetings no sense
        //if the meeting at the end index is not over add one to result
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