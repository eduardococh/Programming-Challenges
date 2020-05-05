class Solution {
    public boolean isStrobogrammatic(String num) {
        HashSet<Character> invalids=new HashSet<>(Arrays.asList('2','3','4','5','7'));
        HashSet<Character> valids=new HashSet<>(Arrays.asList('0','1','8'));
        final int len=num.length();
        for(int i=0;i<len/2;i++){
            if(i==len-i){
                if(valids.contains(num.charAt(i))) return true;
                return false;
            }
            if(invalids.contains(num.charAt(i)) || invalids.contains(num.charAt(len-i-1))){
                return false;
            }
            if(valids.contains(num.charAt(i)) && num.charAt(i)==num.charAt(len-i-1)){
                continue;
            }
            if(num.charAt(i)=='6' && num.charAt(i)=='9'){
                continue;
            }
            if(num.charAt(i)=='9' && num.charAt(i)=='6'){
                continue;
            }
            return false;
        }
        return true;
    }
}