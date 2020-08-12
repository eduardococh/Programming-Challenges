        //DP Solution
        //Good runtime of O(M*N)
        //Goor memory of O(M*N)
        //More to write about this one
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp=new Integer[text1.length()][text2.length()];
		int res=0;
		for(int i=text1.length()-1;i>=0;i--){
			for(int j=text2.length()-1;j>=0;j--){
				int localRes=longestCommonSubsequence(text1,text2,i,j,dp);
				if(localRes>res) res=localRes;
			}
		}
		return res;
    }
	
	public static int longestCommonSubsequence(String str1, String str2,int index1,int index2,Integer[][] dp){
		if(index1==str1.length() || index2==str2.length()) return 0;
        if(dp[index1][index2]!=null) return dp[index1][index2];
		
		int withoutMe=longestCommonSubsequence(str1,str2,index1+1,index2,dp);
		int index2original=index2;
        
		while(index2<str2.length() && str2.charAt(index2)!=str1.charAt(index1)){
			index2++;
		}
		int withMe=0;
		if(index2<str2.length() && str2.charAt(index2)==str1.charAt(index1)){
			withMe=longestCommonSubsequence(str1,str2,index1+1,index2+1,dp);
			withMe++;
		}
		
		int longestSequence=withMe>withoutMe?withMe:withoutMe;
        dp[index1][index2original]=longestSequence;
		return longestSequence;
	}
}