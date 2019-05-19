		//My approach using backtracking
		//Good runtime at 1ms better than 95%
		//bad memory at 38mb, better than only 28%
		//Very straightforward, but can be improved
		//Memory usage is improved DRASTICALLY when making recursive method static
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer=new ArrayList<>();
        return generation(answer,n,n,new StringBuilder(""));
        
    }
    
    public List<String> generation(List<String> result,int left,int right,StringBuilder generated){
        if(left == 0 && right == 0){
            result.add(generated.toString());
        }
        if(left>0){
            generation(result,left-1,right,new StringBuilder(generated).append("("));
        }
        if(right-1>=left && right>0){
            generation(result,left,right-1,new StringBuilder(generated).append(")"));
        }
        return result;
    }
}

		//Improved Solution
		//Same backtracking approach, small changes to improve runtime and memory
		//Only change to runtime was adding n==0 check
		//Bigger change to memory was making method static, as for the rest
		//leetcode measurements are not very exact so i don't know how big impact 
		//they have, sometimes it was more or sometimes less
		//Going from 0 to n for right and left appears to be big change
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer=new ArrayList<>();
        if (n == 0) return answer;
        StringBuilder sb = new StringBuilder();
        dfs(n, sb, answer, 0, 0);
        return answer;
    }
    
    private static void dfs(int n, StringBuilder sb, List<String> res, int left, int right) {
        if (2 * n == left + right) {
            res.add(sb.toString());
            return;
        }
        //left
        if (left < n ) {
            sb.append('(');
            dfs(n, sb, res, left + 1, right);
            sb.setLength(sb.length() - 1);
        }
        //right
        if (right < left) {
            sb.append(')');
            dfs(n, sb, res, left, right + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}