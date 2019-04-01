class Solution {
	//My great DP solution after 1hr15m, 0ms better than 100%, 35.7mb better than 92.4%
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return (int)Math.max(nums[0],nums[1]);
        int max=Math.max(nums[0],nums[1]),housesN=nums.length;
        int maximumUntilHere[]=new int[nums.length];
        maximumUntilHere[0]=nums[0];
        maximumUntilHere[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<housesN;i++){
            maximumUntilHere[i]=Math.max(maximumUntilHere[i-2]+nums[i],maximumUntilHere[i-1]);
        }
        return maximumUntilHere[housesN-1];
    }
}
	//Way simpler solution by leetcode tusizi
public int rob(int[] num) {
    int[][] dp = new int[num.length + 1][2];
    for (int i = 1; i <= num.length; i++) {
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        dp[i][1] = num[i - 1] + dp[i - 1][0];
    }
    return Math.max(dp[num.length][0], dp[num.length][1]);
}
dp[i][1] means we rob the current house and dp[i][0] means we don't,

so it is easy to convert this to O(1) space

public int rob(int[] num) {
    int prevNo = 0;
    int prevYes = 0;
    for (int n : num) {
        int temp = prevNo;
        prevNo = Math.max(prevNo, prevYes);
        prevYes = n + temp;
    }
    return Math.max(prevNo, prevYes);
}


//No more solutions, heroes3001 in leetcode put a good guide to recursive solution






//Other approachs that i tried and didnt work, so I just keep them for record of my thinking process
//Was robbed approach
/*if(wasRobbed[i-1]){
                if(max-nums[i-1]+nums[i]>max){
                    max=max-nums[i-1]+nums[i];
                    wasRobbed[i]=true;
                    if(i-2>=0){
                        if(i-3!=penultimateAdded && i-1!=penultimateAdded){
                            max=max+nums[i-2];   
                        }
                    }
                    maximumUntilHere[i]=max;
                    penultimateAdded=lastAdded;
                    lastAdded=i;
                }
            }else{
                max=max+nums[i];
                wasRobbed[i]=true;
                maximumUntilHere[i]=max;
                penultimateAdded=lastAdded;
                lastAdded=i;
}*/
//Verify max of below, me and above
/*
maximumUntilHere[0]=max;
        maximumUntilHere[1]=max;
        for(int i=2;i<housesN;i++){
            maximumUntilHere[i]=(int)Math.max(maximumUntilHere[i-2]-nums[i-2]+nums[i-1],Math.max(maximumUntilHere[i-2]+nums[i],));
            if(maximumUntilHere[i]>max){
                max=maximumUntilHere[i];
                System.out.println(i+" Max is now "+max);
            }
        }
*/