        //My solution using chain of ifs and hashsets
        //Amazing runtime 0ms better than 100% O(N)
        //Bad memory better than only 8% O(1)
        //Good simple solution
class Solution {
    public boolean isStrobogrammatic(String num) {
        HashSet<Character> invalids=new HashSet<>(Arrays.asList('2','3','4','5','7'));
        HashSet<Character> valids=new HashSet<>(Arrays.asList('0','1','8'));
        final int len=num.length();
        
        for(int i=0;i<=len/2;i++){
            if(i==len-i-1){
                if(valids.contains(num.charAt(i))) return true;
                return false;
            }
            if(invalids.contains(num.charAt(i)) || invalids.contains(num.charAt(len-i-1))){
                return false;
            }
            if(valids.contains(num.charAt(i)) && num.charAt(i)==num.charAt(len-i-1)){
                continue;
            }
            if(num.charAt(i)=='6' && num.charAt(len-i-1)=='9'){
                continue;
            }
            if(num.charAt(i)=='9' && num.charAt(len-i-1)=='6'){
                continue;
            }
            return false;
        }
        return true;
    }
}

        //Elegant and simpler solution
        //Same runtime and memory as my solution
class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
    
        int l = 0, r = num.length() - 1;
        while (l <= r) {
            if (!map.containsKey(num.charAt(l))) return false;
            if (map.get(num.charAt(l)) != num.charAt(r))
                return false;
            l++;
            r--;
        }
        
        return true;
    }
}