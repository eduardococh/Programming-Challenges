class Solution {
    public String reverseVowels(String s) {
        StringBuilder manipulable=new StringBuilder(s);
        int start=0,end=s.length()-1;
        Character[] vows={'a','e','i','o','u','A','E','I','O','U'};
        Set<Character> vowels=new HashSet(Arrays.asList(vows));
        boolean st=false,ed=false;
        while(start<end){
            if(vowels.contains(s.charAt(start))){
                st=true;
            }else{
                st=false;
                start++;
            }
            if(vowels.contains(s.charAt(end))){
                ed=true;
            }else{
                ed=false;
                end--;
            }
            if(st==true && ed==true){
                char aux=s.charAt(start);
                manipulable.replace(start,start+1,s.charAt(end)+"");
                manipulable.replace(end,end+1,aux+"");
                st=false;
                ed=false;
                start++;
                end--;
            }
        }
        return manipulable.toString();
    }
}