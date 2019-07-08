class Solution {
    public char findTheDifference(String s, String t) {
        if(t.length()==0) return '?';
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        for(int i=0;i<s.length();i++){
            if(sArr[i]!=tArr[i]){
                return tArr[i];
            }
        }
        return tArr[t.length()-1];
    }
}