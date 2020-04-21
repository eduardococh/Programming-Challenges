        //My solution using HashMap
        //Average runtime of 3ms better than 51.19% O(M+N)
        //Bad memory better than only 45% O(M+N)
        //Not terrible, but can be more elegant (see second example)
lass Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length==0 || nums2.length==0) return new int[0];
        HashMap<Integer,Integer> counter1=new HashMap<>(),counter2=new HashMap<>();
        final int len1=nums1.length;
        final int len2=nums2.length;
        for(int i=0;i<len1;i++){
            if(counter1.containsKey(nums1[i])){
                counter1.put(nums1[i],counter1.get(nums1[i])+1);
            }else{
                counter1.put(nums1[i],1);
            }
        } 
        for(int i=0;i<len2;i++){
            if(counter2.containsKey(nums2[i])){
                counter2.put(nums2[i],counter2.get(nums2[i])+1);
            }else{
                counter2.put(nums2[i],1);
            }
        } 
        ArrayList<Integer> result=new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer> entry:counter1.entrySet()){
            if(counter2.containsKey(entry.getKey())){
                int min=entry.getValue()<counter2.get(entry.getKey())?entry.getValue():counter2.get(entry.getKey());
                for(int i=0;i<min;i++){
                    result.add(entry.getKey());   
                }
            }
        }
        int res[]=new int[result.size()];
        int i=0;
        for(Integer num:result){
            res[i++]=num;
        }
        return res;
    }
}

        //HashMap solution, more elegant than my approach
        //Same time complexity, only here we cleverly handle the second loop
        //Where i used two hashmaps here they only use one, fill it with nums1, and in nums two decrease
        //every appearence in the hashmap, add to arraylist, finally send to an array
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] result = new int[list.size()];
        int cnt = 0;
        for(int i : list){
            result[cnt++] = i;
        }
        return result;
    }
}


        //Solution using sorting from leetcode solution
        //Overwrites input array and creates a solution only with nums that are equal
        //Sorting solutions are the best ones
        //Amazing runtime of 2ms better than 97.66% O(M Log (M) + N Log (N))
        //
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0, j = 0, k = 0;
    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] < nums2[j]) {
            ++i;
        } else if (nums1[i] > nums2[j]) {
            ++j;
        } else {
            nums1[k++] = nums1[i++];
            ++j;
        }
    }
    return Arrays.copyOfRange(nums1, 0, k);
}
}