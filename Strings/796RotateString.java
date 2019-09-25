class Solution {
    public boolean rotateString(String A, String B) {
        if(A.length()==0 && B.length()==0) return true;
        if(A.length()!=B.length()) return false;
        int startA=-1;
        final int lengths=A.length();
        for(int i=0;i<lengths;i++){
            if(A.charAt(i)==B.charAt(0)){
                if(tryStart(i,A,B,lengths)) return true;
            }
        }
        return false;
    }
    
    public boolean tryStart(int startA,String A, String B, int lengths){
        int startB=0;
        while(startA<lengths){
            if(A.charAt(startA++)!=B.charAt(startB++)){
                return false;
            }
        }
        startA=0;
        while(startB<lengths){
            if(A.charAt(startA++)!=B.charAt(startB++)){
                return false;
            }
        }
        return true;
    }
}