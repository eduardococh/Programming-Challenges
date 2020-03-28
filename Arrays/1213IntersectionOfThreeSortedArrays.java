        //My one pass solution
        //Amazing runtime of 1ms better than 100% O(N)
        //Amazing memory better than 100% O(1)
        //Could be more elegant but the general approach is good
class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        final int len1=arr1.length,len2=arr2.length,len3=arr3.length;
        List<Integer> result=new ArrayList<>();
        int i=0,j=0,k=0,max=0;
        while(i<len1 && j<len2 && k<len3){
            if(arr1[i]==arr2[j] && arr2[j]==arr3[k]){
                result.add(arr1[i]);
                i++;
                j++;
                k++;
                continue;
            }
            if(arr1[i]>=max){
                max=arr1[i];
            }else{
                i++;
            }
            if(arr2[j]>=max){
                max=arr2[j];
            }else{
                j++;
            }
            if(arr3[k]>=max){
                max=arr3[k];
            }else{
                k++;
            }
        }
        return result;
    }   
} 