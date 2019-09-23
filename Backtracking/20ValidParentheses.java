class Solution {
		//My solution, faster than 97% and memory usage better than 37%
		//Complexity o(n)
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

	//Leetcode phoenix13steve, faster than 99% and memory usage better than 37%, more elegant
	//Complexity o(n)
//example {{[})-> this solution puts only closing braces to stack for every open brace, so if a closing brace
//comes it pops one from stack and verifies that it is valid
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
