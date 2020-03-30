       /*
        *   My solution using hashmap (better brute force as defined by leetcode)
        *   Amazing runtime better than 99.17% O(M*N) where M is num1 and N num2 
        *   Bad runtime better than only 7.41% O(N) 
        */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        final int len2=nums2.length,len1=nums1.length;
        int result[]=new int[len1];
        if(len1==0 || len2==0) return result;
        HashMap<Integer,Integer> indexes=new HashMap<>();
        for(int i=0;i<len2;i++){
            indexes.put(nums2[i],i);
        }
        for(int i=0;i<len1;i++){
            boolean found=false;
            for(int j=indexes.get(nums1[i])+1;j<len2;j++){
               if(nums2[j]>nums1[i]){
                   found=true;
                   result[i]=nums2[j];
                   break;
               }
            }
            if(!found){
                result[i]=-1;
            }
        }
        return result;
    }
}

        //Stack solution by leetcode
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack < Integer > stack = new Stack < > ();
        HashMap < Integer, Integer > map = new HashMap < > ();
        int[] res = new int[findNums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > stack.peek())
                map.put(stack.pop(), nums[i]);
            stack.push(nums[i]);
        }
        while (!stack.empty())
            map.put(stack.pop(), -1);
        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }
}