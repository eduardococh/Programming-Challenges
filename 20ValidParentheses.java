class Solution {
    public boolean isValid(String s) {
        if(s.length()==0) return true;
        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(stack.size()==0) return false;
                if(stack.pop()=='('){
                    continue;
                }else{
                    return false;
                }
            }
                
            if(s.charAt(i)=='}'){
                if(stack.size()==0) return false;
                if(stack.pop()=='{'){
                    continue;
                }else{
                    return false;
                }
            }

            if(s.charAt(i)==']'){
                if(stack.size()==0) return false;
                if(stack.pop()=='['){
                    continue;
                }else{
                    return false;
                }
            }
            stack.push(s.charAt(i));
        }
        if(stack.size()==0){
            return true;
        }else{
            return false;
        }
    }
}