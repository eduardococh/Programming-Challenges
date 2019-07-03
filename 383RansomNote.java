class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()){
            return false;
        }
        int letters[]=new int[26];
        for(int i=0;i<magazine.length();i++){
            letters[magazine.charAt(i)-97]++;
        }
        for(int i=0;i<ransomNote.length();i++){
            letters[ransomNote.charAt(i)-97]--;
            if(letters[ransomNote.charAt(i)-97]<0){
                return false;
            }
        }
        return true;
    }
}