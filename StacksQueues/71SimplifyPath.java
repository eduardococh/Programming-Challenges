        //Solution by leetcode's davidluoyes
        //Runtime of 3ms better than 97.63% O(N)
        //BAd memory better than only 6.67%
        //Usage of Queue class is recommended over usage of stack class 
        //First, split array by slashed
        //Second, loop through result and if an element is
        //double point, remove next element, if empty or point, do nothing
        //else add to stack
        //Finally, remove all elements and add into stringBuilder
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for(String s: path.split("/")){
            if(s.equals("..") ) stack.poll();
            else if(!s.equals("") && !s.equals(".")) stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        if(stack.size() == 0) return "/";
        while(stack.size() != 0) sb.append("/").append(stack.pollLast());
        return sb.toString();
    }
}    

        /*
        * My solution using string builder and three passes
        * Average runtime at 6ms better than 49.91% O(N) (three pases through the string)
        * Bad memory better than only 6.67% O(N)
        * Not a terrible solution, but it does not use data structures that fit the problem
         */
class Solution {
    public String simplifyPath(String path) {
        if(path.equals("")) return "/";
        StringBuilder cleanSlashes=cleanSlashes(path);
        StringBuilder cleanDots=cleanDots(cleanSlashes);
        StringBuilder result=cleanDoubleDots(cleanDots);
        if(result.toString().equals("")) return "/";
        return result.toString();
    }
    
    public StringBuilder cleanDoubleDots(StringBuilder cleanDots){
        StringBuilder result=new StringBuilder("");
        String[] arr = cleanDots.toString().split("/");
        final int len=arr.length;
        int pendingReverse=0;
        for(int i=len-1;i>0;i--){
            if(arr[i].length()>0){
                if(arr[i].equals("..")){
                    pendingReverse++;
                }else{
                    if(pendingReverse>0){
                        pendingReverse--;
                    }else{
                        result.insert(0,'/'+arr[i]);    
                    }
                }
            }
        }
        return result;
    }
    
    public StringBuilder cleanDots(StringBuilder cleanSlashes){
        StringBuilder result=new StringBuilder("");
        String[] arr = cleanSlashes.toString().split("/");
        for(String st:arr){
            if(st.length()>0){
                if(!st.equals(".")){
                    result.append("/"+""+st);
                }
            }
        }
        return result;
    }
    
    public StringBuilder cleanSlashes(String path){
        StringBuilder result=new StringBuilder("");
        char[] pathArr=path.toCharArray();
        final int len=pathArr.length;
        for(int i=0;i<len;i++){
            if(pathArr[i]!='/'){
                result.append(pathArr[i]);
            }else{
                while(i<len && pathArr[i]=='/'){
                    i++;
                }
                result.append('/');
                i--;
            }
        }
        if(result.charAt(result.length()-1)=='/'){
            result.setLength(result.length()-1);
        }
        return result;
    }
}   