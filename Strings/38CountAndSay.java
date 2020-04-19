class Solution {
		//My solution, not really good
		//Beats 23% in runtime, memory beats 10.27
		//O(n2) and memory o(n)
    public String countAndSay(int n) {
        String sequence="1";
        for(int i=1;i<n;i++){
            String tempSequence="";
            for(int j=0;j<sequence.length();j++){
                char currentChar=sequence.charAt(j);
                int currentCount=0;
                while(j<sequence.length() && sequence.charAt(j)==currentChar){
                    currentCount++;
                    j++;
                }
                j--;
                tempSequence=tempSequence+currentCount+currentChar;
            }
            sequence=tempSequence;
        }
        return sequence;
    }
}

class Solution {
		//Sample solution from leetcode
		//Way better than mine beating 99.72 in runtime and 99.84 in memory
		//Trick is to start counter in 1 and in next loop add it
    public String countAndSay(int n) {
        if(n == 1) return "1";
        StringBuilder build = new StringBuilder("1");
        
        for(int i = 1; i < n; i++) {
            String word = build.toString();
            build.setLength(0);
            
            char curChar = ' ';
            int count = 0;
            for(int x = 0; x < word.length(); x++) {
                if(curChar == word.charAt(x)) {
                    count++;
                } else {
                    if(count != 0) {
                        build.append(count).append(curChar);
                    }
                    curChar = word.charAt(x);
                    count = 1;
                }
            }
            build.append(count).append(curChar);
        } 
        return build.toString();
    }
}