        //My solution
        //Good runtime 1ms better than 65.77%
        //Bad memory better than only 6%
        //EQUALS does not work for StringBuilder, use compareTo methods
class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder sNew=new StringBuilder("");
        StringBuilder tNew=new StringBuilder("");
        char sArr[]=S.toCharArray();
        char tArr[]=T.toCharArray();
        int skipCounter=0;
        for(int i=S.length()-1;i>=0;i--){
            if(sArr[i]=='#'){
                skipCounter++;
            }else{
                if(skipCounter>0) {
                    skipCounter--;
                    continue;
                }
                sNew.append(sArr[i]);
            }
        }
        skipCounter=0;
        for(int i=T.length()-1;i>=0;i--){
            if(tArr[i]=='#'){
                skipCounter++;
            }else{
                if(skipCounter>0) {
                    skipCounter--;
                    continue;
                }
                tNew.append(tArr[i]);
            }
        }
        return sNew.compareTo(tNew) == 0;
    }
}


        //0ms approach
        //handle string in separate methods
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return compare(S).equals(compare(T));
    }
    
    private String compare(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                sb.append(s.charAt(i));
            } else if (sb.length() != 0 && s.charAt(i) == '#') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}