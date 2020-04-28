class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new ArrayList<String>();
        if(s==null || s.length()==0) return res;
        int[] extras=searchExtra(s);
        if(extras[1]==0){
            if(checkValidity(new StringBuilder(s))) res.add(s);
            return res;
        }
        explorePossibilities(new StringBuilder(s),extras[0],extras[1],new HashSet<StringBuilder>(),res);
        return res;
    }
    
    public void explorePossibilities(StringBuilder soFar,int side,int remaining,HashSet<StringBuilder> visited,List<String> res){
        if(remaining==0){
            if(checkValidity(soFar)) res.add(soFar.toString());
            return;
        }
        if(visited.contains(new StringBuilder(soFar))) return;
        visited.add(soFar);
        final int len=soFar.length();
        for(int i=0;i<len;i++){
            if(soFar.charAt(i)==')' || soFar.charAt(i)=='('){
                if(side==0 && soFar.charAt(i)==')'){//side 0, we searching for opening
                    continue;
                }
                if(side==1 && soFar.charAt(i)=='('){//side 1, we searching for closing
                    continue;
                }
                char aux=soFar.charAt(i);
                soFar.delete(i,i+1);
                explorePossibilities(soFar,side,remaining-1,visited,res);
                soFar.insert(i,aux);
            }
        }
    }
    
    public int[] searchExtra(String s){
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
        for(int i=0;i<len/2;i++){
            if(st.charAt(i)=='('){
                stack.add('(');
            }else{
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty()?true:false;
    }
}