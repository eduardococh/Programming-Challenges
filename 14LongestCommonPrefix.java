class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        int minLength=Integer.MAX_VALUE;
        for(String str:strs){
            if(str.length()<minLength){
                minLength=str.length();
            }
        }
        String prefix="";
        for(int i=0;i<minLength;i++){
            char currentChar=strs[0].charAt(i);
            for(String str:strs){
                if(str.charAt(i)!=currentChar){
                    return prefix;
                }
            }
            prefix=prefix+currentChar;
        }
        return prefix;
    }
}