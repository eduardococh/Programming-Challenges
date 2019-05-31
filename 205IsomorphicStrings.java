		//My solution
		//Bad at 17 ms better than only 17%
		//Mid memory at 35.3mb, less than 83.70%
		//
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> myMapS=new HashMap<>();
        HashMap<Character,Character> myMapT=new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            if(myMapS.containsKey(s.charAt(i))){
                if(myMapS.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }else{
                myMapS.put(s.charAt(i),t.charAt(i));
            }
            
            if(myMapT.containsKey(t.charAt(i))){
                if(myMapT.get(t.charAt(i))!=s.charAt(i)){
                    return false;
                }
            }else{
                myMapT.put(t.charAt(i),s.charAt(i));
            }
        }
        return true;
    }
}

		//From leetcode's sample 1ms solution	
		//Great runtime at 1ms, better than 100% o(n)
		//average memory at 36.5mb less than 67% o(n)
		//Use of array, no need to hashmap (a supposition on a basic ascii is needed, otherwise hashmap
		//works for an unknown charset), just use two arrays
class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        char[] chss = s.toCharArray();
        char[] chst = t.toCharArray();

        char[] chs = new char[256];
        char[] cht = new char[256];

        for(int i = 0; i < chss.length; i++){

            char cs = chss[i];
            char ct = chst[i];
	    //if both are unassigned, assign them to each other
            if(chs[cs] == 0 && cht[ct] == 0){
                chs[cs] = ct;
                cht[ct] = cs;
            }else{
		//If one or the other caracter already have an assignment, and it is not what we expect, false
                if(chs[cs] != ct || cht[ct] != cs){
                    return false;
                }
            }

        }
        return true;
    }
}