class Solution {
		//My solution, took me looooong to be an easy one
		//But a great solution (could be clearer), better than 100 in runtime, at O(N)
		//Memory wise better than 95% so great too, O(1)
    public int removeElement(int[] nums, int val) {
        int res=0,badPointer=-1;
        for(int i=0;i<nums.length;i++){
            if(badPointer!=-1){
                if(nums[i]==val){
                    
                }else{
                    res++;
                    nums[badPointer]=nums[i];
                    badPointer++;
                }
            }else{
                if(nums[i]==val){
                    badPointer=i;
                }else{
                    res++;
                }
            }
            
        }
        return res;
    }
}

		//Two pointers solution by leetcode
		//Simple o(n) time and o(1) space, but if there's a small number of elements
		//to remove it's not very optimal

public int removeElement(int[] nums, int val) {
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
        if (nums[j] != val) {
            nums[i] = nums[j];
            i++;
        }
    }
    return i;
}

		//Two pointer when elements to remove are rare
		//Lil bit more complex but handles this case more optimally
		//o(n) time and o(1) complexity

public int removeElement(int[] nums, int val) {
    int i = 0;
    int n = nums.length;
    while (i < n) {
        if (nums[i] == val) {
            nums[i] = nums[n - 1];
            // reduce array size by one
            n--;
        } else {
            i++;
        }
    }
    return n;
}