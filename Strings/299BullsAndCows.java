        //Very simple problem
        //Simple approach, self explained
        //Amazing runtime at 1ms faster than 100% O(N)
        //Good memory better than 92.11% O(1)
class Solution {
    public String getHint(String secret, String guess) {
        final int length=secret.length();
        int bulls=0,cows=0;
        int guessA[]=new int[26];
        int guessS[]=new int[26];
        for(int i=0;i<length;i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bulls++;
                continue;
            }
            guessA[guess.charAt(i)-'0']++;
            guessS[secret.charAt(i)-'0']++;
        }
        for(int i=0;i<26;i++){
            if(guessA[i]>0 && guessS[i]>0){
                cows+=Math.min(guessS[i],guessA[i]);    
            }
        }
        return bulls+"A"+cows+"B";
    }
}