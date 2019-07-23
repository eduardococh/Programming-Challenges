class Solution {    
    
    public int numDecodings(String s) {
        if(s.length()==0 || s.charAt(0)=='0') return 0;
        StringBuilder processedSt=new StringBuilder(s);
        List<Integer> beforeZerosToBeDeleted=new ArrayList<Integer>();
        for(int i=1;i<s.length();i++){
            //System.out.println("before on "+i+" "+s.charAt(i));
            if(s.charAt(i)<=48){
                if(s.charAt(i-1)<=48  || s.charAt(i-1)>=51){
                    return 0;
                }else{
                    beforeZerosToBeDeleted.add(i);
                }
            }
        }
        int shorter=0;
        for(Integer index:beforeZerosToBeDeleted){
            processedSt.deleteCharAt(index-shorter-1);
            shorter++;
        }
        //System.out.println(processedSt.toString());
        return checkCombinations(processedSt,1,0);
    }
    
    public int checkCombinations(StringBuilder s, int result,int start/*,boolean zero*/){
        for(int i=start;i<s.length();i++){
            //System.out.println(i+" we testing "+s.charAt(i));
            /*if(i+2<s.length() && s.charAt(i+2)==48){
                continue;
            }*/
            if(s.charAt(i)==48 || (i+1<s.length() && s.charAt(i+1)==48)){
                continue;
            }
            //System.out.println("we try "+i);
            if(i+1<s.length() && s.charAt(i)<51 && (s.charAt(i)==49 || (s.charAt(i)==50 && s.charAt(i+1)<=54))){
                
                /*if(s.charAt(i+1)==48){
                    if(!zero){
                        System.out.println("we add "+i);
                        result++;
                    }
                    result=checkCombinations(new StringBuilder(s),result,i+2,true);
                    break;
                }else{*/
                //System.out.println("we add "+i);
                result++;
                result=checkCombinations(s,result,i+2);
                /*}*/
            }
        }
        return result;
    }
}