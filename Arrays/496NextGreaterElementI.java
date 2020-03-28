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