        //My solution
        //Bad runtime of 90ms faster than only 14.13% O(2^N)
        //Good memory better than 79.35% O(N) 
        //Can be greatly improved by using the commented searchExtra method go get the extra parenthesis
        //(view solution two from leetcode)

        //DO NOT use a set of stringbuilders, as it wont behave as expected
class Solution {
    
    private int minimumLength=0;
    
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new ArrayList<String>();
        if(s==null || s.length()==0){
            res.add("");
            return res;    
        }
        //int[] extras=searchExtra(s);
        /*if(extras[1]==0){
            if(checkValidity(new StringBuilder(s))) res.add(s);
            return res;
        }*/
        explorePossibilities(new StringBuilder(s)/*,extras[0],extras[1]*/,new HashSet<String>(),res);
        return res;
    }
    
    public void explorePossibilities(StringBuilder soFar/*,int side,int remaining*/,HashSet<String> visited,List<String> res){
        if(visited.contains(soFar.toString())) return;
        if(soFar.length()<minimumLength) return;
        if(checkValidity(soFar)){
            if(soFar.length()>minimumLength){
                    res.clear();
                    minimumLength=soFar.length();
                    //and keep searching for solutions at least as big as me
                    //no smaller solutions (so if a method enters here it will have no children)
            }   
            res.add(soFar.toString());
        }
        //System.out.println("processing "+soFar);
        //
        visited.add(soFar.toString());
        final int len=soFar.length();
        for(int i=0;i<len;i++){
            if(soFar.charAt(i)==')' || soFar.charAt(i)=='('){
                /*if(side==0 && soFar.charAt(i)==')'){//side 0, we searching for opening
                    continue;
                }
                if(side==1 && soFar.charAt(i)=='('){//side 1, we searching for closing
                    continue;
                }*/
                char aux=soFar.charAt(i);
                soFar.delete(i,i+1);
                explorePossibilities(soFar,visited,res);
                soFar.insert(i,aux);
            }
        }
        //System.out.println("we done "+soFar);
    }
    
     public boolean checkValidity(StringBuilder st){
        int len=st.length();
        StringBuilder copy=new StringBuilder(st);
        for(int i=0;i<len;i++){
            if(copy.charAt(i)!=')' && copy.charAt(i)!='('){
                copy.delete(i,i+1);
                len--;
                i--;
            }
        }
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<len;i++){
            if(copy.charAt(i)=='('){
                //System.out.println("we push "+copy.charAt(i));
                stack.add('(');
            }else{
                //System.out.println("we pop? "+stack.isEmpty());
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty()?true:false;
    }
    
 /*   public int[] searchExtra(String s){
        int opening=0,closing=0;
        for(char c:s.toCharArray()){
            if(c=='(') opening++;
            if(c==')') closing++;
        }
        int res[]=new int[2];
        res[0]=opening>closing?0:1;
        res[1]=Math.abs(opening-closing);
        return res;
    }
*/    
}


        //A lot of very clever solutions should be explored