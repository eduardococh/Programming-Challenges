class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (if(a[0]==b[0]){Double.compare(a[0], b[0])}));
        return 0;
    }
}