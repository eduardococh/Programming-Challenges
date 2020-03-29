		//My solution
		//Good runtime at 2ms better than 98.16% O(M+N)
		//Good memory better than 82.54% O(min(m,n))
		//Simple approach, put them on a set and verify if it appears
		//Leetcode suggests a similar approach where they fill two arrays and they run in
		//same memory and time, i prefer mine
		//Solutions faster than 2ms in leetcode's samples are not trivial and 
		//complex so not going to cover them
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            if(!set.contains(nums1[i])){
                set.add(nums1[i]);
            }
        }
        Set<Integer> result=new HashSet<>();
        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }
        int[] result2=new int[result.size()];
        int i=0;
        for(Integer num:result){
            result2[i]=(int)num;
            i++;
        }
        return result2;
    }
}

		//Leetcode's solution using java built in intersection function
		//Average runtime at 3ms better than only 40%
		//Good memory better than 82%
		//Leetcode's and my simple approach are better

		//Key is to learn (((( retainAll() method ))))

class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<Integer>();
    for (Integer n : nums1) set1.add(n);
    HashSet<Integer> set2 = new HashSet<Integer>();
    for (Integer n : nums2) set2.add(n);

    set1.retainAll(set2);

    int [] output = new int[set1.size()];
    int idx = 0;
    for (int s : set1) output[idx++] = s;
    return output;
  }
}