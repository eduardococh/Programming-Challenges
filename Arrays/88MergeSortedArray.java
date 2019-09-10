class Solution {
	//My first solution, very good runtime 100%, long complex not worth it
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n!=0){
            int mAux=n,cont=0;
            int arrAux[]=new int[m+n];
            while(mAux<n+m){
                arrAux[mAux]=nums1[cont];
                nums1[cont]=0;
                mAux++;
                cont++;
            }
            for(int i=0;i<m+n;i++){
                nums1[i]=arrAux[i];
            }
        }
        int pointer1=n,pointer2=0,assigner=0;
        while(pointer1<m+n || pointer2<n){
            if(pointer1==(m+n)){//Pointer1 in limit
                nums1[assigner]=nums2[pointer2];
                pointer2++;
            }else if(pointer2==(n) ){//Pointer2 in limit
                nums1[assigner]=nums1[pointer1];
                pointer1++;
            }else{
                 if(nums1[pointer1]<nums2[pointer2]){
                    nums1[assigner]=nums1[pointer1];
                    pointer1++;
                }else{
                    nums1[assigner]=nums2[pointer2];
                    pointer2++;
                }
            }
            assigner++;
        }        
    }
}

//fast simple solution, same memory and time as mine
//Tried to get --n,m out of the single line but couldnt because n is called twice in the same line
//first it m+n-1 (original value of n or m) and then in assignation (value minus 1)
//int i = 3;
//int a = i++; // a = 3, i = 4
//int b = ++i; // b = 4, i = 4

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
	while (n > 0) {
	    if(m == 0 || nums2[n-1] > nums1[m-1]){
		nums1[m+n-1]=nums2[--n];
	    }else{
		nums1[m+n-1]=nums1[--m];
	    }
	}
    }
}

//LOW MEMORY USAGE
public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[p--] = nums1[m--];
            } else {
                nums1[p--] = nums2[n--];
            }
        }
        
        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }

        //My solution from Microsoft mock interview, took me 5-8 min and
        //Amazing runtime 0ms better than 100% O(N)
        //Amazing memory 36.1mb better than 100% O(1)
        //Amazing to see the progress from my first solution 6 months ago to 
        //this one, much better, simpler, elegant and amazing runtime/memory
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int write=m+n-1;
        m--;
        n--;
        while(m>=0 || n>=0){
            if(m<0){
                nums1[write--]=nums2[n--];    
            }else if(n<0){
                nums1[write--]=nums1[m--];
            }else{
                nums1[write--]=nums1[m]>nums2[n]?nums1[m--]:nums2[n--];    
            }
        }
    }
}