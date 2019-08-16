        //My solution
        //Good i think, simple
        //Amazing runtime better than 100% O(N)
        //Amazing memory better than 100% O(1)
class Solution {
    public int countSegments(String s) {
        if(s.equals("")) return 0;
        boolean inSequence=false;
        int res=0;
        
        for(char car:s.toCharArray()){
            if(car==' '){
                if(inSequence){
                    res++;
                    inSequence=false;
                }
            }else{
                inSequence=true;
            }
        }
        if(inSequence) res++;
        return res;
    }
}

        //Another approach from sample O'ms
        //I prefer my approach
class Solution {
    public int countSegments(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }

        int count = 0;
        if (s.charAt(0) != ' ') {
            ++count;
        }
        for (int i = 0; i != s.length() - 1; i++) {
            if (' ' == s.charAt(i) && s.charAt(i) - s.charAt(i + 1) != 0) {
                ++count;
            }
        }

        return count;
    }
}

        //The simple approach using split
        //The thing that I lacked when I tried is seg.isEmpty, so when there's more
        //than 1 space split will save a string with empty space
class Solution {
    public int countSegments(String s) {
        int count = 0;
        for(String seg: s.split(" "))
            if(!seg.isEmpty())
                count++;
       return count; 
    }
}