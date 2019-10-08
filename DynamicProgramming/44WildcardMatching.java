        //My Solution
        //Works but time limit exceeded
class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length()==1 && p.charAt(0)=='*') return true;
        int indexS=0,indexP=0;
        int sLen=s.length(),pLen=p.length();
        while(indexS<sLen && indexP<pLen){
            
            
            //match one single character
            if(p.charAt(indexP)=='?'){
                indexP++;
                indexS++;
                
                
            //match a sequence of characters
            }else if(p.charAt(indexP)=='*'){
                
                indexP++;
                //count wildcards, this could combine  *?*??, the rules are simple
                //once a * is found any other star found in a group is irrelevant
                //the important thing is to count the number of ? signs
                while(indexP<pLen && (p.charAt(indexP)=='*' || p.charAt(indexP)=='?')){
                    if(p.charAt(indexP)=='?'){
                        indexS++;
                    }
                    indexP++;
                }
                if(indexP==pLen && indexS==sLen) return true;
                if(indexS>=sLen) return false; //s does not have enough characters to match
                if(indexP==pLen) return true; //wildcard matched
                
                char nextChar=p.charAt(indexP);
                
                while(indexS<sLen){
                    if(s.charAt(indexS)==nextChar){
                        //indexS++;
                        //indexP++;
                        //System.out.println("tsting s "+s.substring(indexS+1,sLen));
                        //System.out.println("tsting p "+p.substring(indexP+1,pLen));
                        if(isMatch(s.substring(indexS+1,sLen),p.substring(indexP+1,pLen))) return true;
                    }
                    indexS++;
                }
                
                //if I finished S and nextChar is not matched
                if(indexS==sLen) return false;
                //
                //if(index)
                
            //match characters one to one
            }else{
                if(s.charAt(indexS)!=p.charAt(indexP)){
                    return false;
                }else{
                    indexP++;
                    indexS++;
                }
            }
        }
        while(indexP<pLen && p.charAt(indexP)=='*') indexP++;
        if(indexS!=sLen || indexP!=pLen) return false;
        return true;
    }
}